package view;

import controller.Features;
import model.ReadOnlyWorld;

/**
 * This interface represents the set of functionalities that will enable a user to interact with
 * the game play.
 */
public interface GamePlayFrame {
  /**
   * Shows up an item chooser boxed dropdown to allow the user to select items from the current
   * room.
   *
   * @return String the name of the item selected.
   */
  public String showItemChooser();

  /**
   * Shows up a room chooser boxed dropdown to allow the user to select a room for adding the
   * player.
   *
   * @return String the name of the room selected.
   */
  public String showRoomChooser();

  /**
   * Sets the turn information text in the gameplay screen's turn info panel and turn result panel.
   *
   * @param text Text string to be set.
   * @throws IllegalArgumentException when text is either null or an empty string.
   */
  public void setTurnInfoText(String text);

  /**
   * Shows up an item chooser boxed dropdown to allow the user to select items from the current
   * player's item bag.
   *
   * @return String the name of the item selected.
   */
  public String showAttackItemChooser();

  /**
   * Refreshes the game play panel's picLabel so that we get updated information on the screen.
   */
  public void refreshGamePlayScreen();

  /**
   * Sets the features controller for the game play frame. The game play frame communicates
   * actions to the controller using this interface.
   *
   * @param features An object which belongs to a class that implements the Features interface.
   * @throws IllegalArgumentException when features is null.
   */
  public void setFeatures(Features features);

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
   * Sets the size of the JFrame to the size of screen and makes it visible.
   */
  public void display();

  /**
   * Used to notify the frame to dispatch a close and dispose all the resources.
   */
  public void dispatchEventClose();
}
