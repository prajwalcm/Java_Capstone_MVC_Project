package view;

import controller.Features;
import model.ReadOnlyWorld;

/**
 * Represents set of functionalities that are expected from the welcome screen view of the world
 * game.
 */
public interface WelcomeFrame {
  /**
   * Sets the features controller for the welcome frame. The welcome frame communicates actions to
   * the controller using this interface.
   *
   * @param features An object which belongs to a class that implements the Features interface.
   * @throws IllegalArgumentException when features is null.
   */
  public void setFeatures(Features features);

  /**
   * Shows the file chooser box and gets the user selected file path and returns it.
   *
   * @return String file path of the chosen file.
   */
  public String getFilePathFromFileChooser();

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
   * Used to notify the frame to dispatch a close and dispose all the resources.
   */
  public void dispatchEventClose();
}
