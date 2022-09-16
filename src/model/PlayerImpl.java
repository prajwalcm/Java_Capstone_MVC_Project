package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player piece i.e. the pieces on the board other than the target.
 */
public class PlayerImpl implements Player {
  private String name;
  private int number;
  private List<Item> itemList;
  private int spiteLevel;
  private Room currentRoom;
  private int itemBagLimit;
  private Boolean isHuman;

  /**
   * Initializes the player using the parameters passed to initialize the state of the object.
   *
   * @param number number/id of the piece.
   * @param name name of the piece.
   * @param currentRoom current room the player is in.
   * @param itemBagLimit limit of the number of items that can be in the player's item list.
   * @param isHuman whether the player is human or not.
   * @throws IllegalArgumentException when either number or name or room name or item bag limit
   *        values are invalid and passed to this constructor.
   *
   */
  public PlayerImpl(int number, String name, Room currentRoom, int itemBagLimit,
                    boolean isHuman) throws IllegalArgumentException {
    if (number < 0) {
      throw new IllegalArgumentException("Player number cannot be less than 0");
    }

    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Name cannot be null or name cannot be an empty string.");
    }

    // Checking if room is not null or not.
    if (currentRoom == null) {
      throw new IllegalArgumentException("Current object cannot be null");
    }

    // Checking if itemBagLimit >= 0 or not
    if (itemBagLimit < 0) {
      throw new IllegalArgumentException("Item bag limit cannot be less than 0.");
    }

    this.name = name;
    this.number = number;
    this.isHuman = isHuman;
    this.itemBagLimit = itemBagLimit;
    this.currentRoom = currentRoom;
    this.itemList = new ArrayList<>();
  }

  @Override
  public Room getCurrentRoom() {
    Room copyRoom = new RoomImpl(currentRoom.getRoom(), currentRoom.getName(),
            currentRoom.getLeftTopRow(), currentRoom.getLeftTopCol(),
            currentRoom.getRightBottomRow(), currentRoom.getRightBottomCol(),
            currentRoom.getItemsList());
    copyRoom.statusChangePetInRoom(currentRoom.getIsPetPresent());
    return copyRoom;
  }

  @Override
  public List<Item> getItemList() {
    List<Item> copyItemsList = new ArrayList<>();
    for (Item item : this.itemList) {
      Item copyItem = new ItemImpl(item.getId(), item.getName(), item.getDamage(),
              item.getContainingRoomIndex());

      copyItemsList.add(copyItem);
    }
    return copyItemsList;
  }

  @Override
  public int getSpiteLevel() {
    return spiteLevel;
  }

  @Override
  public String move(Room room) throws IllegalArgumentException {
    if (room == null) {
      throw new IllegalArgumentException("Invalid room passed");
    }

    boolean isRoomNeighbor = false;
    for (Room r : this.currentRoom.getNeighbors()) {
      if (r.getName().equals(room.getName())) {
        isRoomNeighbor = true;
      }
    }

    if (!isRoomNeighbor) {
      throw new IllegalArgumentException("Moving to a room that is not a neighbor of the current"
             + " room is not allowed.");
    }

    this.currentRoom = room;

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player ").append(name).append(" moved to room: ")
            .append(currentRoom.getName())
            .append("\n");

    return stringBuilder.toString();
  }

  @Override
  public boolean pickItem(Item item) throws IllegalArgumentException {
    if (item == null) {
      throw new IllegalArgumentException("Invalid item.");
    }
    if (this.itemList.size() >= this.itemBagLimit) {
      return false;
    }

    // Checking if item present in the room the player is in.

    boolean isItemPresent = false;

    for (Item i : this.currentRoom.getItemsList()) {
      if (i.getName().equals(item.getName())) {
        isItemPresent = true;
      }
    }

    if (!isItemPresent) {
      throw new IllegalArgumentException("Item is not present in the room");
    }

    this.itemList.add(item);

    return true;
  }

  @Override
  public int getItemBagLimit() {
    return this.itemBagLimit;
  }

  @Override
  public String lookAround() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: ").append(this.getCurrentRoom().getName());

    stringBuilder.append("\nCurrent players in the room:\n");

    int count = 1;
    for (Player p : currentRoom.getPlayersInRoom()) {
      stringBuilder.append(count).append(". ").append(p.getName()).append("\n");
      count++;
    }

    stringBuilder.append("Items in the current room:\n");

    count = 1;
    for (Item i : this.currentRoom.getItemsList()) {
      stringBuilder.append(count).append(". ").append(i.getName()).append("\n");
      count++;
    }

    stringBuilder.append("\nSpaces seen from the room: \n");
    count = 1;
    for (Room room : this.currentRoom.getNeighbors()) {
      if (!room.getIsPetPresent()) {
        stringBuilder.append(count).append(". ").append(room.getName()).append("\n");
        stringBuilder.append("Players in the room: \n");
        int countTemp = 1;
        for (Player p : room.getPlayersInRoom()) {
          stringBuilder.append(countTemp).append(". ").append(p.getName()).append("\n");
          countTemp++;
        }
        stringBuilder.append("Items in the room: \n");
        countTemp = 1;
        for (Item i : room.getItemsList()) {
          stringBuilder.append(countTemp).append(". ").append(i.getName()).append("\n");
          countTemp++;
        }
        count++;
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getNumber() {
    return this.number;
  }

  @Override
  public boolean getIsHuman() {
    return this.isHuman;
  }

  @Override
  public boolean removeItemFromBag(Item item) throws IllegalArgumentException {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null.");
    }

    if (itemList.size() <= 0) {
      return false;
    }

    boolean isItemPresent = false;

    for (Item i : this.itemList) {
      if (i.getName().equals(item.getName())) {
        isItemPresent = true;
      }
    }

    if (!isItemPresent) {
      throw new IllegalArgumentException("Item is not present in the bag to remove.");
    }

    this.itemList.remove(item);

    return true;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player name: ").append(name).append("\n")
            .append("Player current room: ").append(currentRoom.getName()).append("\n")
            .append("Player items: ");

    for (Item item : this.itemList) {
      stringBuilder.append(item.getName()).append(" ");
    }

    return stringBuilder.toString();
  }
}
