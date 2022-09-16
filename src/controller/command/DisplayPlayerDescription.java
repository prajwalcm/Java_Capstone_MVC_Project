package controller.command;

import model.World;
import view.View;

/**
 * This class represents the command construct that will display the information regarding a player
 * in the world.
 */
public class DisplayPlayerDescription implements Command {
  private View view;

  /**
   * Constructs the object that will be further used to get a specific player's description.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public DisplayPlayerDescription(View view) throws IllegalArgumentException {
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

    int currentPlayerIndex = world.getNumberOfTurns() % world.getPlayerList().size();

    String result = "";

    try {
      result = world.getPlayerDescription(world.getPlayerList().get(currentPlayerIndex).getName());
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    } catch (IllegalStateException ise) {
      result = ise.getMessage();
    }

    return result;
  }
}
