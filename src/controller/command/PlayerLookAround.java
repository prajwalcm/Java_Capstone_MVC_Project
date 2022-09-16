package controller.command;

import model.World;
import view.View;

/**
 * This class represents the command construct that will enable the player to look around its
 * current space.
 */
public class PlayerLookAround implements Command {
  private View view;

  /**
   * Constructs the object that will be enable the player to look around its current space.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public PlayerLookAround(View view) throws IllegalArgumentException {
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
    String result = "";
    try {
      result = world.playerLookAround();
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    } catch (IllegalStateException ise) {
      result = ise.getMessage();
    }
    return result;
  }
}
