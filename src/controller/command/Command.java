package controller.command;

import model.World;

/**
 * This interface represents set of functions that are expected to be performed by any command in
 * the controller.
 */
public interface Command {

  /**
   * Performs the required functionality as expected from the command on the world model.
   *
   * @param world world the model which is the GameWorld.
   * @return the String representation of the status of the execute function.
   * @throws IllegalArgumentException when the world model being passed is null.
   */
  public String execute(World world);
}
