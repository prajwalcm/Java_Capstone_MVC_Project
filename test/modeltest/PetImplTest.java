package modeltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemImpl;
import model.Pet;
import model.PetImpl;
import model.Room;
import model.RoomImpl;
import model.World;
import model.WorldImpl;
import org.junit.Test;

/**
 * This class represents the testing suite for the PetImpl class.
 */
public class PetImplTest {
  /**
   * Testing for successful construction when all parameters passed are valid.
   */
  @Test
  public void testConstructionAllValidParameters() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when name is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionPetNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl(null, room1, roomsList);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when name is an empty String.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionPetNameEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("", room1, roomsList);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when currentRoom is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionCurrentRoomNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("", null, roomsList);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when list of rooms passed is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionRoomsListNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Pet targetPet = new PetImpl("Yeti", room1, null);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when the size of list of Rooms is 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionRoomsListSizeZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
  }

  /**
   * Testing whether getCurrentRoom returns a valid room when called.
   */
  @Test
  public void testGetCurrentRoomValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    assertEquals(room1.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether room at index 0 of the global room list is returned when the game starts for
   * getting current room of the pet. It can be tested using the toString of the world which
   * includes the current room of the pet.
   */
  @Test
  public void testGetCurrentRoomValidResultWhenGameStarts() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    World world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "YetiAlien", 100, 30);

    StringBuilder stringBuilder = new StringBuilder("");

    stringBuilder.append("Number of rows: 20\n")
            .append("Number of columns: 30\n")
            .append("World name: Area51\n")
            .append("Target name: alien\n")
            .append("Target in room: Helipad\n")
            .append("Target pet name: YetiAlien\n")
            .append("Target pet current room: Helipad\n")
            .append("\n")
            .append("Number of spaces: 2\n");

    assertEquals(stringBuilder.toString(), world.toString());
  }

  /**
   * Testing whether getName returns the name of the pet when called.
   */
  @Test
  public void testGetNameValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    assertEquals("Yeti", targetPet.getName());
  }

  /**
   * Testing whether IllegalArgumentException is thrown when room is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMovePetRoomIsNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePet(null);
  }

  /**
   * Testing whether IllegalArgumentException is thrown when the room passed is not present in the
   * roomslist.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMovePetInvalidRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Room invalidRoom = new RoomImpl(2, "Galaxy", 0, 0, 4,
            3, itemsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePet(invalidRoom);
  }

  /**
   * Testing whether movePet actually moves the pet to the specified room.
   */
  @Test
  public void testMovePetValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePet(room2);
    assertEquals(room2.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether the pet moves to the next unvisited neighbour room as per the sequence in the
   * next call to this function.
   */
  @Test
  public void testMovePetDfsInOrder() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    Room room3 = new RoomImpl(2, "Corridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);
    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePetDfs();
    targetPet.movePetDfs();

    assertEquals(room2.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether the pet moves back to the parent room when all neighbours of the room are
   * visited.
   */
  @Test
  public void testMovePetDfsMovesBackToParentWhenAllNeighVisited() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Kitchen", 0, 6, 5,
            8, itemsList);

    Room room2 = new RoomImpl(1, "ElevatorRoom", 0, 9, 5,
            11, itemsList);

    Room room3 = new RoomImpl(2, "Observatory1", 0, 12,
            5, 16, itemsList);

    Room room4 = new RoomImpl(3, "HallWay", 6, 6, 20,
            11, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);
    roomsList.add(room3);
    roomsList.add(room4);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);
    room4.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();

    assertEquals(room2.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether the pet starts from room 0 in the roomsList when all the rooms are visited.
   */
  @Test
  public void testMovePetDfsStartFromZeroWhenAllVisited() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Kitchen", 0, 6, 5,
            8, itemsList);

    Room room2 = new RoomImpl(1, "ElevatorRoom", 0, 9, 5,
            11, itemsList);

    Room room3 = new RoomImpl(2, "Observatory1", 0, 12,
            5, 16, itemsList);

    Room room4 = new RoomImpl(3, "HallWay", 6, 6, 20,
            11, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);
    roomsList.add(room3);
    roomsList.add(room4);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);
    room4.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();

    assertEquals(room1.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether the pet starts from room 0 in the roomsList when the first time it's called.
   */
  @Test
  public void testMovePetDfsStartAtRoom0WhenFirstCalled() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Kitchen", 0, 6, 5,
            8, itemsList);

    Room room2 = new RoomImpl(1, "ElevatorRoom", 0, 9, 5,
            11, itemsList);

    Room room3 = new RoomImpl(2, "Observatory1", 0, 12,
            5, 16, itemsList);

    Room room4 = new RoomImpl(3, "HallWay", 6, 6, 20,
            11, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);
    roomsList.add(room3);
    roomsList.add(room4);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);
    room4.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePetDfs();
    assertEquals(room1.getName(), targetPet.getCurrentRoom().getName());
  }

  /**
   * Testing whether the pet starts DFS from the current room next after an operation of movePet()
   * to the current Room was made.
   */
  @Test
  public void testMovePetDfsStartAtCurrentRoomAfterMovePet() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Kitchen", 0, 6, 5,
            8, itemsList);

    Room room2 = new RoomImpl(1, "ElevatorRoom", 0, 9, 5,
            11, itemsList);

    Room room3 = new RoomImpl(2, "Observatory1", 0, 12,
            5, 16, itemsList);

    Room room4 = new RoomImpl(3, "HallWay", 6, 6, 20,
            11, itemsList);

    roomsList.add(room1);
    roomsList.add(room2);
    roomsList.add(room3);
    roomsList.add(room4);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);
    room4.calculateNeighborsAndSave(roomsList);

    Pet targetPet = new PetImpl("Yeti", room1, roomsList);
    targetPet.movePetDfs();
    targetPet.movePetDfs();
    targetPet.movePetDfs();

    targetPet.movePet(room2);
    assertEquals(room2.getName(), targetPet.getCurrentRoom().getName());
  }

}
