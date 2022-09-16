package controller.command;

import model.World;
import view.View;

/**
 * This class represents the command construct that will enable a player to pick a specific item in
 * the game.
 */
public class PlayerPickItem implements Command {
  private View view;

  /**
   * Constructs the object that will be further enable a player to pick a specific item in the game.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public PlayerPickItem(View view) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("Scan input cannot be null.");
    }

    this.view = view;
  }

  @Override
  public String execute(World world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("The model cannot be null.");
    }

    String itemName = this.view.showItemChooser();
    String result;

    try {
      result = world.playerPickItem(itemName);
    } catch (IllegalArgumentException iae) {
      result = "No items in the room.";
    } catch (IllegalStateException ise) {
      result = ise.getMessage();
    }

    return result;
  }
}
