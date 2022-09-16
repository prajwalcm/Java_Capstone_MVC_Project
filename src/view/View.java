package view;

import controller.Features;
import java.awt.Dimension;
import java.util.List;
import model.ReadOnlyWorld;

/**
 * Represents set of functionalities that are expected from a view of the world game.
 */
public interface View {
  /**
   * Sets the features controller for the view. The view communicates actions to the controller
   * using this interface.
   *
   * @param features An object which belongs to a class that implements the Features interface.
   * @throws IllegalArgumentException when features is null.
   */
  public void setFeatures(Features features);

  /**
   * Gives back the frame number of the current frame being visible on the screen.
   * @return the frame number of the current frame being visible on the screen.
   */
  public int getCurrentFrameNumber();

  /**
   * Used to let the view know to switch the frame to the next one.
   */
  public void switchFrames();

  /**
   * Used to notify the view that the game is over and the view cleans up the frames.
   */
  public void notifyViewGameOver();

  /**
   * Used to let the view know that a filechooser window needs to be displayed.
   *
   * @return the file path of the user selected file.
   */
  public String getFileFromFileChooser();

  /**
   * Used to let the view know that a item chooser dialog box needs to be displayed for player
   * picking up item.
   *
   * @return the name of the item selected.
   */
  public String showItemChooser();

  /**
   * Used to let the view know that a room chooser dialog box needs to be displayed for adding
   * player to a room.
   *
   * @return the name of the room selected.
   */
  public String showRoomChooser();

  /**
   * Gives back the dimension of the gameplay panel screen.
   *
   * @return the dimension of the gameplay panel screen.
   */
  public Dimension getGamePlayPanelSize();

  /**
   * Used to let the view know that a item chooser dialog box needs to be displayed for player
   * using an item to attack the target.
   *
   * @return String the name of the item selected.
   */
  public String showAttackItemChooser();

  /**
   * Displays the JFrame that corresponds to the currentFrameNumber.
   */
  public void showScreen();

  /**
   * Updates the current model to the newly created model when the new input specs were given.
   *
   * @param world new read only model.
   * @throws IllegalArgumentException when world is null.
   */
  public void updateModel(ReadOnlyWorld world);

  /**
   * Gives back list of player details as in the text fields in the add player frame.
   *
   * @return the list of player details as in the text fields in the add player frame.
   */
  public List<String> getPlayerDetails();

  /**
   * This method asks the add player frames to extract information from user input and save it.
   */
  public void extractAndSavePlayerDetails();

  /**
   * Refreshes the game play panel's picLabel so that we get updated information on the screen.
   */
  public void refreshGamePlayScreen();

  /**
   * This method updates the name of the room that was clicked as directed by the controller.
   *
   * @param roomName name of the room.
   * @throws IllegalArgumentException when roomName is either null or an empty string.
   */
  public void updateRoomNameClicked(String roomName);

  /**
   * Sets the turn information text in the gameplay screen.
   *
   * @param text Text string to be set.
   * @throws IllegalArgumentException when text is either null or an empty string.
   */
  public void setTurnInfoText(String text);

  /**
   * This methods gives back the name of the room that was last clicked.
   *
   * @return name of the room that was last clicked.
   */
  public String getRoomNameClicked();
}
