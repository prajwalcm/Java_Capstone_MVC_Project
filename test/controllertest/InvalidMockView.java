package controllertest;

import controller.Features;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import model.ReadOnlyWorld;
import view.View;

/**
 * An Invalid Mock View to simulate the functioning of a view in the world; the purpose of this mock
 * view is just to simulate a dummy view which gives invalid results where String is returned to
 * check if controller is sending correct parameters and to correct functions of a particular
 * view object. Invalid Mock View will also enable to test the flow when invalid string data is
 * returned by the view.
 */
public class InvalidMockView implements View {
  private StringBuilder log;
  private final String uniqueStringCode;

  /**
   * Constructs the MockView object so as to be used by the controller when testing. This mock
   * view covers all the cases of invalid arguments.
   *
   * @param log A StringBuilder that will be used to write the output to after calling the
   *           functions of the mock view.
   *
   * @param uniqueStringCode Used to uniquely identify an instance of the MockView.
   * @throws IllegalArgumentException if log is null or uniqueStringCode is null or empty string.
   */
  public InvalidMockView(StringBuilder log, String uniqueStringCode)
          throws IllegalArgumentException {
    if (log == null) {
      throw new IllegalArgumentException("Log cannot be null");
    }
    if ("".equals(uniqueStringCode) || uniqueStringCode == null) {
      throw new IllegalArgumentException("UniqueStringCode cannot be null or an empty string.");
    }

    this.log = log;
    this.uniqueStringCode = uniqueStringCode;
  }

  @Override
  public void setFeatures(Features features) throws IllegalArgumentException {
    if (features == null) {
      throw new IllegalArgumentException("Features cannot be null");
    }

    log.append("Set features called").append(uniqueStringCode);
  }

  @Override
  public int getCurrentFrameNumber() {
    log.append("Get current frame number called").append(uniqueStringCode);
    return 10;
  }

  @Override
  public void switchFrames() {
    log.append("Switch frames called").append(uniqueStringCode);
  }

  @Override
  public void notifyViewGameOver() {
    log.append("Notify view game over called").append(uniqueStringCode);
  }

  @Override
  public String getFileFromFileChooser() {
    log.append("Get file from file chooser called.").append(uniqueStringCode);

    return uniqueStringCode;
  }

  @Override
  public String showItemChooser() {
    log.append("Show item chooser called.").append(uniqueStringCode);

    return "InvalidItemName";
  }

  @Override
  public String showRoomChooser() {
    log.append("Show room chooser called.").append(uniqueStringCode);

    return "InvalidRoomName";
  }

  @Override
  public Dimension getGamePlayPanelSize() {
    log.append("Get game play panel size called.").append(uniqueStringCode);

    return new Dimension(29, 40);
  }

  @Override
  public String showAttackItemChooser() {
    log.append("Show attack item chooser called.").append(uniqueStringCode);

    return "InvalidItemName";
  }

  @Override
  public void showScreen() {
    log.append("Show screen called").append(uniqueStringCode);
  }

  @Override
  public void updateModel(ReadOnlyWorld world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("World cannot be null.");
    }

    log.append("Update model called").append(uniqueStringCode);
  }

  @Override
  public java.util.List<String> getPlayerDetails() {
    List<String> arr = new ArrayList<>();
    arr.add("InvalidPlayerName");
    arr.add("InvalidRoomName");
    arr.add("-1");
    arr.add("true");
    log.append("Get player details called").append(uniqueStringCode);

    return arr;
  }

  @Override
  public void extractAndSavePlayerDetails() {
    log.append("Extract and save player details called").append(uniqueStringCode);
  }

  @Override
  public void refreshGamePlayScreen() {
    log.append("Refresh game play screen called").append(uniqueStringCode);
  }

  @Override
  public void updateRoomNameClicked(String roomName) throws IllegalArgumentException {
    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }

    log.append("Update room name clicked called").append(uniqueStringCode);
  }

  @Override
  public void setTurnInfoText(String text) throws IllegalArgumentException {
    if ("".equals(text) || text == null) {
      throw new IllegalArgumentException("Text cannot be null or an empty string.");
    }

    log.append("Extract and save player details called").append(uniqueStringCode);
  }

  @Override
  public String getRoomNameClicked() {
    log.append("Get room name clicked called").append(uniqueStringCode);

    return "InvalidRoomName";
  }
}
