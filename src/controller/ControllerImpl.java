package controller;

import controller.command.AddPlayerPiece;
import controller.command.Attack;
import controller.command.CreateGraphicalWorld;
import controller.command.DisplayPlayerDescription;
import controller.command.MovePet;
import controller.command.PlayerLookAround;
import controller.command.PlayerMove;
import controller.command.PlayerPickItem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.World;
import view.View;

/**
 * This class represents a controller that will talk to the model and subsequently work with it to
 * help us in performing operations with the model.
 */
public class ControllerImpl implements Controller {
  private World world;
  private View view;
  private AddPlayerPiece addPlayerPieceCommand;
  private PlayerPickItem playerPickItem;
  private CreateGraphicalWorld createGraphicalWorld;
  private PlayerMove playerMove;
  private PlayerLookAround playerLookAround;
  private MovePet movePet;
  private Attack attack;
  private DisplayPlayerDescription displayPlayerDescription;
  private int rowScaling;
  private int colScaling;

  /**
   * This constructs the controller object by initializing the World model to its world variable.
   *
   * @param world The World model that the controller will use.
   * @throws IllegalArgumentException when world is null
   */
  public ControllerImpl(World world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("World model passed cannot be null.");
    }

    this.world = world;
  }

  @Override
  public String start() {
    return "Controller initialized and started.";
  }

  @Override
  public void setView(View view) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null.");
    }

    this.view = view;
    this.view.setFeatures(this);
    this.addPlayerPieceCommand = new AddPlayerPiece(this.view);
    this.playerPickItem = new PlayerPickItem(this.view);
    this.createGraphicalWorld = new CreateGraphicalWorld(this.view);
    this.playerMove = new PlayerMove(this.view);
    this.playerLookAround = new PlayerLookAround(this.view);
    this.movePet = new MovePet(this.view);
    this.attack = new Attack(this.view);
    this.displayPlayerDescription = new DisplayPlayerDescription(this.view);
    Dimension gameplayDimension = this.view.getGamePlayPanelSize();
    int rowScaling = gameplayDimension.width / 42;
    int colScaling = gameplayDimension.height / 17;
    this.rowScaling = rowScaling;
    this.colScaling = colScaling;
    this.world.generateBaseImage(rowScaling, colScaling);
  }

  @Override
  public void exitGame() {
    this.view.notifyViewGameOver();
    return;
  }

  @Override
  public void notifyScreenChange() {
    this.view.switchFrames();

    Timer timer = new Timer(0, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (world.getTargetPiece().getHealth() <= 0) {
          view.notifyViewGameOver();
          return;
        } else if (world.getNumberOfTurns() == world.getMaxTurns()) {
          view.setTurnInfoText("Game has ended already. Nobody wins and the target escapes.");
          return;
        }
        world.generateOverlayPieceCoordinates();
        world.generateBaseImage(rowScaling, colScaling);
        view.refreshGamePlayScreen();
      }
    });
    timer.setRepeats(true);
    timer.setDelay(2000);
    timer.start();
  }

  @Override
  public void notifyCustomWorldFile() {
    this.createGraphicalWorld.execute(this.world);
    this.world = createGraphicalWorld.getNewWorld();
    Dimension gameplayDimension = this.view.getGamePlayPanelSize();
    int rowScaling = gameplayDimension.width / 42;
    int colScaling = gameplayDimension.height / 17;
    this.world.generateBaseImage(rowScaling, colScaling);
  }

  @Override
  public String notifyAddPlayerPiece() {
    String result = "";
    try {
      result = addPlayerPieceCommand.execute(this.world);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    }
    return result;
  }

  @Override
  public String notifyPickItem() {
    String result = "";
    if (world.getItemNamesInRoom().size() == 0) {
      result = "No items in the room.";
      return result;
    }
    try {
      result = playerPickItem.execute(this.world);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    }
    return result;
  }

  @Override
  public String notifyPlayerLookAround() {
    String result = "";
    try {
      result = playerLookAround.execute(this.world);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
      world.getTurnInformation();
    }
    return result;
  }

  @Override
  public String notifyClick(int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("The coordinates of click cannot be negative.");
    }
    String result = "";
    try {
      String roomNameClicked = this.world.getRoomNameFromCoordinates(x, y);
      String currentPlayerRoomName = this.world.getCurrentPlayerRoomName();
      this.view.updateRoomNameClicked(roomNameClicked);

      if (roomNameClicked.equals(currentPlayerRoomName)) {
        result = this.displayPlayerDescription.execute(this.world);
      } else {
        result = this.playerMove.execute(this.world);
      }
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    }

    return result;
  }

  @Override
  public String notifyPlayerAttack() {
    String result = "";
    if (world.getItemNamesInBag().size() == 0) {
      result = "No items in the bag.";
      return result;
    }
    try {
      result = attack.execute(this.world);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    }

    return result;
  }

  @Override
  public String notifyMovePet() {
    String result = "";
    try {
      result = movePet.execute(this.world);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    }

    return result;
  }
}