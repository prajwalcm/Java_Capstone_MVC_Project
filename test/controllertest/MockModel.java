package controllertest;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import model.Player;
import model.Room;
import model.Target;
import model.World;

/**
 * A Mock Model to simulate the functioning of a model in the world; the purpose of this mock
 * model is just to simulate a dummy model to check if controller is sending correct parameters
 * and to correct functions of a particular model object.
 */
public class MockModel implements World {
  private StringBuilder log;
  private final String uniqueStringCode;
  private int turnIncrement;

  /**
   * Constructs the MockModel object so as to be used by the controller when testing. This mock
   * model covers all the cases of valid as well as invalid arguments.
   *
   * @param log A StringBuilder that will be used to write the output to after calling the
   *           functions of the mock model.
   *
   * @param uniqueStringCode Used to uniquely identify an instance of the MockModel.
   * @throws IllegalArgumentException if log is null or uniqueStringCode is null or empty string.
   */
  public MockModel(StringBuilder log, String uniqueStringCode)
          throws IllegalArgumentException {
    if (log == null) {
      throw new IllegalArgumentException("Log cannot be null");
    }
    if ("".equals(uniqueStringCode) || uniqueStringCode == null) {
      throw new IllegalArgumentException("UniqueStringCode cannot be null or an empty string.");
    }

    this.log = log;
    this.uniqueStringCode = uniqueStringCode;
    this.turnIncrement = 1;
  }

  @Override
  public String addPlayerPiece(String name, String roomName, int itemBagLimit, boolean isHuman)
          throws IllegalArgumentException {
    if ("".equals(name) || name == null) {
      throw new IllegalArgumentException("Player name cannot be null or an empty string.");
    }

    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null.");
    }

    if ("InvalidName".equals(name)) {
      throw new IllegalArgumentException("Invalid name passed.");
    }
    if ("InvalidRoomName".equals(roomName)) {
      throw new IllegalArgumentException("Invalid room name passed.");
    }

    if (itemBagLimit < 0) {
      throw new IllegalArgumentException("Item bag limit cannot be negative.");
    }

    log.append("AddPLayerPiece called: Input: ").append(name).append(" ").append(roomName)
            .append(" ").append(itemBagLimit).append(" ").append(isHuman).append(uniqueStringCode);
    return "Add player piece";
  }

  @Override
  public String movePlayerPiece(String roomName) throws IllegalArgumentException {
    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }

    if ("InvalidRoomName".equals(roomName)) {
      throw new IllegalArgumentException("Invalid room name passed.");
    }

    log.append("MovePlayerPiece called Input: ").append(roomName).append(uniqueStringCode);
    turnIncrement++;
    return "Helipad";
  }

  @Override
  public String playerPickItem(String itemName) throws IllegalArgumentException {
    if ("".equals(itemName) || itemName == null) {
      throw new IllegalArgumentException("Item name cannot be null or an empty string.");
    }

    if ("InvalidItemName".equals(itemName)) {
      throw new IllegalArgumentException("Invalid item name passed.");
    }

    log.append("PlayerPickItem called Input: ").append(itemName).append(uniqueStringCode);
    turnIncrement++;
    return "LaserGun";
  }

  @Override
  public String playerLookAround() {
    log.append("Player Looking around called: Room1, Room2\n").append(uniqueStringCode);
    turnIncrement++;
    return "Room1 Room2";
  }

  @Override
  public String getPlayerDescription(String playerName) throws IllegalArgumentException {
    if ("".equals(playerName) || playerName == null) {
      throw new IllegalArgumentException("Player name cannot be null or an empty string.");
    }

    if ("InvalidPlayerName".equals(playerName)) {
      throw new IllegalArgumentException("Invalid player name passed.");
    }

    log.append("Get Player Description called Input: ").append(playerName).append(uniqueStringCode);
    return "Player 1";
  }

  @Override
  public String toString() {
    log.append("MockWorld to String called.");
    return uniqueStringCode;
  }

  @Override
  public String displayRoomInformation(String roomName) throws IllegalArgumentException {
    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }

    if ("InvalidRoomName".equals(roomName)) {
      throw new IllegalArgumentException("Invalid room name passed.");
    }

    log.append("DisplayRoomInformation called Input: ").append(roomName).append(uniqueStringCode);
    return "Helipad";
  }

  @Override
  public String getTurnInformation() {
    log.append("GettingTurnInformation ").append(uniqueStringCode);
    return "Get turn information";
  }

  @Override
  public String playComputerPlayer(int option, boolean flagUseRandom)
          throws IllegalArgumentException {
    if (option < 0 || option > 2) {
      throw new IllegalArgumentException("Invalid option sent.");
    }
    log.append("Input: ").append(option).append(" ").append(flagUseRandom).append(uniqueStringCode);
    return "PlayComputer";
  }

  @Override
  public String movePet(String roomName) throws IllegalArgumentException {
    if ("".equals(roomName) || roomName == null) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }

    if ("InvalidRoomName".equals(roomName)) {
      throw new IllegalArgumentException("Invalid room name passed.");
    }

    log.append("MovePet called Input: ").append(roomName).append(uniqueStringCode);
    return "MovePet";
  }

  @Override
  public String attack(String itemName) throws IllegalArgumentException {
    if ("".equals(itemName) || itemName == null) {
      throw new IllegalArgumentException("Item name cannot be null or an empty string.");
    }

    if ("InvalidItemName".equals(itemName)) {
      throw new IllegalArgumentException("Invalid item name passed.");
    }

    log.append("Attack called Input: ").append(itemName).append(uniqueStringCode);
    return "Attack";
  }

  @Override
  public int getMaxTurns() {
    log.append("Get max turns called").append(uniqueStringCode);

    return 20;
  }

  @Override
  public int getNumberOfTurns() {
    log.append("Get number of turns called").append(uniqueStringCode);
    return turnIncrement;
  }

  @Override
  public void generateBaseImage(int scaleUpRow, int scaleUpCol) throws IllegalArgumentException {
    if ("InvalidScaleUpRow".equals(scaleUpRow) && "InvalidScaleUpCol".equals(scaleUpCol)) {
      throw new IllegalArgumentException("Invalid scaleUpRow and scaleUpCol passed.");
    }

    if ("InvalidScaleUpRow".equals(scaleUpRow)) {
      throw new IllegalArgumentException("Invalid scaleUpRow passed.");
    }

    if ("InvalidScaleUpCol".equals(scaleUpCol)) {
      throw new IllegalArgumentException("Invalid scaleUpCol passed.");
    }

    log.append("Generate base image called").append(uniqueStringCode);
  }

  @Override
  public void generateOverlayPieceCoordinates() {
    log.append("Generate overlay piece coordinates called").append(uniqueStringCode);
  }

  @Override
  public BufferedImage getBaseImage() {
    log.append("Get base image called").append(uniqueStringCode);
    return new BufferedImage(10, 20, 1);
  }

  @Override
  public List<String> getRoomNames() {
    List<String> arr = new ArrayList<>();
    arr.add("List of rooms");
    log.append("Get room names called").append(uniqueStringCode);
    return arr;
  }

  @Override
  public List<String> getItemNamesInRoom() {
    List<String> arr = new ArrayList<>();
    arr.add("List of items in room");
    log.append("Get item names in room called").append(uniqueStringCode);
    return arr;
  }

  @Override
  public List<String> getItemNamesInBag() {
    List<String> arr = new ArrayList<>();
    arr.add("List of items in bag");
    log.append("Get item names in bag called").append(uniqueStringCode);
    return arr;
  }

  @Override
  public int getRows() {
    log.append("Get rows called").append(uniqueStringCode);
    return 12;
  }

  @Override
  public List<Room> getRoomsList() {
    log.append("Get rooms list called.").append(uniqueStringCode);
    return null;
  }

  @Override
  public Target getTargetPiece() {
    log.append("Get target piece called").append(uniqueStringCode);
    return null;
  }

  @Override
  public int getColumns() {
    log.append("Get columns called").append(uniqueStringCode);
    return 10;
  }

  @Override
  public boolean isCurrentTurnHuman() {
    log.append("Is current Turn Human called").append(uniqueStringCode);
    return true;
  }

  @Override
  public List<Player> getPlayerList() {
    log.append("Get player list called").append(uniqueStringCode);
    return null;
  }

  @Override
  public String getCurrentPlayerRoomName() {
    log.append("Get current player room name called").append(uniqueStringCode);
    return "Helipad";
  }

  @Override
  public String getRoomNameFromCoordinates(int x, int y) throws IllegalArgumentException {
    if (x < 0 && y < 0) {
      throw new IllegalArgumentException("x and y cannot be negative.");
    }

    if (x < 0) {
      throw new IllegalArgumentException("x cannot be negative.");
    }

    if (y < 0) {
      throw new IllegalArgumentException("y cannot be negative.");
    }

    log.append("Get room name from coordinates called").append(uniqueStringCode);

    return "Helipad";
  }


}
