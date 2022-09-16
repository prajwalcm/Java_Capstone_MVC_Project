package controller.command;

import model.World;
import view.View;

/**
 * This class represents the command construct that will enable a player to attack the target.
 *
 */
public class Attack implements Command {
  private View view;

  /**
   * Constructs the object that will be further used to enable a player to attack the target.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public Attack(View view) throws IllegalArgumentException {
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
    String itemName = this.view.showAttackItemChooser();
    String result;

    try {
      result = world.attack(itemName);
    } catch (IllegalArgumentException iae) {
      result = iae.getMessage();
    } catch (IllegalStateException ise) {
      result = ise.getMessage();
    }

    return result;
  }
}
