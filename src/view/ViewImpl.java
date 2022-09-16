package view;

import controller.Features;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import model.ReadOnlyWorld;

/**
 * Represents the set of functionalities that represent the functioning of a view of the world and
 * defines the state of the view.
 */
public class ViewImpl implements  View {
  private String currentEventName;
  private String moveResult;
  private String roomNameClicked;
  private WelcomeFrame welcomeFrame;
  private AddPlayerFrame addPlayerFrame;
  private GamePlayFrame gamePlayFrame;
  private int currentFrameNumber;
  private ReadOnlyWorld model;
  private Features features;

  /**
   * Constructs the View object of the MVC pattern of the game.
   *
   * @param world The read only model of the game.
   * @throws IllegalArgumentException when world is null.
   */
  public ViewImpl(ReadOnlyWorld world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("World parameter cannot be null.");
    }
    this.model = world;
    this.currentFrameNumber = 0;
    this.welcomeFrame = new WelcomeFrameImpl(model);
    this.addPlayerFrame = new AddPlayerFrameImpl(model);
    this.gamePlayFrame = new GamePlayFrameImpl(model);
  }

  @Override
  public void showScreen() {
    if (this.currentFrameNumber == 0) {
      this.welcomeFrame.display();
      this.addPlayerFrame.setDisplay(false);
    } else if (this.currentFrameNumber == 1) {
      this.welcomeFrame.setDisplay(false);
      this.addPlayerFrame.display();
    } else if (this.currentFrameNumber == 2) {
      this.addPlayerFrame.setDisplay(false);
      this.gamePlayFrame.display();

    }
  }

  @Override
  public void updateModel(ReadOnlyWorld world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("world parameter cannot be null.");
    }
    this.model = world;
    welcomeFrame.updateModel(world);
    addPlayerFrame.updateModel(world);
    gamePlayFrame.updateModel(world);
  }

  @Override
  public List<String> getPlayerDetails() {
    return addPlayerFrame.getPlayerDetails();
  }

  @Override
  public void extractAndSavePlayerDetails() {
    this.addPlayerFrame.savePlayerDetails();
  }

  @Override
  public void refreshGamePlayScreen() {
    if (currentFrameNumber == 2) {
      this.gamePlayFrame.refreshGamePlayScreen();
    }
  }

  @Override
  public void setFeatures(Features features) throws IllegalArgumentException {
    if (features == null) {
      throw new IllegalArgumentException("Features parameter cannot be null.");
    }
    this.features = features;
    this.welcomeFrame.setFeatures(this.features);
    this.addPlayerFrame.setFeatures(this.features);
    this.gamePlayFrame.setFeatures(this.features);
  }

  @Override
  public int getCurrentFrameNumber() {
    return this.currentFrameNumber;
  }

  @Override
  public void switchFrames() {
    this.currentFrameNumber++;
    this.showScreen();
  }

  @Override
  public void notifyViewGameOver() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
      return;
    }

    this.gamePlayFrame.dispatchEventClose();
    this.addPlayerFrame.dispatchEventClose();
    this.welcomeFrame.dispatchEventClose();
  }

  @Override
  public String getFileFromFileChooser() {
    return this.welcomeFrame.getFilePathFromFileChooser();
  }

  @Override
  public String showItemChooser() {
    String itemName = this.gamePlayFrame.showItemChooser();
    return itemName;
  }

  @Override
  public String showRoomChooser() {
    String roomName = this.gamePlayFrame.showRoomChooser();
    return roomName;
  }

  @Override
  public Dimension getGamePlayPanelSize() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    dimension.setSize(dimension.width * 0.6, dimension.height * 0.6);
    return dimension;
  }

  @Override
  public String showAttackItemChooser() {
    String itemName = this.gamePlayFrame.showAttackItemChooser();
    return itemName;
  }

  @Override
  public void updateRoomNameClicked(String roomName) throws IllegalArgumentException {
    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }

    this.roomNameClicked = roomName;
  }

  @Override
  public void setTurnInfoText(String text) throws IllegalArgumentException {
    if ("".equals(text) || text == null) {
      throw new IllegalArgumentException("Text string cannot be null or an empty string.");
    }

    this.gamePlayFrame.setTurnInfoText(text);
  }

  @Override
  public String getRoomNameClicked() {
    return this.roomNameClicked;
  }
}
