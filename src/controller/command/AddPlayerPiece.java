package controller.command;

import java.util.List;
import model.World;
import view.View;

/**
 * This class represents the command construct that will add the players to the game model.
 *
 */
public class AddPlayerPiece implements Command {
  private View view;

  /**
   * Constructs the object that will be further used to add a player into the game.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public AddPlayerPiece(View view) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null.");
    }

    this.view = view;
  }

  @Override
  public String execute(World world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("The model cannot be null.");
    }

    view.extractAndSavePlayerDetails();

    List<String> playerDetails = view.getPlayerDetails();
    String playerName = playerDetails.get(0);
    String roomName = playerDetails.get(1);
    String result = "";
    int itemBagLimit = 0;
    try {
      itemBagLimit = Integer.parseInt(playerDetails.get(2));
    } catch (NumberFormatException nfe) {
      return "Please enter a valid integer for item bag limit.";
    }
    boolean isHuman = ("true".equals(playerDetails.get(3)) ? true : false);
    try {
      result = world.addPlayerPiece(playerName, roomName, itemBagLimit, isHuman);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    } catch (IllegalStateException ise) {
      result = ise.getMessage();
    }
    world.generateOverlayPieceCoordinates();
    return result;
  }
}
