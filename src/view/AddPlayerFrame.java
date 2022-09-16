package view;

import controller.Features;
import java.util.List;
import model.ReadOnlyWorld;

/**
 * Represents set of functionalities that are expected from the add player screen view of the world
 * game.
 */
public interface AddPlayerFrame {
  /**
   * Sets the features controller for the add player frame. The add player frame communicates
   * actions to the controller using this interface.
   *
   * @param features An object which belongs to a class that implements the Features interface.
   * @throws IllegalArgumentException when features is null.
   */
  public void setFeatures(Features features);

  /**
   * Sets the size of the JFrame to the size of screen and makes it visible.
   */
  public void display();

  /**
   * Sets the visibility of the frame based on parameter which represents whether the frame should
   * be visible or not.
   *
   * @param display Boolean to represent whether the frame should be visible or not.
   */
  public void setDisplay(boolean display);

  /**
   * Updates the current model to the newly created model when the new input specs were given.
   *
   * @param world new read only model.
   * @throws IllegalArgumentException when world is null.
   */
  public void updateModel(ReadOnlyWorld world);

  /**
   * Gives back the results of the input text fields in the frame.
   *
   * @return A string list of the input text fields in the frame.
   */
  public List<String> getPlayerDetails();

  /**
   * Extracts and saves the user input information.
   */
  public void savePlayerDetails();

  /**
   * Used to notify the frame to dispatch a close and dispose all the resources.
   */
  public void dispatchEventClose();
}
