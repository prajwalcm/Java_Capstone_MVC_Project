package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the state of a room which is a space in the game.
 */
public class RoomImpl implements Room {
  private int room;
  private String name;
  private int leftTopRow;
  private int leftTopCol;
  private int rightBottomRow;
  private int rightBottomCol;
  private List<Room> neighborRooms;
  private List<Item> itemsList;
  private List<Item> globalItemsList;
  private List<Room> globalRoomsList;
  private List<Player> playersInRoom;
  private boolean isPetPresent;

  /**
   * Initializes a room/space in the world with the parameters passed.
   *
   * @param room room index starting from 0 in the room list.
   * @param name name of the room.
   * @param leftTopRow top left row value.
   * @param leftTopCol top left column value.
   * @param rightBottomRow bottom right row value.
   * @param rightBottomCol bottom right column value.
   * @param itemsList list of items present in the room. This can be null.
   * @throws IllegalArgumentException when invalid parameters to the constructor are passed.
   */
  public RoomImpl(int room, String name, int leftTopRow, int leftTopCol, int rightBottomRow,
                  int rightBottomCol, List<Item> itemsList) throws IllegalArgumentException {

    // Validating the parameters passed.

    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Room name cannot be null or room name cannot be an"
              + " empty string.");
    }

    if (itemsList == null) {
      throw new IllegalArgumentException("Item list cannot be null.");
    }

    if (room < 0) {
      throw new IllegalArgumentException("Room index cannot be negative");
    }

    if (leftTopRow < 0) {
      throw new IllegalArgumentException("row number cannot be negative.");
    }

    if (leftTopCol < 0) {
      throw new IllegalArgumentException("column number cannot be negative.");
    }

    if (rightBottomRow < 0) {
      throw new IllegalArgumentException("row number cannot be negative.");
    }

    if (rightBottomCol < 0) {
      throw new IllegalArgumentException("column number cannot be negative.");
    }

    if (rightBottomRow <= leftTopRow) {
      throw new IllegalArgumentException("Right bottom row cannot be <= left top row.");
    }

    if (rightBottomCol <= leftTopCol) {
      throw new IllegalArgumentException("Right bottom column cannot be <= left top column.");
    }

    this.room = room;
    this.name = name;
    this.leftTopRow = leftTopRow;
    this.leftTopCol = leftTopCol;
    this.rightBottomRow = rightBottomRow;
    this.rightBottomCol = rightBottomCol;
    this.neighborRooms = new ArrayList<Room>();
    this.globalItemsList = itemsList;
    this.itemsList = new ArrayList<>();
    this.playersInRoom = new ArrayList<>();

    if (room == 0) {
      this.isPetPresent = true;
    } else {
      this.isPetPresent = false;
    }

    // Generating item list for this room
    this.generateItemList(globalItemsList);
  }

  @Override
  public void calculateNeighborsAndSave(List<Room> roomsList) throws IllegalArgumentException {
    // Validating parameters passed.

    if (roomsList == null || roomsList.size() < 1) {
      throw new IllegalArgumentException("List of rooms cannot be null or list of rooms cannot"
             + " have length less than 1.");
    }

    this.globalRoomsList = roomsList;

    for (Room room : roomsList) {
      if (room.getRoom() != this.room) {
        // Check if room lies on the bottom right corner.
        if ((room.getLeftTopRow() - this.rightBottomRow == 1)
                && (room.getLeftTopCol() - this.rightBottomCol == 1)) {
          continue;
        }
        // Check if room lies on the top right corner.
        if ((room.getLeftTopCol() - this.rightBottomCol == 1)
                && (room.getRightBottomRow() - this.leftTopRow == 1)) {
          continue;
        }

        // Check if room lien on the top left corner
        if ((this.leftTopRow - room.getRightBottomRow() == 1)
                && (this.leftTopCol - room.getRightBottomCol() == 1)) {
          continue;
        }

        // Check if room lies on the bottom left corner
        if ((room.getLeftTopRow() - this.rightBottomRow == 1)
                && (this.leftTopCol - room.getRightBottomCol() == 1)) {
          continue;
        }

        // Else if not a corner relationship

        // Check if room is a right neighbor to this room
        if ((this.rightBottomCol + 1 == room.getLeftTopCol())
                && ((room.getLeftTopRow() >= this.leftTopRow && room.getLeftTopRow()
                <= this.rightBottomRow)
                   || (room.getRightBottomRow() >= this.leftTopRow && room.getRightBottomRow()
                <= this.rightBottomRow)
                   || (this.leftTopRow >= room.getLeftTopRow() && this.rightBottomRow
                <= room.getRightBottomRow())
                || (this.leftTopRow <= room.getLeftTopRow() && this.rightBottomRow
                >= room.getRightBottomRow()))) {
          this.neighborRooms.add(room);
        } else if ((this.leftTopCol - 1 == room.getRightBottomCol())// Check if room is
                // a left neighbor to this room
                && ((room.getLeftTopRow() >= this.leftTopRow && room.getLeftTopRow()
                <= this.rightBottomRow)
                || (room.getRightBottomRow() >= this.leftTopRow && room.getRightBottomRow()
                <= this.rightBottomRow)
                || (room.getLeftTopRow() <= this.leftTopRow && this.rightBottomRow
                <= room.getRightBottomRow())
                || (this.leftTopRow <= room.getLeftTopRow() && this.rightBottomRow
                >= room.getRightBottomRow()))) {
          this.neighborRooms.add(room);
        } else if ((this.leftTopRow - 1 == room.getRightBottomRow())// Check if room is a
            // top neighbor
            && ((this.leftTopCol >= room.getLeftTopCol() && this.leftTopCol
                <= room.getRightBottomCol())
            || (this.rightBottomCol >= room.getLeftTopCol() && this.rightBottomCol
                <= room.getRightBottomCol())
            || (this.leftTopCol <= room.getLeftTopCol() && this.rightBottomCol
                >= room.getRightBottomCol())
            || (room.getLeftTopCol() <= this.leftTopCol && room.getRightBottomCol()
                >= this.leftTopCol))) {
          this.neighborRooms.add(room);
        } else if ((this.rightBottomRow + 1 == room.getLeftTopRow())// Check if room is a bottom
                // neighbor
                && ((this.leftTopCol >= room.getLeftTopCol() && this.leftTopCol
                <= room.getRightBottomCol())
                || (this.rightBottomCol >= room.getLeftTopCol() && this.rightBottomCol
                <= room.getRightBottomCol())
                || (this.leftTopCol <= room.getLeftTopCol() && this.rightBottomCol
                >= room.getRightBottomCol())
                || (room.getLeftTopCol() <= this.leftTopCol && room.getRightBottomCol()
                >= this.rightBottomCol))) {
          this.neighborRooms.add(room);
        }
      }
    }
  }

  /**
   * Generates a list of items that are present in the room form the itemsList passed to this room.
   *
   * @param globalItemsList the global items list that is passed while initializing.
   * @throws IllegalArgumentException when globalItemsList parameter is null.
   */
  private void generateItemList(List<Item> globalItemsList) throws IllegalArgumentException {
    if (globalItemsList == null) {
      throw new IllegalArgumentException("Global items list parameter cannot be null.");
    }

    for (Item item : globalItemsList) {
      if (item.getContainingRoomIndex() == this.room) {
        this.itemsList.add(item);
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");

    for (Room room : neighborRooms) {
      if (room.getIsPetPresent()) {
        continue;
      }
      stringBuilder.append(room.getName()).append(" ");
    }

    String neighborRooms = stringBuilder.toString();

    stringBuilder = new StringBuilder(" ");


    stringBuilder.append(this.name).append("\n")
            .append("Items in room: ").append(itemsList.toString()).append("\n")
            .append("Neighbor rooms: ").append(neighborRooms).append("\n")
            .append("Pet present in the room: ").append(this.isPetPresent).append("\n")
            .append("Players in the room: ").append("\n");

    for (Player player : this.playersInRoom) {
      stringBuilder.append(player.getName()).append("\n");
    }

    return stringBuilder.toString();
  }

  @Override
  public List<Room> getNeighbors() {
    List<Room> copyNeighborRooms = new ArrayList<>();
    for (Room room : neighborRooms) {
      Room copyRoom = new RoomImpl(room.getRoom(), room.getName(), room.getLeftTopRow(),
              room.getLeftTopCol(),
              room.getRightBottomRow(), room.getRightBottomCol(), room.getItemsList());
      copyRoom.calculateNeighborsAndSave(globalRoomsList);
      for (Player p : room.getPlayersInRoom()) {
        copyRoom.addPlayerToRoom(p);
      }
      if (room.getIsPetPresent()) {
        copyRoom.statusChangePetInRoom(true);
      } else {
        copyRoom.statusChangePetInRoom(false);
      }
      List<Player> playersInRoom = room.getPlayersInRoom();
      for (Player p : playersInRoom) {
        copyRoom.addPlayerToRoom(p);
      }
      copyNeighborRooms.add(copyRoom);
    }

    return copyNeighborRooms;
  }

  @Override
  public List<Item> getItemsList() {
    List<Item> copyItemsList = new ArrayList<>();
    for (Item item : itemsList) {
      Item copyItem = new ItemImpl(item.getId(), item.getName(), item.getDamage(),
              item.getContainingRoomIndex());

      copyItemsList.add(copyItem);
    }

    return copyItemsList;
  }

  @Override
  public int getLeftTopRow() {
    return leftTopRow;
  }

  @Override
  public int getLeftTopCol() {
    return leftTopCol;
  }

  @Override
  public int getRightBottomRow() {
    return rightBottomRow;
  }

  @Override
  public int getRightBottomCol() {
    return rightBottomCol;
  }

  @Override
  public int getRoom() {
    return room;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addPlayerToRoom(Player player) throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Invalid player passed");
    }
    this.playersInRoom.add(player);
  }

  @Override
  public void removePlayerFromRoom(Player player) throws IllegalArgumentException {
    if (player == null) {
      throw new IllegalArgumentException("Invalid player passed");
    }

    if (playersInRoom.size() == 0) {
      throw new IllegalStateException("No players in the room currently");
    }

    boolean isPlayerPresent = false;

    for (Player p : playersInRoom) {
      if (p.getName().equals(player.getName())) {
        isPlayerPresent = true;
      }
    }

    if (! isPlayerPresent) {
      throw new IllegalArgumentException("Player is not present in the room.");
    }

    this.playersInRoom.remove(player);
  }

  @Override
  public void removeItemFromRoom(Item item) throws IllegalArgumentException {
    if (item == null) {
      throw new IllegalArgumentException("Invalid item passed.");
    }

    if (itemsList.size() == 0) {
      throw new IllegalStateException("No items in the room currently");
    }

    boolean isItemPresent = false;

    for (Item i : itemsList) {
      if (i.getName().equals(item.getName())) {
        isItemPresent = true;
      }
    }

    if (!isItemPresent) {
      throw new IllegalArgumentException("Item is not present in the room.");
    }

    this.itemsList.remove(item);

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof RoomImpl)) {
      return false;
    }

    Room room = (Room) o;

    return name.equals(room.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public List<Player> getPlayersInRoom() {
    List<Player> copyPlayersList = new ArrayList<>();
    for (Player player : this.playersInRoom) {
      Room playerRoom = player.getCurrentRoom();
      Room copyPlayerRoom = new RoomImpl(playerRoom.getRoom(), playerRoom.getName(),
              playerRoom.getLeftTopRow(), playerRoom.getLeftTopCol(),
              playerRoom.getRightBottomRow(), playerRoom.getRightBottomCol(),
              playerRoom.getItemsList());
      Player copyPlayer = new PlayerImpl(player.getNumber(), player.getName(), copyPlayerRoom,
              player.getItemBagLimit(), player.getIsHuman());

      copyPlayerRoom.addPlayerToRoom(copyPlayer);
      copyPlayersList.add(copyPlayer);
    }
    return copyPlayersList;
  }

  @Override
  public void statusChangePetInRoom(boolean isInRoom) {
    this.isPetPresent = isInRoom;
  }

  @Override
  public boolean getIsPetPresent() {
    return this.isPetPresent;
  }

}
