package modeltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemImpl;
import model.Player;
import model.PlayerImpl;
import model.Room;
import model.RoomImpl;
import org.junit.Test;

/**
 * This class represents the test suite for the Room class.
 */
public class RoomImplTest {

  /**
   * Checks whether negative index for room throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomIndexNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(-1, "Helipad", 0, 0, 10,
            10, itemsList);
  }

  /**
   * Checks whether valid room index create the object successfully.
   */
  @Test
  public void testValidRoomIndex() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
  }


  /**
   * Checks whether room name = null throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, null, 0, 0, 4,
            3, itemsList);
  }

  /**
   * Checks whether room name is an empty string. throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "", 0, 0, 4,
            3, itemsList);
  }

  /**
   * Checks whether room name != null instantiates object successfully.
   */
  @Test
  public void testRoomNameIsNotNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Lab", 0, 0, 4,
            3, itemsList);
  }


  /**
   * Checks whether negative left top row throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomLeftTopRowNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", -1, 0, 4,
            3, itemsList);
  }

  /**
   * Checks whether negative left top column throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomLeftTopColNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, -1, 4,
            3, itemsList);
  }

  /**
   * Checks whether right bottom row < 1 throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomRightBottomRowLessThanOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 0,
            3, itemsList);
  }

  /**
   * Checks whether right bottom column < 1 throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomRightBottomColLessThanOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            0, itemsList);
  }

  /**
   * Check if valid left top row instantiates the object.
   */
  @Test
  public void testLeftTopRowNonNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Check if valid left top column instantiates the object.
   */
  @Test
  public void testLeftTopColNonNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Check if valid right bottom row instantiates the object.
   */
  @Test
  public void testRightBottomRowPositive() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Check if valid right bottom column instantiates the object.
   */
  @Test
  public void testRightBottomColPositive() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Checks for IllegalArgumentException when right bottom row <= left top row.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRbrLessThanEqualLtr() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 0,
            5, itemsList);
  }

  /**
   * Checks and instantiates object when Right Bottom Row>Left Top Row.
   */
  @Test
  public void testRbrGraterThanLtr() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }


  /**
   * Checks for IllegalArgumentException when Right Bottom Column<=Left Top Column.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRbcLessThanEqualLtc() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 5, 4,
            5, itemsList);
  }

  /**
   * Checks and instantiates object when Right Bottom Column > Left Top Column.
   */
  @Test
  public void testRbcGreaterThanLtc() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Checks and instantiates object when length of item list is non negative.
   */
  @Test
  public void testLengthOfItemListNonNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Checks and throws IllegalArgumentException when item list = null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNullItemList() {
    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, null);
  }

  /**
   * Checks and instantiates object when all valid parameters are passed.
   */
  @Test
  public void testValidRoomConstruction() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);
  }

  /**
   * Testing for whether it throws IllegalArgumentException when room list size  == 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testCalculateNeighborsAndSaveRoomListSizeNonPositive() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "LabWest", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "WestCorridor", 5, 0, 16,
            3, itemsList);

    List<Room> rlist = new ArrayList<>();

    room1.calculateNeighborsAndSave(rlist);
  }

  /**
   * Testing for whether it throws IllegalArgumentException when room list is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testCalculateNeighborsAndSaveRoomListNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "LabWest", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(0, "LabWest", 5, 0, 16,
            3, itemsList);

    room1.calculateNeighborsAndSave(null);
  }

  /**
   * Testing for whether we get correct neighbors when all valid parameters are passed.
   */
  @Test
  public void testCalculateNeighborsAndSaveValidParameters() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "LabWest", 0, 0, 4,
            3, itemsList);

    Room room2 = new RoomImpl(1, "Corridor", 5, 0, 16,
            3, itemsList);

    List<Room> rlist = new ArrayList<>();
    rlist.add(room1);
    rlist.add(room2);

    room1.calculateNeighborsAndSave(rlist);

    assertEquals("Corridor", room1.getNeighbors().get(0).getName());
  }

  /**
   * Tests whether the expected String value is returned after calling toString().
   */
  @Test
  public void testToString() {
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

    room1.statusChangePetInRoom(true);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: true\n")
            .append("Players in the room: \n");

    assertEquals(stringBuilder.toString(), room1.toString());
  }

  /**
   * Tests whether the expected String value is returned after calling toString() when pet is
   * present in the room.
   */
  @Test
  public void testToStringPetPresentInRoom() {
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

    room1.statusChangePetInRoom(true);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: true\n")
            .append("Players in the room: \n");

    assertEquals(stringBuilder.toString(), room1.toString());
  }

  /**
   * Tests whether the expected String value is returned after calling toString() when pet is not
   * present in the room.
   */
  @Test
  public void testToStringPetNotPresentInRoom() {
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

    room1.statusChangePetInRoom(false);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: false\n")
            .append("Players in the room: \n");

    assertEquals(stringBuilder.toString(), room1.toString());
  }

  /**
   * Testing toString() when pet was not in the room before but was moved to the current room,
   * room’s toString() should be able to return the correct string value.
   */
  @Test
  public void testToStringPetNotInRoomThenMovedToRoom() {
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

    room1.statusChangePetInRoom(false);
    String result = room1.toString();

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: false\n")
            .append("Players in the room: \n");

    room1.statusChangePetInRoom(true);
    result += room1.toString();

    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: true\n")
            .append("Players in the room: \n");


    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing toString() when pet was in the room before but was moved to another room, room’s
   * toString() should be able to return the correct string value.
   */
  @Test
  public void testToStringPetInRoomThenNotInRoom() {
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

    room1.statusChangePetInRoom(true);
    String result = room1.toString();

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: true\n")
            .append("Players in the room: \n");

    room1.statusChangePetInRoom(false);
    result += room1.toString();

    stringBuilder.append(" Kitchen\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: ElevatorRoom HallWay \n")
            .append("Pet present in the room: false\n")
            .append("Players in the room: \n");


    assertEquals(stringBuilder.toString(), result);
  }


  /**
   * Checks whether getNeighbors() function of a room works as expected if rooms share a wall.
   */
  @Test
  public void testingGetNeighborsHasNeighbors() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);

    assertEquals(room2, room1.getNeighbors().get(0));
  }

  /**
   * Checks whether getNeighbors() function of a room works as expected if rooms don't share a wall.
   */
  @Test
  public void testingGetNeighborsNoNeighbors() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 10, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);

    assertEquals(0, room1.getNeighbors().size());
  }


  /**
   * Checks whether getItemList() returns a proper list of all the items in the room.
   */
  @Test
  public void testGetItemList() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    assertEquals(1, room.getItemsList().size());
  }

  /**
   * Testing if 2 equal rooms based on their name return true when checked using equals().
   */
  @Test
  public void testEqualsEqualRooms() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Room room2 = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(true, room1.equals(room2));
  }


  /**
   * Testing if 2 non-equal rooms based on their name return false when checked using equals().
   */
  @Test
  public void testEqualsNonEqualRooms() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Room room2 = new RoomImpl(1, "LabEast", 0, 0, 4,
            5, itemsList);

    assertEquals(false, room1.equals(room2));
  }

  /**
   * Tests whether the correct value of left top row is returned or not.
   */
  @Test
  public void testGetLeftTopRow() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(0, room.getLeftTopRow());
  }

  /**
   * Tests whether the correct value of left top column is returned or not.
   */
  @Test
  public void testGetLeftTopCol() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(0, room.getLeftTopCol());
  }

  /**
   * Tests whether the correct value of right bottom row is returned or not.
   */
  @Test
  public void testGetRightTopRow() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(4, room.getRightBottomRow());
  }

  /**
   * Tests whether the correct value of right bottom column is returned or not.
   */
  @Test
  public void testGetRightBottomCol() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(5, room.getRightBottomCol());
  }

  /**
   * Tests whether correct room number is getting returned.
   */
  @Test
  public void testGetRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals(0, room.getRoom());
  }

  /**
   * Tests whether correct room name is getting returned.
   */
  @Test
  public void testGetRoomName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    assertEquals("LabWest", room.getName());
  }

  /**
   * Tests whether adding player = null throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerToRoomPlayerNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    room.addPlayerToRoom(null);
  }

  /**
   * Tests whether adding valid player works as expected.
   */
  @Test
  public void testAddPlayerToRoomPlayerValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12, true);

    room.addPlayerToRoom(player);

    String playerName = room.getPlayersInRoom().get(0).getName();

    assertEquals(playerName, player.getName());
  }

  /**
   * Tests whether removing a player that does not exist in the room throws an
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemovePlayerFromRoomNonExistingPlayer() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Player player1 = new PlayerImpl(1, "sid", room, 12, true);
    Player player2 = new PlayerImpl(2, "sid2", room, 10, true);

    room.addPlayerToRoom(player1);

    room.removePlayerFromRoom(player2);
  }

  /**
   * Tests whether removing player from empty player list throws IllegalStateException.
   */
  @Test(expected = IllegalStateException.class)
  public void testRemovePlayerFromRoomEmptyList() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12, true);

    room.removePlayerFromRoom(player);
  }

  /**
   * Tests whether removing valid player works as expected.
   */
  @Test
  public void testRemovePlayerFromRoomValidPlayer() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12, true);

    room.addPlayerToRoom(player);
    room.removePlayerFromRoom(player);
  }

  /**
   * Tests whether trying to remove null player throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemovePlayerFromRoomPlayerNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    room.removePlayerFromRoom(null);
  }

  /**
   * Testing whether removing a non existing item from a room throws IllegalArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveItemFromRoomNonExistingItem() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Item tempItem = new ItemImpl(2, "Kunai Knife", 4, 1);

    room.removeItemFromRoom(tempItem);
  }

  /**
   * Testing whether removing item from room throws IllegalArgumentException when item is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveItemFromRoomItemNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    room.removeItemFromRoom(null);
  }

  /**
   * Testing whether removing item from room throws IllegalArgumentException when item list is
   * empty.
   */
  @Test (expected = IllegalStateException.class)
  public void testRemoveItemFromRoomItemListEmpty() {
    List<Item> itemList = new ArrayList<>();

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemList);

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);

    room.removeItemFromRoom(item);
  }

  /**
   * Testing whether valid item gets removed from the item list when valid parameters are passed.
   */
  @Test
  public void testRemoveItemFromRoomValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    room.removeItemFromRoom(item1);
  }

  /**
   * Tests whether the function returns the list of players in the room currently.
   */
  @Test
  public void testGetPlayersInRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "LabWest", 0, 0, 4,
            5, itemsList);

    Player player1 = new PlayerImpl(1, "sid", room, 12, true);
    Player player2 = new PlayerImpl(2, "sid2", room, 10, true);

    room.addPlayerToRoom(player1);
    room.addPlayerToRoom(player2);

    List<Player> tempPlayersList = new ArrayList<>();
    tempPlayersList.add(player1);
    tempPlayersList.add(player2);

    assertEquals(tempPlayersList.toString(), room.getPlayersInRoom().toString());
  }
}