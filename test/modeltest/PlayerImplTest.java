package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemImpl;
import model.Pet;
import model.PetImpl;
import model.Player;
import model.PlayerImpl;
import model.Room;
import model.RoomImpl;
import org.junit.Test;


/**
 * This class represents the test suite for the PlayerImpl class.
 */
public class PlayerImplTest {

  /**
   * Checking whether entering number >= 0 successfully creates an object.
   */
  @Test
  public void testConstructionNumberNonNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);
  }

  /**
   * Checks whether it throws IllegalArgumentException when number < 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionNumberNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(-1, "sid", room, 12,
            true);
  }

  /**
   * Checks whether it throws IllegalArgumentException when name is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, null, room, 12,
            true);
  }

  /**
   * Checks whether it throws IllegalArgumentException when name is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "", room, 12,
            true);
  }

  /**
   * Checks whether the object is created successfully when name is not null.
   */
  @Test
  public void testConstructionNameNotNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);
  }

  /**
   * Checks whether it throws IllegalArgumentException when room is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionRoomNull() {
    Player player = new PlayerImpl(1, "sid", null, 12,
            true);
  }

  /**
   * Checks whether the object is created successfully when room is not null.
   */
  @Test
  public void testConstructionRoomNotNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);
  }

  /**
   * Checks whether it throws IllegalArgumentException when item bag limit < 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionItemBagLimitNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, -1,
            true);
  }

  /**
   * Checks whether the object is created successfully when item bag limit >= 0.
   */
  @Test
  public void testConstructionItemBagLimitNonNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);
  }

  /**
   * Testing if getCurrentRoom() returns a non null Room.
   */
  @Test
  public void testGetCurrentRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);

    assertEquals(room, player.getCurrentRoom());
  }

  /**
   * Testing if getItemList() returns a list of items.
   */
  @Test
  public void testGetItemList() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room, 12,
            true);

    player.pickItem(item1);

    assertEquals(item1.getName(), player.getItemList().get(0).getName());
  }

  /**
   * Testing move() when the room is null, IllegalArgumentException is thrown.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMoveRoomNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Room room2 = new RoomImpl(1, "Lab", 5, 0, 16,
            3, itemsList);

    List<Room> roomsList = new ArrayList<>();
    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.move(null);
  }

  /**
   * Testing move() when the room is not a neighbour of the current room, IllegalArgumentException
   * is thrown.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMoveRoomNotNeighborOfCurrentRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Room room2 = new RoomImpl(1, "Lab", 6, 0, 16,
            3, itemsList);

    List<Room> roomsList = new ArrayList<>();
    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.move(room2);
  }

  /**
   * Testing move() when valid parameters are passed.
   */
  @Test
  public void testMoveAllValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Room room2 = new RoomImpl(1, "Lab", 5, 0, 16,
            3, itemsList);

    List<Room> roomsList = new ArrayList<>();
    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.move(room2);
  }

  /**
   * Testing if the player picks the item from the item list of the room in which the player is
   * present. The Item is valid. Returns true.
   */
  @Test
  public void testPickItemValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    boolean result = player.pickItem(item1);

    assertTrue(result);
  }

  /**
   * Testing if IllegalArgumentException is thrown for invalid item i.e. item non-existing in the
   * room.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPickItemNonExistingItemInRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.pickItem(item2);
  }

  /**
   * Testing when the item is null, IllegalArgumentException is thrown.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPickItemItemIsNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.pickItem(null);
  }

  /**
   * Testing when item bag limit is reached and player trying to add item. Returns false.
   */
  @Test
  public void testPickItemItemBagLimitReached() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 0,
            true);

    boolean result = player.pickItem(item1);

    assertFalse(result);
  }

  /**
   * Testing when the item bag limit has not reached and there is space to accommodate the item.
   * True is returned.
   */
  @Test
  public void testPickItemItemBagLimitNotReached() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    boolean result = player.pickItem(item1);

    assertTrue(result);
  }

  /**
   * Testing if getItemBagLimitt() returns the item bag limit for the player.
   */
  @Test
  public void testGetItemBagLimit() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    assertEquals(12, player.getItemBagLimit());
  }

  /**
   * Testing whether lookAround() gives back the correct list of neighbour rooms.
   */
  @Test
  public void testLookAround() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Room room2 = new RoomImpl(1, "Lab", 5, 0, 16,
            3, itemsList);

    List<Room> roomsList = new ArrayList<>();
    roomsList.add(room1);
    roomsList.add(room2);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);
    Player player1 = new PlayerImpl(2, "sid2", room1, 10, true);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: Helipad\n")
            .append("Current players in the room:\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. Lab\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n");

    assertEquals(stringBuilder.toString(), player.lookAround());
  }

  /**
   * Testing lookAround() when pet is in one of the neighbours.
   */
  @Test
  public void testLookAroundWhenPetInNeighbourRoom() {
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

    Player player = new PlayerImpl(1, "sid", room1, 12, true);
    Pet targetPet = new PetImpl("Yeti", room2, roomsList);
    room2.statusChangePetInRoom(true);
    StringBuilder stringBuilder = new StringBuilder("Current player room: Kitchen\n")
            .append("Current players in the room:\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. HallWay\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n");

    String result = player.lookAround();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing lookAround() when pet is in none of the neighbours rooms.
   */
  @Test
  public void testLookAroundWhenPetInNoNeighbourRooms() {
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

    Player player = new PlayerImpl(1, "sid", room1, 12, true);
    Pet targetPet = new PetImpl("Yeti", room2, roomsList);

    StringBuilder stringBuilder = new StringBuilder("Current player room: Kitchen\n")
            .append("Current players in the room:\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. ElevatorRoom\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("2. HallWay\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n");

    String result = player.lookAround();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing lookAround() when pet is in the same room.
   */
  @Test
  public void testLookAroundWhenPetInSameRoom() {
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

    Player player = new PlayerImpl(1, "sid", room1, 12, true);
    Pet targetPet = new PetImpl("Yeti", room2, roomsList);
    room1.statusChangePetInRoom(true);

    StringBuilder stringBuilder = new StringBuilder("Current player room: Kitchen\n")
            .append("Current players in the room:\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. ElevatorRoom\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("2. HallWay\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n");

    String result = player.lookAround();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing if getName() returns a valid and expected string.
   */
  @Test
  public void testGetName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    assertEquals("sid", player.getName());
  }

  /**
   * Testing if getNumber() returns a non negative integer.
   */
  @Test
  public void testGetNumber() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    assertEquals(1, player.getNumber());
  }

  /**
   * Testing whether getIsHuman() gives back whether the current player is human or computer player.
   */
  @Test
  public void testGetIsHuman() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    assertTrue(player.getIsHuman());
  }

  /**
   * Testing whether the function removes the item successfully when there is at least 1 item.
   */
  @Test
  public void testRemoveItemFromBagValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.pickItem(item1);

    boolean result = player.removeItemFromBag(item1);

    assertTrue(result);
  }

  /**
   * Testing when there is no such item in the bag and the player tries to remove it from the bag.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveItemFromBagNoSuchItemPresent() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.pickItem(item1);

    player.removeItemFromBag(item2);
  }

  /**
   * Testing removing item from bag when the item is null. IllegalArgumentException is thrown.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveItemFromBagItemNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    player.pickItem(item1);

    player.removeItemFromBag(null);
  }

  /**
   * Testing remove item from bag when the item list of the player is empty. False is returned.
   */
  @Test
  public void testRemoveItemFromBagWhenBagEmpty() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    boolean result = player.removeItemFromBag(item1);

    assertFalse(result);
  }

  /**
   * Testing toString() to return correct String representation of the Player object we create.
   */
  @Test
  public void testToString() {
    List<Item> itemsList = new ArrayList<>();

    Item item1 = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item1);

    Item item2 = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item2);

    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);

    Player player = new PlayerImpl(1, "sid", room1, 12,
            true);

    StringBuilder stringBuilder = new StringBuilder("");

    stringBuilder.append("Player name: sid\n")
            .append("Player current room: Helipad\n")
            .append("Player items: ");

    assertEquals(stringBuilder.toString(), player.toString());
  }
}
