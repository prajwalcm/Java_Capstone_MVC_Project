package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents the state of the target's pet in the game and a set of functionalities so as to
 * emulate the behaviour that is expected from the target's pet.
 */
public class PetImpl implements Pet {
  private final String petName;
  private Room currentRoom;
  private List<Room> roomsList;
  private Deque<Room> roomStack;
  private Set<Room> visitedRooms;
  private Map<String, Integer> currNeighborIndexMap;

  /**
   * Constructs the object representing the target character's pet in the game and initializes the
   * name and the current room of the pet.
   *
   * @param petName Name of the pet.
   * @param currentRoom Current room where the per is residing.
   * @throws IllegalArgumentException Either petName is null or petName is an empty string or
   *        current Room is passed as null. It also throws this exception when roomsList that is
   *        passed is null. It also throws this exception when the size of the roomsList is 0.
   */
  public PetImpl(String petName, Room currentRoom, List<Room> roomsList)
          throws IllegalArgumentException {
    if (petName == null || "".equals(petName)) {
      throw new IllegalArgumentException("Pet name cannot be null or pet name cannot be"
              + " an empty string.");
    }

    if (roomsList == null) {
      throw new IllegalArgumentException("RoomsList argument cannot be null.");
    }

    if (roomsList.size() == 0) {
      throw new IllegalArgumentException("Size of the roomsList cannot be 0.");
    }

    if (currentRoom == null) {
      throw new IllegalArgumentException("Current room cannot be null");
    }

    this.petName = petName;
    this.currentRoom = currentRoom;
    this.roomsList = new ArrayList<>();
    this.roomStack = new ArrayDeque<>();

    // Create copy of roomList passed and save it in this object's roomsList field.
    for (Room room : roomsList) {
      Room copyRoom = new RoomImpl(room.getRoom(), room.getName(), room.getLeftTopRow(),
              room.getLeftTopCol(), room.getRightBottomRow(),
              room.getRightBottomCol(), room.getItemsList());
      copyRoom.calculateNeighborsAndSave(roomsList);
      this.roomsList.add(copyRoom);
    }

    this.roomStack.push(roomsList.get(0));
    this.visitedRooms = new HashSet<>();
    this.currNeighborIndexMap = new HashMap<>();
    // Initialize the hashmap containing mapping of rooms with the last visited neighbor index in
    // the neighbor lis for that node.
    for (Room room : this.roomsList) {
      this.currNeighborIndexMap.put(room.getName(), 0);
    }
  }

  @Override
  public Room getCurrentRoom() {
    Room copyRoom = new RoomImpl(this.currentRoom.getRoom(), this.currentRoom.getName(),
            this.currentRoom.getLeftTopRow(), this.currentRoom.getLeftTopCol(),
            this.currentRoom.getRightBottomRow(),
            this.currentRoom.getRightBottomCol(), this.currentRoom.getItemsList());
    copyRoom.statusChangePetInRoom(currentRoom.getIsPetPresent());
    return copyRoom;
  }

  @Override
  public String getName() {
    return this.petName;
  }

  @Override
  public String movePet(Room room) throws IllegalArgumentException {
    if (room == null) {
      throw new IllegalArgumentException("Room cannot be null.");
    }

    // Checking if the room actually exists in the rooms list.
    boolean roomIsPresent = false;
    for (Room r : this.roomsList) {
      if (room.getName().equals(r.getName())) {
        roomIsPresent = true;
        break;
      }
    }
    if (!roomIsPresent) {
      throw new IllegalArgumentException("The room passed is not present in the roomslist.");
    }

    Room oldRoom = this.currentRoom;
    oldRoom.statusChangePetInRoom(false);
    this.currentRoom = room;
    currentRoom.statusChangePetInRoom(true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("The pet was successfully moved to ")
            .append(this.currentRoom.getName()).append("\n");

    // Re initialize the DFS to start at this current node.
    this.roomStack = new ArrayDeque<>();
    roomStack.push(currentRoom);
    this.visitedRooms = new HashSet<>();
    // Initialize the hashmap containing mapping of rooms with the last visited neighbor index in
    // the neighbor lis for that node.
    for (Room r : this.roomsList) {
      this.currNeighborIndexMap.put(r.getName(), 0);
    }
    movePetDfs();
    return stringBuilder.toString();
  }

  @Override
  public Room movePetDfs() {
    // If all rooms are visited or the stack is empty, re initialize the stack and visited set to
    // simulate the pet's movement wrapping around to get to first room.
    if (this.roomStack.size() == 0 || this.visitedRooms.size() == this.roomsList.size()) {
      this.roomStack = new ArrayDeque<>();
      roomStack.push(this.roomsList.get(0));
      this.visitedRooms = new HashSet<>();
      // Initialize the hashmap containing mapping of rooms with the last visited neighbor index in
      // the neighbor lis for that node.
      for (Room room : this.roomsList) {
        this.currNeighborIndexMap.put(room.getName(), 0);
      }
    }
    Room currentRoom = roomStack.getFirst();
    this.currentRoom = currentRoom;
    this.visitedRooms.add(currentRoom);
    List<Room> neighbors = currentRoom.getNeighbors();

    boolean flag = false;
    for (int i = this.currNeighborIndexMap.get(currentRoom.getName()); i < neighbors.size(); i++) {
      if (!visitedRooms.contains(neighbors.get(i))) {
        roomStack.push(neighbors.get(i));
        this.currNeighborIndexMap.put(currentRoom.getName(), i);
        flag = true;
        break;
      }
    }

    if (!flag) {
      roomStack.pop();
    }

    return currentRoom;
  }
}
