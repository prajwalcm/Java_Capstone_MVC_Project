package model;

import java.util.List;

/**
 * Represents the target piece on the board and contains various functionalities to decide the state
 * of a target object.
 */
public class TargetImpl implements Target {
  private String name;
  private int number;
  private Room currentRoom;
  private List<Room> roomList;
  private int health;

  /**
   * Initializes the target piece using the parameters passed to initialize the state of the object.
   *
   * @param number number/id of the piece.
   * @param name name of the piece.
   * @param health health of the piece.
   * @param roomList list of rooms in the world.
   * @throws IllegalArgumentException for invalid parameters to the constructor.
   */
  public TargetImpl(int number, String name, int health, List<Room> roomList) throws
          IllegalArgumentException {
    // Validating parameters passed.
    if (name == null || "".equals(name)) {
      throw new IllegalArgumentException("Target name cannot be null or target name cannot be "
             + "an empty string");
    }

    if (number < 0) {
      throw new IllegalArgumentException("Number cannot be negative.");
    }

    if (health < 0) {
      throw new IllegalArgumentException("Health of target player cannot be negative");
    }

    if (roomList == null || roomList.size() < 1) {
      throw new IllegalArgumentException("Room list cannot be null or length of room list cannot "
             + "be less than 1.");
    }

    if (health < 0) {
      throw new IllegalArgumentException("Health cannot be negative");
    }

    this.currentRoom = roomList.get(0); // Initialize to room 0 i.e. first room in the rooms list.
    this.name = name;
    this.number = number;
    this.health = health;
    this.roomList = roomList;
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
  public Room getCurrentRoom() {
    Room copyRoom = new RoomImpl(currentRoom.getRoom(), currentRoom.getName(),
            currentRoom.getLeftTopRow(), currentRoom.getLeftTopCol(),
            currentRoom.getRightBottomRow(), currentRoom.getRightBottomCol(),
            currentRoom.getItemsList());
    return copyRoom;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public void move() {
    int currentIndexOfRoom = this.getCurrentRoom().getRoom();
    int lengthOfRoomsList = roomList.size();
    this.currentRoom = roomList.get((currentIndexOfRoom + 1) % lengthOfRoomsList);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Target name: ").append(getName())
            .append("\nTarget health: ").append(getHealth())
            .append("\nTarget current room name: ")
            .append(this.currentRoom.getName())
            .append("\nTarget current room number/index: ")
            .append(this.currentRoom.getRoom()).append("\n");

    return stringBuilder.toString();
  }

  @Override
  public void receiveAttack(int damage) throws IllegalArgumentException {
    // Need to implement this after getting more requirements in future milestones.
    if (damage <= 0) {
      throw new IllegalArgumentException("Damage of an attack cannot be negative.");
    }
    this.health -= damage;
  }

}
