package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This class represents the complete game board.
 */
public class WorldImpl implements World {

  private int rows;
  private int columns;
  private String worldName;
  private List<Room> roomsList;
  private List<Item> itemsList;
  private List<Player> playerList;
  private Target targetPiece;
  private int maxTurns;
  private int numberOfTurns;
  private String targetName;
  private int currentTurnListIndex;
  private Pet targetPet;
  private ImageDisplayer imageDisplayer;
  private BufferedImage baseImage;
  private List<List<Integer>> overlayPieceCoordinates;
  private int scaleUpRow;
  private int scaleUpCol;

  /**
   * Initializes the parameters for the game and creates component objects based on the parameters
   * passed.
   *
   * @param rows         number of rows in the board.
   * @param columns      number of columns in the board.
   * @param worldName    name of the world.
   * @param roomsList    list of rooms.
   * @param itemsList    list of items. This can be null.
   * @param targetName   name of the target.
   * @param targetHealth health of the target.
   * @param maxTurns maximum number of turns allowed in the game.
   * @throws IllegalArgumentException for invalid arguments passed.
   */
  public WorldImpl(int rows, int columns, String worldName, List<Room> roomsList,
                   List<Item> itemsList, String targetName, String petName, int targetHealth,
                   int maxTurns)
          throws IllegalArgumentException {

    // Check for validity of the parameters passed.
    if (rows < 1) {
      throw new IllegalArgumentException("Number of rows cannot be less than 1.");
    }

    if (columns < 1) {
      throw new IllegalArgumentException("Number of columns cannot be ess than 1.");
    }

    if (worldName == null || "".equals(worldName)) {
      throw new IllegalArgumentException("WorldName cannot be equal to null or cannot be an empty "
              + "string.");
    }

    if (roomsList == null || roomsList.size() < 1) {
      throw new IllegalArgumentException("List of rooms cannot be null or list of rooms cannot"
              + " have size less than 1.");
    }

    if (targetName == null || "".equals(targetName)) {
      throw new IllegalArgumentException("Target name cannot be null or target name cannot be"
              + " an empty string.");
    }

    if (petName == null || "".equals(petName)) {
      throw new IllegalArgumentException("Pet name cannot be null or pet name cannot be"
              + " an empty string.");
    }

    if (targetHealth <= 0) {
      throw new IllegalArgumentException("Target health cannot be less than or equal to 0");
    }

    if (maxTurns < 1) {
      throw new IllegalArgumentException("Max turns cannot be less than 1");
    }


    this.rows = rows;
    this.columns = columns;
    this.worldName = worldName;
    this.roomsList = roomsList;
    this.itemsList = itemsList;
    this.playerList = new ArrayList<>();
    this.numberOfTurns = 0;
    this.currentTurnListIndex = 0;
    this.targetName = targetName;
    this.maxTurns = maxTurns;
    this.imageDisplayer = new ImageDisplayer(this, 38, 38);
    this.baseImage = null;
    this.overlayPieceCoordinates = new ArrayList<>();
    this.scaleUpRow = 30;
    this.scaleUpCol = 30;

    // Test for items in invalid indices
    if (!areItemsRoomIndicesValid()) {
      throw new IllegalArgumentException("Item's room index is not valid.");
    }

    // Test if any room has dimensions greater than the world.
    if (!allRoomsLesserDimThanWorld()) {
      throw new IllegalArgumentException("Room dimensions cannot be greater than world.");
    }

    // Test for overlapping rooms
    for (int i = 0; i < roomsList.size(); i++) {
      for (int j = i + 1; j < roomsList.size(); j++) {
        if (doRoomsOverlap(roomsList.get(i), roomsList.get(j))) {
          throw new IllegalArgumentException("Rooms are overlapping.");
        }
      }
    }

    // Since all validations for rooms are done, we can create neighbor rooms for all rooms now
    for (Room room : roomsList) {
      room.calculateNeighborsAndSave(roomsList);
    }

    currentTurnListIndex = 0;
    targetPiece = new TargetImpl(0, targetName, targetHealth, roomsList);
    targetPet = new PetImpl(petName, roomsList.get(0), roomsList);
    roomsList.get(0).statusChangePetInRoom(true);
    generateOverlayPieceCoordinates();
    Room petCurrentRoom = this.targetPet.movePetDfs();
  }

  /**
   * Checks whether all rooms have size <= world.
   *
   * @return whether all rooms have size <= world
   */
  private boolean allRoomsLesserDimThanWorld() {
    for (Room room : roomsList) {
      if ((room.getRightBottomCol() - room.getLeftTopCol() + 1) > this.columns) {
        return false;
      }
      if ((room.getRightBottomRow() - room.getLeftTopRow() + 1) > this.rows) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if 2 rooms overlap.
   *
   * @param r1 Room1
   * @param r2 Room2
   * @return whether 2 rooms overlap or not.
   * @throws IllegalArgumentException when either r1 or r2 is null.
   */
  private boolean doRoomsOverlap(Room r1, Room r2) throws IllegalArgumentException {
    if (r1 == null || r2 == null) {
      throw new IllegalArgumentException("Room cannot be null.");
    }

    // Checking bottom right overlapping
    if ((r2.getLeftTopRow() <= r1.getRightBottomRow()
            && r2.getLeftTopRow() >= r1.getLeftTopRow()
            && r2.getLeftTopCol() <= r1.getRightBottomCol()
            && r2.getLeftTopCol() >= r1.getLeftTopCol())) {
      return true;
    }

    // Checking top right overlapping
    if ((r2.getRightBottomRow() >= r1.getLeftTopRow()
            && r2.getRightBottomRow() <= r1.getRightBottomRow())
            && (r2.getLeftTopCol() >= r1.getLeftTopCol() && r2.getLeftTopCol()
            <= r1.getRightBottomCol())) {
      return true;
    }

    // Checking top left overlapping
    if ((r2.getRightBottomRow() >= r1.getLeftTopRow()
            && r2.getRightBottomRow() <= r1.getRightBottomRow())
            && (r2.getRightBottomCol() >= r1.getLeftTopCol()
            && r2.getRightBottomCol() <= r1.getRightBottomCol())) {
      return true;
    }

    // Checking bottom left overlapping
    if ((r2.getRightBottomCol() >= r1.getLeftTopCol()
            && r2.getRightBottomCol() <= r1.getRightBottomCol())
            && (r2.getLeftTopRow() >= r1.getLeftTopRow()
            && r2.getLeftTopRow() <= r1.getRightBottomRow())) {
      return true;
    }
    return false;
  }

  /**
   * Checks if room indices are valid or not i.e. they are within the valid range of roomslist.
   *
   * @return boolean if room indices are valid for an item.
   */
  private boolean areItemsRoomIndicesValid() {
    int minIndex = 0;
    int maxIndex = roomsList.size() - 1;
    for (Item item : itemsList) {
      if (item.getContainingRoomIndex() < minIndex || item.getContainingRoomIndex() > maxIndex) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method paints the players and target according to their current coordinates on the
   * base image canvas consisting of rooms.
   *
   * @throws IllegalArgumentException when File path provided is wrong.
   */
  private void paintPlayersOnBaseImage() throws IllegalArgumentException {
    Graphics g = this.baseImage.getGraphics();
    int count = 0;
    for (List<Integer> coords : this.overlayPieceCoordinates) {
      if (coords.get(0) == -1) {
        count++;
        continue;
      }
      BufferedImage image = null;
      try {
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("IconImages/" + count + ".png");
        image = ImageIO.read(inputStream);
      } catch (IOException ioe) {
        throw new IllegalArgumentException("Wrong file path for the image.");
      }
      g.drawImage(image, coords.get(0), coords.get(1), 30, 30, null);
      count++;
    }
  }

  @Override
  public int getRows() {
    return rows;
  }

  @Override
  public List<Room> getRoomsList() {
    List<Room> copyRoomsList = new ArrayList<>();
    for (Room room : roomsList) {
      Room copyRoom = new RoomImpl(room.getRoom(), room.getName(), room.getLeftTopRow(),
              room.getLeftTopCol(), room.getRightBottomRow(), room.getRightBottomCol(),
              room.getItemsList());

      copyRoomsList.add(copyRoom);
    }
    return copyRoomsList;
  }

  @Override
  public int getColumns() {
    return columns;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Number of rows: ").append(this.rows).append("\n")
            .append("Number of columns: ").append(this.columns).append("\n")
            .append("World name: ").append(this.worldName).append("\n")
            .append("Target name: ").append(this.targetName).append("\n")
            .append("Target in room: ").append(this.targetPiece.getCurrentRoom().getName())
            .append("\n")
            .append("Target pet name: ").append(this.targetPet.getName()).append("\n")
            .append("Target pet current room: ").append(this.targetPet.getCurrentRoom().getName())
            .append("\n")
            .append("\n")
            .append("Number of spaces: ").append(this.roomsList.size()).append("\n");

    return stringBuilder.toString();
  }

  @Override
  public String addPlayerPiece(String name, String roomName, int itemBagLimit,
                               boolean isHuman) throws IllegalArgumentException,
          IllegalStateException {
    if (this.playerList.size() >= 10) {
      throw new IllegalStateException("Only 10 players can be added in a game.");
    }

    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Name cannot be null or name cannot be an empty string.");
    }

    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Room name cannot be null or cannot be an empty string.");
    }

    // Checking if itemBagLimit >= 0 or not
    if (itemBagLimit < 0) {
      throw new IllegalArgumentException("Item bag limit cannot be less than 0.");
    }

    // Checking if name == target's name
    if (targetName.equals(name)) {
      throw new IllegalArgumentException("Target with name already exists.");
    }

    // Checking if player is already in the playerlist.
    for (Player player : playerList) {
      if (player.getName().equals(name)) {
        throw new IllegalArgumentException("Player with name already exists.");
      }
    }

    Room playerRoom = null;
    for (Room room : roomsList) {
      if (room.getName().equals(roomName)) {
        playerRoom = room;
      }
    }

    if (playerRoom == null) {
      throw new IllegalArgumentException("Please enter valid room name");
    }

    Player newPlayer = new PlayerImpl(playerList.size(), name, playerRoom, itemBagLimit,
            isHuman);

    playerList.add(newPlayer);
    playerRoom.addPlayerToRoom(newPlayer);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player successfully added to room ").append(playerRoom);
    stringBuilder.append("Player is a ").append(newPlayer.getIsHuman() ? "Human " : "Computer ")
            .append("player\n");

    return stringBuilder.toString();
  }

  @Override
  public String getTurnInformation() throws IllegalStateException {
    if (numberOfTurns > maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }
    if (this.targetPiece.getHealth() <= 0) { //((value % mod + mod) % mod
      int winnerIndex = (((currentTurnListIndex - 1) % this.playerList.size())
              + this.playerList.size()) % (this.playerList.size());
      throw new IllegalStateException("Game has ended as target is killed. Winner is "
              + this.playerList.get(winnerIndex).getName()
              + "\n");
    }

    if (playerList.size() == 0) {
      throw new IllegalStateException("PlayerList is empty, quit and start again by adding"
              + " some players.\n");
    }


    this.generateOverlayPieceCoordinates();
    this.generateBaseImage(this.scaleUpRow, this.scaleUpCol);

    StringBuilder stringBuilder = new StringBuilder("");
    while (!(isCurrentTurnHuman()) && numberOfTurns <= maxTurns) {
      stringBuilder.append("CPU Player: ").append(this.playerList.get(currentTurnListIndex)
              .getName()).append("\n");
      stringBuilder.append(playComputerPlayer(0, true));
      if (numberOfTurns > maxTurns) {
        throw new IllegalStateException("Game has ended already. Nobody wins and the "
                + "target escapes.\n");
      }
      if (this.targetPiece.getHealth() <= 0) { //((value % mod + mod) % mod
        int winnerIndex = (((currentTurnListIndex - 1) % this.playerList.size())
                + this.playerList.size()) % (this.playerList.size());
        throw new IllegalStateException(stringBuilder.toString() + "Game has ended as target is"
                + " killed. Winner is "
                + this.playerList.get(winnerIndex).getName()
                + "\n");
      }
    }

    if (isCurrentTurnHuman()) {
      stringBuilder.append("\nCurrent player: ")
              .append(this.playerList.get(this.currentTurnListIndex).getName()).append("\n");
    }
    stringBuilder.append("Target's current room: ").append(this.targetPiece.getCurrentRoom()
            .getName()).append("\n");
    stringBuilder.append("Target's current health: ").append(this.targetPiece.getHealth())
            .append("\n");
    stringBuilder.append("Pet's current room: ").append(this.targetPet.getCurrentRoom()
            .getName()).append("\n");
    stringBuilder.append("Current player room: ").append(this.playerList.get(currentTurnListIndex)
            .getCurrentRoom().getName()).append("\n");
    // Current items in the current player's room
    stringBuilder.append("Items in the current room: ").append("\n");
    int count = 1;
    for (Item item : this.playerList.get(currentTurnListIndex).getCurrentRoom().getItemsList()) {
      stringBuilder.append(count).append(". ").append(item.getName()).append("\n");
      count++;
    }
    // Items in the player's bag currently
    stringBuilder.append("Current player's item bag: \n");
    count = 1;
    for (Item i : this.playerList.get(currentTurnListIndex).getItemList()) {
      stringBuilder.append(count).append(". name: ").append(i.getName()).append(", damage: ")
              .append(i.getDamage()).append("\n");
      count++;
    }

    Room currentPlayerRoom = this.playerList.get(currentTurnListIndex).getCurrentRoom();

    currentPlayerRoom.calculateNeighborsAndSave(this.roomsList);
    for (Player player : this.playerList) {
      if (player.getCurrentRoom().getName().equals(currentPlayerRoom.getName())) {
        currentPlayerRoom.addPlayerToRoom(player);
      }
    }
    // players in the current player's room
    stringBuilder.append("Players in the current room: ").append("\n");
    count = 1;
    for (Player player : currentPlayerRoom.getPlayersInRoom()) {
      stringBuilder.append(count).append(". ").append(player.getName()).append("\n");
      count++;
    }
    // Displays info on if the pet in the same space
    boolean petInSameSpace = (this.targetPet.getCurrentRoom().getName()
            .equals(currentPlayerRoom.getName()));
    stringBuilder.append("Pet is in the same space: ").append(petInSameSpace).append("\n");
    // Spaces visible from the current player's room excluding the one that has a pet if at all.
    stringBuilder.append("Spaces visible from the current room: ").append("\n");
    count = 1;
    for (Room room : currentPlayerRoom.getNeighbors()) {
      if (!room.getIsPetPresent()) {
        stringBuilder.append(count).append(". ").append(room.getName()).append("\n");
        count++;
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public String movePlayerPiece(String roomName) throws
          IllegalArgumentException, IllegalStateException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }
    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Room name cannot be null or cannot be"
              + " an empty string.");
    }

    String playerName = this.playerList.get(this.currentTurnListIndex).getName();

    Player player = null;
    Room room = null;

    // Searching for player with the name.
    for (Player p : playerList) {
      if (p.getName().equals(playerName)) {
        player = p;
      }
    }

    if (player == null) {
      throw new IllegalArgumentException("The player name is invalid.");
    }

    // Searching for room with the name.
    for (Room r : roomsList) {
      if (r.getName().equals(roomName)) {
        room = r;
      }
    }
    if (room == null) {
      throw new IllegalArgumentException("The room name is invalid.");
    }

    // Get current room of player from room name.
    String playerCurrentRoomName = player.getCurrentRoom().getName();
    Room playerCurrentRoom = null;
    for (Room tempRoom : roomsList) {
      if (tempRoom.getName().equals(playerCurrentRoomName)) {
        playerCurrentRoom = tempRoom;
      }
    }

    boolean neighborFlag = false;
    for (Room tempRoom : playerCurrentRoom.getNeighbors()) {
      if ((tempRoom.getName().strip()).equals(roomName.strip())) {
        neighborFlag = true;
      }
    }

    if (!neighborFlag) {
      throw new IllegalArgumentException("The room passed: " + roomName + " is not a neighbor of "
              + "the current room: " + playerCurrentRoom.getName());
    }

    playerCurrentRoom.removePlayerFromRoom(player);
    player.move(room);
    room.addPlayerToRoom(player);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player ").append(player.getName()).append(" has successfully moved from ")
            .append(playerCurrentRoomName).append(" to ").append(roomName).append("\n");

    this.numberOfTurns++;
    this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
    targetPiece.move();
    Room petPrevRoom = this.targetPet.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (petPrevRoom.getName().equals(r.getName())) {
        petPrevRoom = r;
        break;
      }
    }
    petPrevRoom.statusChangePetInRoom(false);
    Room petCurrentRoom = this.targetPet.movePetDfs();
    for (Room r : this.roomsList) {
      if (petCurrentRoom.getName().equals(r.getName())) {
        petCurrentRoom = r;
        break;
      }
    }
    petCurrentRoom.statusChangePetInRoom(true);

    stringBuilder.append("Items in the new room: \n");
    int count = 1;
    for (Item i : player.getCurrentRoom().getItemsList()) {
      stringBuilder.append(count).append(". ").append(i.getName()).append("\n");
      count++;
    }
    return stringBuilder.toString();
  }

  @Override
  public Target getTargetPiece() {
    return this.targetPiece;
  }

  @Override
  public int getMaxTurns() {
    return this.maxTurns;
  }

  @Override
  public int getNumberOfTurns() {
    return this.numberOfTurns;
  }

  @Override
  public String playerPickItem(String itemName) throws IllegalArgumentException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }
    if (itemName == null || "".equals(itemName)) {
      throw new IllegalArgumentException("Item name cannot be null or cannot be"
              + " an empty string.");
    }

    Player player = null;
    Item item = null;
    StringBuilder stringBuilder = new StringBuilder("");
    String playerName = this.getPlayerList().get(currentTurnListIndex).getName();

    // Searching for player with the name.
    for (Player p : playerList) {
      if (p.getName().equals(playerName)) {
        player = p;
      }
    }

    if (player == null) {
      throw new IllegalArgumentException("The player name is invalid.");
    }

    // Searching for the item
    for (Item i : itemsList) {
      if (i.getName().equals(itemName.strip())) {
        item = i;
      }
    }

    if (item == null) {
      throw new IllegalArgumentException("The item name is invalid.");
    }

    String roomName = player.getCurrentRoom().getName();

    Room room = null;
    for (Room r : roomsList) {
      if (r.getName().equals(roomName)) {
        room = r;
      }
    }

    boolean isItemInRoom = false;

    for (Item i : room.getItemsList()) {
      if (i.getName().equals(item.getName())) {
        isItemInRoom = true;
      }
    }

    if (!isItemInRoom) {
      throw new IllegalArgumentException("Item is not present in the room.");
    }

    if (player.pickItem(item)) {
      stringBuilder.append("Item ").append(item.getName()).append(" was picked up successfully by ")
              .append(player.getName()).append(".\n");

      room.removeItemFromRoom(item);
    } else {
      stringBuilder.append("Picking up item by the player was not successful.\n");
    }

    this.numberOfTurns++;
    this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
    targetPiece.move();
    Room petPrevRoom = this.targetPet.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (petPrevRoom.getName().equals(r.getName())) {
        petPrevRoom = r;
        break;
      }
    }
    petPrevRoom.statusChangePetInRoom(false);
    Room petCurrentRoom = this.targetPet.movePetDfs();
    for (Room r : this.roomsList) {
      if (petCurrentRoom.getName().equals(r.getName())) {
        petCurrentRoom = r;
        break;
      }
    }
    petCurrentRoom.statusChangePetInRoom(true);

    return stringBuilder.toString();
  }

  @Override
  public String playerLookAround() throws IllegalArgumentException, IllegalStateException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }

    Player player = null;
    String playerName = this.getPlayerList().get(this.currentTurnListIndex).getName();

    // Searching for player with the name.
    for (Player p : playerList) {
      if (p.getName().equals(playerName)) {
        player = p;
      }
    }

    if (player == null) {
      throw new IllegalArgumentException("The player name is invalid.");
    }

    StringBuilder stringBuilder = new StringBuilder("");
    if (this.targetPiece.getCurrentRoom().getName().equals(player.getCurrentRoom().getName())) {
      stringBuilder.append("Target is present here.\n");
    }
    stringBuilder.append(player.lookAround()).append("\n");

    this.numberOfTurns++;
    this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
    targetPiece.move();

    Room petPrevRoom = this.targetPet.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (petPrevRoom.getName().equals(r.getName())) {
        petPrevRoom = r;
        break;
      }
    }
    petPrevRoom.statusChangePetInRoom(false);
    Room petCurrentRoom = this.targetPet.movePetDfs();
    for (Room r : this.roomsList) {
      if (petCurrentRoom.getName().equals(r.getName())) {
        petCurrentRoom = r;
        break;
      }
    }
    petCurrentRoom.statusChangePetInRoom(true);

    return stringBuilder.toString();
  }

  @Override
  public String getPlayerDescription(String playerName) throws IllegalArgumentException {
    if (playerName == null || "".equals(playerName)) {
      throw new IllegalArgumentException("Player name cannot be null or cannot be "
              + "an empty string.");
    }
    Player player = null;

    // Searching for player with the name.
    for (Player p : playerList) {
      if (p.getName().equals(playerName)) {
        player = p;
        break;
      }
    }

    if (player == null) {
      throw new IllegalArgumentException("The player name" + playerName + " is invalid.");
    }

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player name: ").append(player.getName()).append("\n")
            .append("Player current room: ").append(player.getCurrentRoom().getName()).append("\n")
            .append("Player items: ");

    for (Item item : player.getItemList()) {
      stringBuilder.append(item.getName()).append(" ");
    }

    return stringBuilder.toString() + "\n";
  }

  @Override
  public boolean isCurrentTurnHuman() {
    if (playerList.get(currentTurnListIndex).getIsHuman()) {
      return true;
    }
    return false;
  }

  @Override
  public List<Player> getPlayerList() {
    List<Player> copyPlayerList = new ArrayList<>();

    for (Player p : playerList) {
      Player newPlayer = new PlayerImpl(p.getNumber(), p.getName(), p.getCurrentRoom(),
              p.getItemBagLimit(), p.getIsHuman());
      copyPlayerList.add(newPlayer);
    }

    return copyPlayerList;
  }

  @Override
  public String displayRoomInformation(String roomName) throws IllegalArgumentException {
    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }
    Room room = null;
    for (Room r : roomsList) {
      if (r.getName().equals(roomName)) {
        room = r;
      }
    }
    if (room == null) {
      throw new IllegalArgumentException("The room does not exist in the world.\n");
    }

    return room.toString();
  }

  @Override
  public String playComputerPlayer(int option, boolean flagUseRandom) throws
          IllegalArgumentException, IllegalStateException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already.");
    }
    if (isCurrentTurnHuman()) {
      return "";
    }

    if (option < 0) {
      throw new IllegalArgumentException("Option cannot be negative.");
    }

    if (option > 2) {
      throw new IllegalArgumentException("Option cannot be greater than 2.");
    }

    if (isCurrentTurnHuman()) {
      throw new IllegalStateException("Current turn is of a human");
    }

    String playerName = this.playerList.get(this.currentTurnListIndex).getName();
    String currentPlayerRoomName = this.playerList.get(this.currentTurnListIndex).getCurrentRoom()
            .getName();

    Player player = null;
    Room room = null;

    for (Player p : playerList) {
      if (p.getName().equals(playerName)) {
        player = p;
      }
    }

    // Searching for room with the name.
    for (Room r : roomsList) {
      if (r.getName().equals(currentPlayerRoomName)) {
        room = r;
      }
    }

    // Checking if computer player can be seen by others
    boolean canBeSeenByOthers = false;
    for (Player p : this.playerList) {
      if (!(p.getName().equals(player.getName()))) {
        if (canSeePlayer(p, player)) {
          canBeSeenByOthers = true;
          break;
        }
      }
    }

    // Computer player attacks if target in same room and it cannot be seen by others.
    if (this.targetPiece.getCurrentRoom().getName().equals(player.getCurrentRoom().getName())
            && !canBeSeenByOthers) {
      StringBuilder stringBuilder = new StringBuilder("");
      if (player.getItemList().size() == 0) {
        // Poke if no item in the item bag.
        this.targetPiece.receiveAttack(1);
        stringBuilder.append("Poke attack was successful.\n");
      } else {
        Item maxDamageItem = player.getItemList().get(0);
        for (Item i : player.getItemList()) {
          if (i.getDamage() > maxDamageItem.getDamage()) {
            maxDamageItem = i;
          }
        }
        this.targetPiece.receiveAttack(maxDamageItem.getDamage());
        Item itemToBeRemoved = null;
        for (Item i : this.itemsList) {
          if (maxDamageItem.getName().equals(i.getName())) {
            maxDamageItem = i;
          }
        }
        player.removeItemFromBag(maxDamageItem);
        this.itemsList.remove(maxDamageItem);
        stringBuilder.append("Attack with ").append(maxDamageItem.getName()).append(" and damage ")
                .append(maxDamageItem.getDamage()).append(" was successful.\n");
      }
      int targetCurrentHealth = (this.targetPiece.getHealth() < 0) ? 0 : this.targetPiece
              .getHealth();
      stringBuilder.append("\nCurrent target health: ").append(targetCurrentHealth)
              .append("\n");
      this.numberOfTurns++;
      this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
      targetPiece.move();
      Room petPrevRoom = this.targetPet.getCurrentRoom();
      for (Room r : this.roomsList) {
        if (petPrevRoom.getName().equals(r.getName())) {
          petPrevRoom = r;
          break;
        }
      }
      petPrevRoom.statusChangePetInRoom(false);
      Room petCurrentRoom = this.targetPet.movePetDfs();
      for (Room r : this.roomsList) {
        if (petCurrentRoom.getName().equals(r.getName())) {
          petCurrentRoom = r;
          break;
        }
      }
      petCurrentRoom.statusChangePetInRoom(true);

      return stringBuilder.toString();
    }

    int randomFunctionIndicator = 0;

    if (flagUseRandom) {
      GenerateRandom generateRandom = new GenerateRandom();
      randomFunctionIndicator = generateRandom.getRandomInt(3);
    } else {
      if (option > 2) {
        throw new IllegalArgumentException("Option is wrong, only 0 to 2 allowed");
      } else if (option < 0) {
        throw new IllegalArgumentException("Option is wrong, only 0 to 2 allowed");
      }
      randomFunctionIndicator = option;
    }

    StringBuilder stringBuilder = new StringBuilder("");

    if (randomFunctionIndicator == 0) {
      if (room.getNeighbors().size() == 0) {
        this.numberOfTurns++;
        this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
        targetPiece.move();
        String result = "Computer player's turn: " + player.lookAround();

        Room petPrevRoom = this.targetPet.getCurrentRoom();
        for (Room r : this.roomsList) {
          if (petPrevRoom.getName().equals(r.getName())) {
            petPrevRoom = r;
            break;
          }
        }
        petPrevRoom.statusChangePetInRoom(false);
        Room petCurrentRoom = this.targetPet.movePetDfs();
        for (Room r : this.roomsList) {
          if (petCurrentRoom.getName().equals(r.getName())) {
            petCurrentRoom = r;
            break;
          }
        }
        petCurrentRoom.statusChangePetInRoom(true);

        return result;
      }

      String movingRoomName = room.getNeighbors().get(0).getName();
      Room movingRoom = null;

      for (Room r : roomsList) {
        if (r.getName().equals(movingRoomName)) {
          movingRoom = r;
        }
      }
      String output = null;

      output = player.move(movingRoom);
      room.removePlayerFromRoom(player);
      movingRoom.addPlayerToRoom(player);
      this.numberOfTurns++;
      this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
      targetPiece.move();
      Room petPrevRoom = this.targetPet.getCurrentRoom();
      for (Room r : this.roomsList) {
        if (petPrevRoom.getName().equals(r.getName())) {
          petPrevRoom = r;
          break;
        }
      }
      petPrevRoom.statusChangePetInRoom(false);
      Room petCurrentRoom = this.targetPet.movePetDfs();
      for (Room r : this.roomsList) {
        if (petCurrentRoom.getName().equals(r.getName())) {
          petCurrentRoom = r;
          break;
        }
      }
      petCurrentRoom.statusChangePetInRoom(true);

      return output;
    } else if (randomFunctionIndicator == 1) {
      this.numberOfTurns++;
      this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
      targetPiece.move();
      Room petPrevRoom = this.targetPet.getCurrentRoom();
      for (Room r : this.roomsList) {
        if (petPrevRoom.getName().equals(r.getName())) {
          petPrevRoom = r;
          break;
        }
      }
      petPrevRoom.statusChangePetInRoom(false);
      Room petCurrentRoom = this.targetPet.movePetDfs();
      for (Room r : this.roomsList) {
        if (petCurrentRoom.getName().equals(r.getName())) {
          petCurrentRoom = r;
          break;
        }
      }
      petCurrentRoom.statusChangePetInRoom(true);
      return "Computer player's turn: " + player.lookAround();
    } else {
      if (room.getItemsList().size() == 0) {
        this.numberOfTurns++;
        this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
        targetPiece.move();
        Room petPrevRoom = this.targetPet.getCurrentRoom();
        for (Room r : this.roomsList) {
          if (petPrevRoom.getName().equals(r.getName())) {
            petPrevRoom = r;
            break;
          }
        }
        petPrevRoom.statusChangePetInRoom(false);
        Room petCurrentRoom = this.targetPet.movePetDfs();
        for (Room r : this.roomsList) {
          if (petCurrentRoom.getName().equals(r.getName())) {
            petCurrentRoom = r;
            break;
          }
        }
        petCurrentRoom.statusChangePetInRoom(true);
        return "Computer player's turn: " + player.lookAround();
      }
      String itemName = room.getItemsList().get(0).getName();
      Item item = null;

      for (Item i : itemsList) {
        if (i.getName().equals(itemName)) {
          item = i;
        }
      }
      Boolean result = player.pickItem(item);
      room.removeItemFromRoom(item);
      this.numberOfTurns++;
      if (result == false) {
        stringBuilder.append("Could not pick an item as no item in room or itembag already "
                + "full.\n");
      } else {
        stringBuilder.append("Item " + itemName + " was picked up successfully by computer player ")
                .append(player.getName()).append("\n");
      }
      this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
      targetPiece.move();
      Room petPrevRoom = this.targetPet.getCurrentRoom();
      for (Room r : this.roomsList) {
        if (petPrevRoom.getName().equals(r.getName())) {
          petPrevRoom = r;
          break;
        }
      }
      petPrevRoom.statusChangePetInRoom(false);
      Room petCurrentRoom = this.targetPet.movePetDfs();
      for (Room r : this.roomsList) {
        if (petCurrentRoom.getName().equals(r.getName())) {
          petCurrentRoom = r;
          break;
        }
      }
      petCurrentRoom.statusChangePetInRoom(true);


      return stringBuilder.toString();
    }
  }

  /**
   * Checks whether player A can see player B. Player A can see player B when either they are in the
   * same room or playerB is in one of the neighboring rooms of that of player A provided that
   * neighboring room does not contain the target's pet.
   *
   * @param playerA player who is looking.
   * @param playerB player who is trying to be looked upon.
   * @return true if the playerA can see playerB and return false otherwise.
   * @throws IllegalArgumentException when either playerA or playerB is null or both are null.
   */
  private boolean canSeePlayer(Player playerA, Player playerB) throws IllegalArgumentException {
    if (playerA == null || playerB  == null) {
      throw new IllegalArgumentException("Player object passed cannot be null.");
    }

    // Checking if playerA and playerB are in the same room.
    if (playerA.getCurrentRoom().getName().equals(playerB.getCurrentRoom().getName())) {
      return true;
    }

    Room playerAroom = playerA.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (playerAroom.getName().equals(r.getName())) {
        playerAroom = r;
        break;
      }
    }

    Room playerBroom = playerB.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (playerBroom.getName().equals(r.getName())) {
        playerBroom = r;
        break;
      }
    }

    if (playerBroom.getIsPetPresent()) {
      return false;
    }

    for (Room room : playerAroom.getNeighbors()) {
      if (playerBroom.getName().equals(room.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String movePet(String roomName) throws IllegalArgumentException, IllegalStateException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }
    if (roomName == null || "".equals(roomName)) {
      throw new IllegalArgumentException("Room name cannot be null or an empty string.");
    }
    Room movingRoom = null;
    for (Room r : this.roomsList) {
      if (roomName.equals(r.getName())) {
        movingRoom = r;
        break;
      }
    }
    if (movingRoom == null) {
      throw new IllegalArgumentException("Please enter a valid room name that exists in the"
              + " world.");
    }

    Room currentPetRoom = null;
    for (Room room : this.roomsList) {
      if (this.targetPet.getCurrentRoom().getName().equals(room.getName())) {
        currentPetRoom = room;
      }
    }

    currentPetRoom.statusChangePetInRoom(false);
    movingRoom.statusChangePetInRoom(true);
    targetPet.movePet(movingRoom);
    this.numberOfTurns++;
    this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
    targetPiece.move();
    String result = targetPet.movePet(movingRoom);
    return result;
  }

  @Override
  public String attack(String itemName) throws IllegalArgumentException, IllegalStateException {
    if (numberOfTurns >= maxTurns) {
      throw new IllegalStateException("Game has ended already. Nobody wins and the "
              + "target escapes.\n");
    }
    if (itemName == null || "".equals(itemName)) {
      throw new IllegalArgumentException("Item name cannot be null or an empty string.");
    }
    Player currentPlayer = this.playerList.get(this.currentTurnListIndex);
    StringBuilder stringBuilder = new StringBuilder("");

    Item item = null;
    for (Item i : this.itemsList) {
      if (itemName.equals(i.getName())) {
        item = i;
        break;
      }
    }

    if (!("poke".equals(itemName)) && item == null) {
      throw new IllegalArgumentException("No such item exists, please enter a valid item.");
    }

    // If target not in same room, attack fails
    if (!(this.targetPiece.getCurrentRoom().getName()
            .equals(currentPlayer.getCurrentRoom().getName()))) {
      throw new IllegalArgumentException("Target not in the same room, cannot attempt attack on"
              + " target if not in the same room.\n");
    }

    // If other players can see the current player, attack fails.
    for (Player p : this.playerList) {
      if (!(p.getName().equals(currentPlayer.getName())) && canSeePlayer(p, currentPlayer)) {
        stringBuilder.append("Other players saw you attack, attack unsuccessful.\n");
        this.numberOfTurns++;
        this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
        targetPiece.move();
        if (item != null) {
          currentPlayer.removeItemFromBag(item);
        }
        this.itemsList.remove(item);

        Room petPrevRoom = this.targetPet.getCurrentRoom();
        for (Room r : this.roomsList) {
          if (petPrevRoom.getName().equals(r.getName())) {
            petPrevRoom = r;
            break;
          }
        }
        petPrevRoom.statusChangePetInRoom(false);
        Room petCurrentRoom = this.targetPet.movePetDfs();
        for (Room r : this.roomsList) {
          if (petCurrentRoom.getName().equals(r.getName())) {
            petCurrentRoom = r;
            break;
          }
        }
        petCurrentRoom.statusChangePetInRoom(true);

        return stringBuilder.toString();
      }
    }

    // If poke is the attack to be made.
    if ("poke".equals(itemName)) {
      if (currentPlayer.getItemList().size() > 0) {
        throw new IllegalArgumentException("You cannot poke when you still have items in "
                + "your bag.");
      }

      this.targetPiece.receiveAttack(1);
      stringBuilder.append("Poke attack was successful.\n");
      int targetCurrentHealth = (this.targetPiece.getHealth() < 0) ? 0 : this.targetPiece
              .getHealth();
      stringBuilder.append("\nCurrent target health: ").append(targetCurrentHealth)
              .append("\n");
      this.numberOfTurns++;
      this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
      targetPiece.move();

      Room petPrevRoom = this.targetPet.getCurrentRoom();
      for (Room r : this.roomsList) {
        if (petPrevRoom.getName().equals(r.getName())) {
          petPrevRoom = r;
          break;
        }
      }
      petPrevRoom.statusChangePetInRoom(false);
      Room petCurrentRoom = this.targetPet.movePetDfs();
      for (Room r : this.roomsList) {
        if (petCurrentRoom.getName().equals(r.getName())) {
          petCurrentRoom = r;
          break;
        }
      }
      petCurrentRoom.statusChangePetInRoom(true);

      return stringBuilder.toString();
    }

    // If an item from the bag is used to make an attack
    int damage = item.getDamage();
    this.targetPiece.receiveAttack(damage);
    currentPlayer.removeItemFromBag(item);
    this.itemsList.remove(item);

    this.numberOfTurns++;
    this.currentTurnListIndex = (this.currentTurnListIndex + 1) % (playerList.size());
    targetPiece.move();

    Room petPrevRoom = this.targetPet.getCurrentRoom();
    for (Room r : this.roomsList) {
      if (petPrevRoom.getName().equals(r.getName())) {
        petPrevRoom = r;
        break;
      }
    }
    petPrevRoom.statusChangePetInRoom(false);
    Room petCurrentRoom = this.targetPet.movePetDfs();
    for (Room r : this.roomsList) {
      if (petCurrentRoom.getName().equals(r.getName())) {
        petCurrentRoom = r;
        break;
      }
    }
    petCurrentRoom.statusChangePetInRoom(true);

    stringBuilder = new StringBuilder("");
    stringBuilder.append("The attack was successful with item ").append(item.getName())
            .append("and damage ").append(damage).append("\n");
    int targetCurrentHealth = (this.targetPiece.getHealth() < 0) ? 0 : this.targetPiece.getHealth();
    stringBuilder.append("\nCurrent target health: ").append(targetCurrentHealth)
            .append("\n");
    return stringBuilder.toString();
  }

  @Override
  public void generateBaseImage(int scaleUpRow, int scaleUpCol) throws IllegalArgumentException {
    if (scaleUpRow <= 0 || scaleUpCol <= 0) {
      throw new IllegalArgumentException("Scaling factor must be greater than or equal to 1.");
    }
    this.scaleUpRow = scaleUpRow;
    this.scaleUpCol = scaleUpCol;

    this.baseImage = this.imageDisplayer.draw(scaleUpRow, scaleUpCol);
    paintPlayersOnBaseImage();
  }

  @Override
  public BufferedImage getBaseImage() {
    return this.baseImage;
  }

  @Override
  public List<String> getRoomNames() {
    List<String> roomNames = new ArrayList<>();
    for (Room room : this.roomsList) {
      roomNames.add(room.getName());
    }
    return roomNames;
  }

  @Override
  public List<String> getItemNamesInBag() {
    List<String> itemNamesInBag = new ArrayList<>();
    itemNamesInBag.add("poke");
    Player currentPlayer = this.playerList.get(this.currentTurnListIndex);
    for (Item item : currentPlayer.getItemList()) {
      itemNamesInBag.add(item.getName());
    }
    return itemNamesInBag;
  }

  @Override
  public List<String> getItemNamesInRoom() {
    List<String> itemNames = new ArrayList<>();
    Room currentPlayerRoom = this.playerList.get(this.currentTurnListIndex).getCurrentRoom();
    for (Room room : this.roomsList) {
      if (currentPlayerRoom.getName().equals(room.getName())) {
        currentPlayerRoom = room;
        break;
      }
    }
    for (Item item : currentPlayerRoom.getItemsList()) {
      itemNames.add(item.getName());
    }
    return itemNames;
  }

  @Override
  public void generateOverlayPieceCoordinates() {
    this.overlayPieceCoordinates = new ArrayList<>();
    Room targetRoom = this.targetPiece.getCurrentRoom();
    int startXtarget = (targetRoom.getLeftTopRow()) * this.scaleUpRow;
    int startYtarget = (targetRoom.getLeftTopCol()) * this.scaleUpCol;

    List<Integer> targetCoordinates = new ArrayList<>();
    targetCoordinates.add(startYtarget);
    targetCoordinates.add(startXtarget);
    this.overlayPieceCoordinates.add(targetCoordinates);

    int rowCount = 1;
    int colCount = 0;

    for (Player p : this.playerList) {
      List<Integer> playerCoordinates = new ArrayList<>();
      Room room = p.getCurrentRoom();
      if (room.getName().equals(targetPet.getCurrentRoom().getName())) {
        playerCoordinates.add(-1);
        playerCoordinates.add(-1);
      } else {
        int startX = (room.getLeftTopRow()) * this.scaleUpRow;
        int startY = (room.getLeftTopCol()) * this.scaleUpCol;
        int height = (room.getRightBottomRow() - room.getLeftTopRow() + 1) * this.scaleUpRow;
        int width = (room.getRightBottomCol() - room.getLeftTopCol() + 1) * this.scaleUpCol;

        int playerY = startX + ((height / 4) * (rowCount));
        int playerX = startY + ((width / 3) * (colCount));

        playerCoordinates.add(playerX);
        playerCoordinates.add(playerY);
      }

      rowCount++;
      if (rowCount == 4) {
        colCount++;
        rowCount = 0;
      }

      this.overlayPieceCoordinates.add(playerCoordinates);
    }
  }

  @Override
  public String getRoomNameFromCoordinates(int x, int y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("The coordinate values cannot be negative.");
    }

    String roomName;
    for (Room room : this.roomsList) {
      int startX = (room.getLeftTopRow()) * this.scaleUpRow;
      int startY = (room.getLeftTopCol()) * this.scaleUpCol;
      int endX = (room.getRightBottomRow()) * this.scaleUpRow;
      int endY = (room.getRightBottomCol()) * this.scaleUpCol;

      if (x >= startX && x <= endX && y >= startY && y <= endY) {
        return room.getName();
      }

    }
    return "Invalid click";
  }

  @Override
  public String getCurrentPlayerRoomName() {
    Room room = this.playerList.get(this.currentTurnListIndex).getCurrentRoom();
    return room.getName();
  }
}