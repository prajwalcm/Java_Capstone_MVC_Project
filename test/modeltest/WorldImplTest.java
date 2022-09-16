package modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemImpl;
import model.Player;
import model.PlayerImpl;
import model.Room;
import model.RoomImpl;
import model.World;
import model.WorldImpl;
import org.junit.Test;

/**
 * This class represents the test suite for the World class.
 */
public class WorldImplTest {
  private World world;

  /**
   * Tests if length of items array is non-negative.
   */
  @Test
  public void testLengthOfItemsList() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "YetiAlien", 100, 30);
  }

  /**
   * Tests object creation is success when number of rows > 0.
   */
  @Test
  public void testNumberOfRowsGreaterThanZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether IllegalArgumentException is thrown when row < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumberOfRowsLessThanZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(-1, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether IllegalArgumentException is thrown when row = 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumberOfRowsEqualToZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(0, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }


  /**
   * Tests object creation is success when number of columns > 0.
   */
  @Test
  public void testNumberOfColumnsGreaterThanZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether IllegalArgumentException is thrown when column < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumberOfColumnsLessThanZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, -1, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether IllegalArgumentException is thrown when column = 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumberOfColumnsEqualToZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(30, 0, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests if the length of rooms array is >= 1.
   */
  @Test
  public void testLengthOfRoomsList() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests if the number of rooms < 1 throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLengthOfRoomsIsZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests if target name == null throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfTargetNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            null, "yeti", 100, 30);
  }


  /**
   * Tests if target name != null.
   */
  @Test
  public void testIfTargetNameNotNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests if the target health >= 1, it creates the object successfully.
   */
  @Test
  public void testIfTargetHealthGreaterThanZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Testing construction when target health passed is 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionTargetHealthZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 0, 30);
  }

  /**
   * Testing construction when target health passed is negative.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionTargetHealthNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", -100, 30);
  }

  /**
   * Testing construction whether it throws IllegalArgumentException when petName is an empty
   * string.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionPetNameEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "", 100, 30);
  }

  /**
   * Testing construction whether it throws IllegalArgumentException when petName == null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructionPetNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", null, 100, 30);
  }

  /**
   * Testing construction when petName is valid.
   */
  @Test
  public void testConstructionPetNameValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Testing whether the computerPlayer moves as intended when the ‘pseudo random’ value
   * i.e. option is set.
   */
  @Test
  public void testPlayComputerPlayerMovesAsExpected() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("Sid", "LabWest", 12, true);
    world.addPlayerPiece("cpu", "LabWest", 10, false);

    String result = world.playerLookAround();
    result += world.playComputerPlayer(1, false);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. Sid\n")
            .append("2. cpu\n")
            .append("Items in the current room:\n")
            .append("1. Knife\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("\n")
            .append("Computer player's turn: Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. Sid\n")
            .append("2. cpu\n")
            .append("Items in the current room:\n")
            .append("1. Knife\n")
            .append("\n")
            .append("Spaces seen from the room: \n");

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether playComputerPlayer throws IllegalArgumentException when option < 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayComputerPlayerOptionNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("Sid", "LabWest", 12, true);
    world.addPlayerPiece("cpu", "LabWest", 10, false);

    String result = world.playerLookAround();
    result += world.playComputerPlayer(-1, false);
  }

  /**
   * Testing whether playComputerPlayer throws IllegalArgumentException when option > 2.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayComputerPlayerOptionGreaterThan2() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("Sid", "LabWest", 12, true);
    world.addPlayerPiece("cpu", "LabWest", 10, false);

    String result = world.playerLookAround();
    result += world.playComputerPlayer(3, false);
  }

  /**
   * Testing whether playComputerPlayer works as expected when option >=0 and option <=2.
   */
  @Test
  public void testPlayComputerPlayerOptionPositiveAndLessThanThree() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("Sid", "LabWest", 12, true);
    world.addPlayerPiece("cpu", "LabWest", 10, false);

    String result = world.playerLookAround();
    result += world.playComputerPlayer(1, false);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. Sid\n")
            .append("2. cpu\n")
            .append("Items in the current room:\n")
            .append("1. Knife\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("\n")
            .append("Computer player's turn: Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. Sid\n")
            .append("2. cpu\n")
            .append("Items in the current room:\n")
            .append("1. Knife\n")
            .append("\n")
            .append("Spaces seen from the room: \n");

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing when playComputerPlayer() throws IllegalStateException when numberOfTurns > maxTurns.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayComputerPlayerWhenNumberOfTurnsGreaterThanMaxTurns() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);

    world.addPlayerPiece("Sid", "LabWest", 12, true);
    world.addPlayerPiece("cpu", "LabWest", 10, false);

    world.playerLookAround();
    world.playComputerPlayer(1, false);
  }


  /**
   * Tests if the target health < 0, it throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfTargetHealthLessThanOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", -1, 30);
  }

  /**
   * Tests whether non overlapping rooms instantiate the world successfully.
   */
  @Test
  public void testNonOverlappingRooms() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether overlapping rooms throw IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testOverlappingRooms() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 1, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Checks whether the item is in an invalid room index and throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfItemInInvalidRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 10);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether object creation is success when item is in a valid room.
   */
  @Test
  public void testItemInaValidRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Checks whether room with a size greater world throws IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfRoomDimensionLessThanWorld() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 30,
            40, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether IllegalArgumentException is thrown when max turns < 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMaxTurnsLessThanOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 30,
            40, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 0);
  }

  /**
   * Tests whether object is instantiated when max turns > 1.
   */
  @Test
  public void maxTurnsGreaterThanOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
  }

  /**
   * Tests whether object is instantiated when max turns = 1.
   */
  @Test
  public void maxTurnsEqualToOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);
  }

  /**
   * Checks whether calling the toString() on World object produces appropriate output.
   */
  @Test
  public void testToString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Number of rows: 20\n")
            .append("Number of columns: 30\n")
            .append("World name: Area51\n")
            .append("Target name: alien\n")
            .append("Target in room: Helipad\n")
            .append("Target pet name: yeti\n")
            .append("Target pet current room: Helipad\n")
            .append("\n")
            .append("Number of spaces: 2\n");

    assertEquals(stringBuilder.toString(), world.toString());
  }

  /**
   * Tests whether a new valid player gets added to the end of player list of the world
   * successfully.
   */
  @Test
  public void testAddPlayerPieceAllValidParameters() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    Player newPlayer = new PlayerImpl(1, "Sid", room, 12,
            true);
    world.addPlayerPiece("Sid", "LabWest", 12, true);

    assertEquals(newPlayer.getName(), world.getPlayerList()
            .get(world.getPlayerList().size() - 1).getName());
  }

  /**
   * Tests addPlayerPiece whether IllegalArgumentException is thrown when player
   * name already exists.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPieceNameAlreadyExists() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("Sid", "LabWest", 12, true);

    world.addPlayerPiece("Sid", "Helipad", 16, true);
  }

  /**
   * Tests addPlayerPiece whether it throws IllegalArgumentException when player name ==
   * target name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPiecePlayerNameEqualsTargetName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("alien", "LabWest", 12, true);
  }

  /**
   * Testing addPlayerPiece when playerName is null, IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPiecePlayerNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece(null, "LabWest", 12, true);
  }

  /**
   * Testing addPlayerPiece  when playerName is empty string, IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPiecePlayerNameEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("", "LabWest", 12, true);
  }

  /**
   * Tests addPlayerPiece  whether IllegalArgumentException is thrown when room name does not exists
   * in the rooms list of the world.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPieceRoomNameDoesNotExistInRoomList() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Lab", 12, true);
  }

  /**
   * Testing addPlayerPiece successful player addition when room name is valid.
   */
  @Test
  public void testAddPlayerPieceRoomNameIsValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);
  }

  /**
   * Tests addPlayerPiece  whether IllegalArgumentException is thrown when room name is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPieceRoomNameIsNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", null, 12, true);
  }

  /**
   * Tests addPlayerPiece whether IllegalArgumentException is thrown by when room name is an
   * empty string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerPieceRoomNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "", 12, true);
  }

  /**
   * Testing movePlayerPiece whether movePlayerPiece() moves the player to the correct room.
   */
  @Test
  public void testMovePlayerPieceMovePlayerValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece("LabWest");

    assertEquals("LabWest", world.getPlayerList().get(0).getCurrentRoom().getName());
  }

  /**
   * Tests movePlayerPiece whether it throws IllegalArgumentException when invalid room name is
   * passed to move player.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerPieceMovePlayerInvalidRoomName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece("Lab");
  }

  /**
   * Tests movePlayerPiece whether it throws IllegalArgumentException when room name is null and is
   * passed to move player.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerPieceMovePlayerRoomNameIsNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece(null);
  }

  /**
   * Tests movePlayerPiece whether it throws IllegalArgumentException when room name is an empty
   * string and is passed to move player.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerPieceMovePlayerRoomNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece("");
  }

  /**
   * Testing when MaxTurns is reached already and movePlayerPiece is called as the next move.
   */
  @Test (expected = IllegalStateException.class)
  public void testMovePlayerPieceMaxTurnsAlreadyOver() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece("LabWest");

    world.movePlayerPiece("LabWest");
  }

  /**
   * Testing when a room passed is not a neighbour of the current room, IllegalArguemntException is
   * thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMovePlayerPieceRoomNotNeighbor() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 0, 9, 5,
            11, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.movePlayerPiece("LabWest");
  }

  /**
   * Testing target moves after movePlayerPiece().
   */
  @Test
  public void testTargetPieceMovesAfterMovingPlayerPiece() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    // Typecasting as this method is from a different interface than GameWorld.
    int beforeTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    world.movePlayerPiece("LabWest");

    // Typecasting as this method is from a different interface than GameWorld.
    int afterTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    assertEquals(afterTargetRoomIndex, (beforeTargetRoomIndex + 1) % (roomsList.size()));
  }

  /**
   * Tests whether the player add the item successfully when valid parameters are passed.
   */
  @Test
  public void testPlayerPickItemValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String result = world.playerPickItem("Laser Gun");

    assertEquals("Item Laser Gun was picked up successfully by sid.\n", result);
  }

  /**
   * Testing whether playerPickItem() throws IllegalArgumentException when the item name is wrong.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemItemNameWrong() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.playerPickItem("BlasterLaser");
  }

  /**
   * Testing whether playerPickItem() throws IllegalArgumentException when the item name is an
   * empty string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemItemNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.playerPickItem("");
  }

  /**
   * Testing whether playerPickItem() throws IllegalArgumentException when the item name is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemItemNameIsNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.playerPickItem(null);
  }

  /**
   * Testing when the player's itemBagLimit still has space to accommodate more items.
   */
  @Test
  public void testPlayerPickItemPlayerBagHasSpace() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String result = world.playerPickItem("Laser Gun");

    assertEquals("Item Laser Gun was picked up successfully by sid.\n", result);
  }

  /**
   * Testing when MaxTurns is reached already and player pick item is called as the next move.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayerPickItemMaxTurnsAlreadyOver() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.playerPickItem("Laser Gun");

    world.playerPickItem("Laser Gun");
  }

  /**
   * Testing when the player's itemBagLimit does not have space to accommodate more items.
   */
  @Test
  public void testPlayerPickItemNoSpaceInBag() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 0, true);

    String result = world.playerPickItem("Laser Gun");

    assertEquals("Picking up item by the player was not successful.\n", result);
  }

  /**
   * Testing when the item does not exist in the room.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayerPickItemItemDoesNotExistInRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 0, true);

    world.playerPickItem("Knife");
  }

  /**
   * Testing target moves after playerPickItem().
   */
  @Test
  public void testTargetMovesAfterPlayerPicksItem() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 0, true);

    // Typecasting as this method is from a different interface than GameWorld.
    int beforeTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    world.playerPickItem("Laser Gun");

    // Typecasting as this method is from a different interface than GameWorld.
    int afterTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    assertEquals(afterTargetRoomIndex, (beforeTargetRoomIndex + 1) % (roomsList.size()));
  }

  /**
   * Testing whether playerPlayerLookAround() gives a correct string of neighbour rooms that can be
   * seen from the current room the player is currently in.
   */
  @Test
  public void testPlayerLookAroundGivesValidResult() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 0, true);

    String result = world.playerLookAround();

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Target is present here.\n")
            .append("Current player room: Helipad\n")
            .append("Current players in the room:\n")
            .append("1. sid\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. LabWest\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("\n");

    assertEquals(stringBuilder.toString(), result);
  }



  /**
   * Testing whether it throws IllegalStateException when numberOfTurns >= maxTurns of the game.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationWhenTurnGreaterThanMaxTurn() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);

    world.addPlayerPiece("sid", "Helipad", 0, true);
    world.playerLookAround();
    world.playerLookAround();
  }

  /**
   * Testing if correct String value is returned from getTunInformation for a human player turn
   * after a human player turn.
   */
  @Test
    public void testGetTurnInformationHumanPlayerAfterHumanPlayer() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    world.addPlayerPiece("sid2", "LabWest", 12, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: Helipad\n")
            .append("Items in the current room: \n")
            .append("1. Laser Gun\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. LabWest\n")
            .append("Target is present here.\n")
            .append("Current player room: Helipad\n")
            .append("Current players in the room:\n")
            .append("1. sid\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. LabWest\n")
            .append("Players in the room: \n")
            .append("1. sid2\n")
            .append("2. sid2\n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("\n")
            .append("\n")
            .append("Current player: sid2\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid2\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n");
    String result = world.getTurnInformation();
    result += world.playerLookAround();
    result += world.getTurnInformation();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getTurnInformation displays correct target health value after target receives
   * an attack.
   */
  @Test
  public void testGetTurnInformationCorrectValueDisplayedAfterTargetAttacked() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    world.addPlayerPiece("sid2", "LabWest", 12, true);
    world.attack("poke");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("\n")
            .append("Current player: sid2\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 99\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid2\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n");
    String result = world.getTurnInformation();
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getTurnInformation does not displays the neighbour which have the pet in the
   * start of every turn.
   */
  @Test
  public void testGetTurnInformationNeighbourWithPetNotShown() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "WestCorridor", 10, true);
    world.addPlayerPiece("sid2", "Helipad", 12, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: WestCorridor\n")
            .append("Items in the current room: \n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: false\n")
            .append("Spaces visible from the current room: \n")
            .append("1. LabWest\n");
    String result = world.getTurnInformation();
    assertEquals(stringBuilder.toString(), result);
  }

  @Test
  public void testGetTurnInformationCorrectPetRoomAfterItIsMoved() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "WestCorridor", 10, true);
    world.addPlayerPiece("sid2", "Helipad", 12, true);
    StringBuilder stringBuilder = new StringBuilder("");
    String result = world.getTurnInformation();
    world.movePet("WestCorridor");
    result += world.getTurnInformation();
    stringBuilder.append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: WestCorridor\n")
            .append("Items in the current room: \n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: false\n")
            .append("Spaces visible from the current room: \n")
            .append("1. LabWest\n")
            .append("\n")
            .append("Current player: sid2\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: WestCorridor\n")
            .append("Current player room: Helipad\n")
            .append("Items in the current room: \n")
            .append("1. Laser Gun\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid2\n")
            .append("Pet is in the same space: false\n")
            .append("Spaces visible from the current room: \n")
            .append("1. LabWest\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getTurnInformation shows game ending when target health becomes <= 0 and shows
   *  the correct winner with human-human players. IllegalStateException is thrown since the game
   *  has ended.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationGameEndingWinnerHumanHumanPlayers() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    world.addPlayerPiece("sid2", "WestCorridor", 12, true);
    StringBuilder stringBuilder = new StringBuilder("");
    String result = world.getTurnInformation();
    world.attack("poke");
    world.getTurnInformation();
  }

  /**
   * Testing whether getTurnInformation shows game ending when target health becomes <= 0 and shows
   * the correct winner with human-computer players. IllegalStateException is thrown since the game
   * has ended.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationGameEndingWinnerHumanComputerPlayers() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    StringBuilder stringBuilder = new StringBuilder("");
    String result = world.getTurnInformation();
    world.attack("poke");
    world.getTurnInformation();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getTurnInformation does not display the item that was used by the player in
   * it’s item bag after that item was used for an attack by the player during the turn of the
   * player.
   */
  @Test
  public void testGetTurnInformationItemNotDisplayedAfterUsedInAttack() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 0);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    room1.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: Helipad\n")
            .append("Items in the current room: \n")
            .append("1. Laser Gun\n")
            .append("2. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 100\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: Helipad\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("1. name: Laser Gun, damage: 4\n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: Helipad\n")
            .append("Target's current health: 96\n")
            .append("Pet's current room: Helipad\n")
            .append("Current player room: Helipad\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n");
    String result = world.getTurnInformation();
    world.playerPickItem("Laser Gun");
    result += world.getTurnInformation();
    world.attack("Laser Gun");
    result += world.getTurnInformation();

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getTurnInformation shows game ending when Target health becomes 0 and attack
   * is called.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationTargetHealthZeroAndAttackCalled() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    world.attack("poke");
    world.getTurnInformation();
  }

  /**
   * Testing whether getTurnInformation shows game ending when Target health becomes 0 and movePet
   * is called.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationTargetHealthZeroAndMovePetCalled() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    world.attack("poke");
    world.movePet("WestCorridor");
    world.getTurnInformation();
  }

  /**
   * Testing whether getTurnInformation shows game ending when Target health becomes 0 and
   * playerLookAround is called.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationTargetHealthZeroAndPlayerLookAroundCalled() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    world.attack("poke");
    world.playerLookAround();
    world.getTurnInformation();
  }

  /**
   * Testing whether getTurnInformation shows game ending when Target health becomes 0 and
   * player move is called.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationTargetHealthZeroAndPlayerMoveCalled() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    world.attack("poke");
    world.movePlayerPiece("WestCorridor");
    world.getTurnInformation();
  }

  /**
   * Testing whether getTurnInformation shows game ending when Target health becomes 0 and
   * playerPickItem is called.
   */
  @Test (expected = IllegalStateException.class)
  public void testGetTurnInformationTargetHealthZeroAndPlayerPickItemCalled() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    world.attack("poke");
    world.playerPickItem("Laser Gun");
    world.getTurnInformation();
  }


  /**
   * Testing target moves after playerLookAround().
   */
  @Test
  public void testTargetMovesAfterPlayerLookAround() {
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
    room2.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);


    world.addPlayerPiece("sid", "Helipad", 0, true);

    // Typecasting as this method is from a different interface than GameWorld.
    int beforeTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    world.playerLookAround();

    // Typecasting as this method is from a different interface than GameWorld.
    int afterTargetRoomIndex = ((WorldImpl) world).getTargetPiece().getCurrentRoom().getRoom();

    assertEquals(afterTargetRoomIndex, (beforeTargetRoomIndex + 1) % (roomsList.size()));
  }

  /**
   * Testing whether PlayerLookAround() gives a correct string of neighbour rooms that can be seen
   * from the current room the player is currently in.
   */
  @Test
  public void testPlayerLookAroundGivesValidInformation() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "Helipad", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Target is present here.\n")
            .append("Current player room: Helipad\n")
            .append("Current players in the room:\n")
            .append("1. sid\n")
            .append("Items in the current room:\n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. LabWest\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("2. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("3. LabWest\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("4. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("\n");
    String result = world.playerLookAround();
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing playerLookAround() when the pet is in one of the neighbouring rooms.
   */
  @Test
  public void testPlayerLookAroundWhenPetInNeighbour() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "LabWest", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. sid\n")
            .append("Items in the current room:\n")
            .append("1. Knife\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("2. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("\n");
    String result = world.playerLookAround();
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing playerLookAround() when the pet is in none of the neighbouring rooms.
   */
  @Test
  public void testPlayerLookAroundWhenPetInNoneOfTheRooms() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room0 = new RoomImpl(0, "StartRoom", 0, 17, 10,
            20, itemsList);

    roomsList.add(room0);

    Room room1 = new RoomImpl(1, "Helipad", 0, 0, 4,
            3, itemsList);

    roomsList.add(room1);

    Room room2 = new RoomImpl(2, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(3, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room0.calculateNeighborsAndSave(roomsList);
    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "LabWest", 10, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Current player room: LabWest\n")
            .append("Current players in the room:\n")
            .append("1. sid\n")
            .append("Items in the current room:\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("2. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("3. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Knife\n")
            .append("4. WestCorridor\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("\n");
    String result = world.playerLookAround();
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing when MaxTurns is reached already and playLookAround is called as the next move.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayerLookAroundMaxTurnAlreadyOver() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 1);

    world.addPlayerPiece("sid", "Helipad", 0, true);
    world.playerLookAround();
    world.playerLookAround();
  }

  /**
   * Testing whether getPlayerDescription() returns correct description of player when correct name
   * parameter is sent.
   */
  @Test
  public void testGetPlayerDescriptionValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String pickResult = world.playerPickItem("Laser Gun");

    String result = world.getPlayerDescription("sid");

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player name: sid\n")
            .append("Player current room: Helipad\n")
            .append("Player items: Laser Gun \n");

    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing whether getPlayerDescription() throws IllegalArgumentException when non existing
   * player name is sent.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPlayerDescriptionNonExistingPlayerName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String pickResult = world.playerPickItem("Laser Gun");

    String result = world.getPlayerDescription("sidddy");
  }

  /**
   * Testing whether getPlayerDescription() throws IllegalArgumentException when null player name
   * is sent.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPlayerDescriptionNullPlayerName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String pickResult = world.playerPickItem("Laser Gun");

    String result = world.getPlayerDescription(null);
  }

  /**
   * Testing displayRoomInformation when room name == null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGetRoomInformationRoomNameNull() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.displayRoomInformation(null);
  }

  /**
   * Testing displayRoomInformation when room name is empty string.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGetRoomInformationRoomNameEmptyStringl() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.displayRoomInformation("");
  }

  /**
   * Testing displayRoomInformation when room name is valid and pet is present in the room.
   */
  @Test
  public void testGetRoomInformationRoomNameValidPetPresent() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String result = world.displayRoomInformation("Helipad");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" Helipad\n")
            .append("Items in room: [0 4 Laser Gun]\n")
            .append("Neighbor rooms: LabWest \n")
            .append("Pet present in the room: true\n")
            .append("Players in the room: \n")
            .append("sid\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing displayRoomInformation when room name is valid and pet is not present in the room.
   */
  @Test
  public void testGetRoomInformationRoomNameValidPetNotPresent() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "LabWest", 12, true);

    String result = world.displayRoomInformation("LabWest");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append(" LabWest\n")
            .append("Items in room: [1 4 Knife]\n")
            .append("Neighbor rooms: \n")
            .append("Pet present in the room: false\n")
            .append("Players in the room: \n")
            .append("sid\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing displayRoomInformation when  the room with that name is not present in the world.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testDisplayRoomInformationRoomNotPresentInWorld() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);
    world.displayRoomInformation("HallWay");
  }

  /**
   * Testing whether getPlayerDescription() throws IllegalArgumentException when empty string
   * player name is sent.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPlayerDescriptionEmptyStringPlayerName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    String pickResult = world.playerPickItem("Laser Gun");

    String result = world.getPlayerDescription("");
  }

  /**
   * Testing whether isCurrentTurnHuman() returns the correct value of true when the current turn
   * is of a human.
   */
  @Test
  public void testIsCurrentTurnHuman() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    room = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room);

    world = new WorldImpl(20, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 100, 30);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    world.addPlayerPiece("pcPlayer", "LabWest", 10,
            false);

    assertTrue(world.isCurrentTurnHuman());
  }

  /**
   * Testing if IllegalArgumentException is thrown when roomName is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMovePetRoomNameNull() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);
    world.movePet(null);
  }

  /**
   * Testing if IllegalArgumentException is thrown when roomName is an empty string.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMovePetRoomNameEmptyString() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);
    world.movePet("");
  }

  /**
   * Testing if IllegalArgumentException is thrown when roomName is such that it does not exists in
   * the world.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMovePetRoomNameNonExistingInWorld() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);
    world.movePet("Galaxy");
  }

  /**
   * Testing if target moves after movePet().
   */
  @Test
  public void testMovePetTargetMovesAfterMovePet() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 30);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    int targetPrevRoomIndex = world.getTargetPiece().getCurrentRoom().getRoom();
    world.movePet("WestCorridor");
    int targetCurrentRoomIndex = world.getTargetPiece().getCurrentRoom().getRoom();
    assertEquals(1, targetCurrentRoomIndex - targetPrevRoomIndex);
  }

  /**
   * Testing when MaxTurns has reached already and movePet() is called as the next move.
   */
  @Test (expected = IllegalStateException.class)
  public void testMovePetMaxTurnsReached() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 1);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.playerLookAround();
    world.movePet("WestCorridor");
  }

  /**
   * Testing whether turn count increases by one when movePet() is called.
   */
  @Test
  public void testMovePetTurnCountIncreasesByOne() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 1);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    int prevTurnCount = world.getNumberOfTurns();
    world.movePet("WestCorridor");
    int currTurnCount = world.getNumberOfTurns();

    assertEquals(1, currTurnCount - prevTurnCount);
  }

  /**
   * Testing if IllegalArgumentException is thrown when itemName is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerAttackItemNamNull() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 1);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.attack(null);
  }

  /**
   * Testing if IllegalArgumentException is thrown when itemName is an empty string.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerAttackItemNameEmptyString() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 1);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.attack("");
  }

  /**
   * Testing if an attack from the player reduces the target’s health if a poke attack is made.
   */
  @Test
  public void testPlayerAttackPokeValid() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 1, 1);

    world.addPlayerPiece("sid", "Helipad", 12, true);

    int prevHealth = world.getTargetPiece().getHealth();
    world.attack("poke");
    int currHealth = world.getTargetPiece().getHealth();

    assertEquals(1, prevHealth - currHealth);
  }

  /**
   * Testing attack fails when an attack is made but was seen by other players.
   */
  @Test
  public void testPlayerAttackFailedAttackPlayersSee() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.addPlayerPiece("sid2", "LabWest", 12, true);
    world.movePet("WestCorridor");
    String result = world.attack("poke");
    assertEquals("Other players saw you attack, attack unsuccessful.\n", result);
  }

  /**
   * Testing if an attack from the player using a specific item actually reduces the target’s
   * health by that amount.
   */
  @Test
  public void testPlayerAttackValidUsingItem() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.addPlayerPiece("sid2", "LabWest", 12, true);
    world.playerPickItem("Knife");
    world.movePet("WestCorridor");
    int prevTargetHealth = world.getTargetPiece().getHealth();
    world.attack("Knife");
    int currTargetHealth = world.getTargetPiece().getHealth();
    assertEquals(4, prevTargetHealth - currTargetHealth);
  }

  /**
   * Testing if an attack from the player using a specific item removes the item from the player'
   * item bag.
   */
  @Test
  public void testPlayerAttackItemRemovedAfterAttempt() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.addPlayerPiece("sid2", "LabWest", 12, true);
    world.playerPickItem("Knife");
    world.movePet("WestCorridor");
    String result = world.getPlayerDescription("sid");
    world.attack("Knife");
    result += world.getPlayerDescription("sid");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player name: sid\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: Knife \n")
            .append("Player name: sid\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: \n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing if an attack from the player using a specific itemName such that the item does not
   * exist in the player’s bag throws IllegalArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerAttackItemNotInBag() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room3 = new RoomImpl(1, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    Room room2 = new RoomImpl(2, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);


    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.playerPickItem("Knife");
    world.attack("Laser Gun");
  }

  /**
   * Testing if an attack from the player using a specific itemName such that the item does not
   * exist in the world throws IllegalArgumentException.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerAttackItemNotInWorld() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.attack("PlayDoughKnife");
  }

  /**
   * Testing if the game ends when an attack kills the target.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayerAttackGameEndsAfterTargetKilledByAttack() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.playerPickItem("Knife");
    world.playerLookAround();
    world.attack("Knife");
    world.getTurnInformation();
  }

  /**
   * Testing if the game ends after multiple attacks on the target and kills it.
   * IllegalStateException is thrown as game ended.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayerAttackMultipleAttacksKillTarget() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.addPlayerPiece("sid2", "WestCorridor", 10, true);

    world.attack("poke");
    world.playerPickItem("Knife");
    world.playerLookAround();
    world.movePet("Helipad");
    world.movePet("WestCorridor");
    world.attack("Knife");
    world.getTurnInformation();
  }

  /**
   * Testing for a successful attack when the pet is in the same room as the player and the target
   * as the pet makes the room invisible to the other players in neighbouring rooms.
   */
  @Test
  public void testPlayerAttackPetInSameRoomOtherPlayersInNeighbours() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.addPlayerPiece("sid2", "WestCorridor", 10, true);

    String result = world.attack("poke");
    StringBuilder expectedString = new StringBuilder("");
    expectedString.append("Poke attack was successful.\n")
            .append("\n")
            .append("Current target health: 3\n");
    assertEquals(expectedString.toString(), result);
  }

  /**
   * Testing for an unsuccessful attack when the pet is in the same room as the player and the
   * target but there is another player in the room.
   */
  @Test
  public void testPlayerAttackPetInSameRoomOtherPlayerInSameRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.addPlayerPiece("sid2", "Helipad", 10, true);

    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("");
    stringBuilder.append(world.getTurnInformation());
    String result = world.getTurnInformation();
    stringBuilder.append("Other players saw you attack, attack unsuccessful.\n");
    result += world.attack("poke");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing target moves to the next room after playerAttack().
   */
  @Test
  public void testPlayerAttackTargetMovesAfterPlayerAttack() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.addPlayerPiece("sid2", "WestCorridor", 10, true);

    int prevTargetRoomIndex = world.getTargetPiece().getCurrentRoom().getRoom();
    String result = world.attack("poke");
    int currTargetRoomIndex = world.getTargetPiece().getCurrentRoom().getRoom();
    assertEquals(1, currTargetRoomIndex - prevTargetRoomIndex);
  }

  /**
   * Testing when MaxTurns is reached already and playerAttack() is called as the next move.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayerAttackMaxTurnsReachedGameEnds() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 1);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    world.playerLookAround();
    world.attack("poke");
    world.getTurnInformation();
  }

  /**
   * Testing whether turn count increases by 1 when playerAttack() is called.
   */
  @Test
  public void testPlayerAttackTurnCountIncreasesByOne() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 12);

    world.addPlayerPiece("sid", "Helipad", 12, true);
    int prevTurnCount = world.getNumberOfTurns();
    world.attack("poke");
    int currTurnCount = world.getNumberOfTurns();
    assertEquals(1, currTurnCount - prevTurnCount);
  }

  /**
   * Testing if an attack fails when the target is not in the same room as the player.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testPlayerAttackFailsWhenTargetNotInSameRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4,
            29, 5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 12);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.attack("poke");
  }

  /**
   * Testing if item is removed from the world and subsequently player’s item bag after attack fails
   * i.e other players saw you attack.
   */
  @Test
  public void testPlayerAttackItemRemovedFromBagIfFailedAttempt() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 12, true);
    world.addPlayerPiece("sid2", "WestCorridor", 12, true);
    world.playerPickItem("Knife");
    world.movePet("WestCorridor");
    String result = world.getPlayerDescription("sid");
    result += world.attack("Knife");
    result += world.getPlayerDescription("sid");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Player name: sid\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: Knife \n")
            .append("Other players saw you attack, attack unsuccessful.\n")
            .append("Player name: sid\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: \n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing for the computer to use the most damaging item it has and attacking as a first move
   * when the target character is in the same space and they cant be seen by other players.
   * We first make the computer player pick an item and then let it play on its own.
   */
  @Test
  public void testPlayComputerPlayerUseMostDamagingItemForAttack() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(2, false); // cpu picks item
    result += world.getTurnInformation();
    world.movePet("WestCorridor");
    // cpu attacks on its own as its random flag is true.
    result += world.playComputerPlayer(2, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Item Knife was picked up successfully by computer player cpu\n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 10\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n")
            .append("2. WestCorridor\n")
            .append("Attack with Knife and damage 4 was successful.\n")
            .append("\n")
            .append("Current target health: 6\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing if poke attack is used if no item in the bag and the computer player cannot be seen by
   * any other player and target in the same room.
   */
  @Test
  public void testPlayComputerPlayerAttacksUsingPokeNoItemInBag() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(1, false);
    result += world.getTurnInformation();
    world.movePet("WestCorridor");
    result += world.playComputerPlayer(2, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Computer player's turn: Current player room: WestCorridor\n")
            .append("Current players in the room:\n")
            .append("1. cpu\n")
            .append("Items in the current room:\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("2. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 10\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n")
            .append("2. WestCorridor\n")
            .append("Poke attack was successful.\n")
            .append("\n")
            .append("Current target health: 9\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing if first move is always attack if target in the same room and no other players can see
   * the computer player.
   */
  @Test
  public void testPlayComputerPlayerFirstMoveAttackIfPossibleValid() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(1, false);
    result += world.getTurnInformation();
    world.playerLookAround();
    result += world.playComputerPlayer(2, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Computer player's turn: Current player room: WestCorridor\n")
            .append("Current players in the room:\n")
            .append("1. cpu\n")
            .append("Items in the current room:\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("2. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 10\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n")
            .append("2. WestCorridor\n")
            .append("Poke attack was successful.\n")
            .append("\n")
            .append("Current target health: 9\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing if attack is always made when the pet and the target are in the same room as the
   * computer player.
   */
  @Test
  public void testPlayComputerPlayerAttackAlwaysIfPetAndTargetSameRoom() {
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

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(1, false);
    result += world.getTurnInformation();
    world.playerLookAround();
    result += world.playComputerPlayer(2, true);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Computer player's turn: Current player room: WestCorridor\n")
            .append("Current players in the room:\n")
            .append("1. cpu\n")
            .append("Items in the current room:\n")
            .append("\n")
            .append("Spaces seen from the room: \n")
            .append("1. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("2. Helipad\n")
            .append("Players in the room: \n")
            .append("Items in the room: \n")
            .append("1. Laser Gun\n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 10\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("1. Knife\n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n")
            .append("2. WestCorridor\n")
            .append("Poke attack was successful.\n")
            .append("\n")
            .append("Current target health: 9\n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Testing for game ending when target health becomes 0 because of the computer player attack.
   * IllegalStateException is thrown when game ends and next turn information is about to be
   * displayed.
   */
  @Test (expected = IllegalStateException.class)
  public void testPlayComputerPlayerGameEndingWhenTargetKilled() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 4, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(2, false); // cpu picks item
    result += world.getTurnInformation();
    world.movePet("WestCorridor");
    // cpu attacks on its own as its random flag is true.
    result += world.playComputerPlayer(2, true);
    world.getTurnInformation();
  }

  /**
   * Testing if item is removed from the world after it was used for an attempt by the computer
   * player’s attack.
   */
  @Test
  public void testPlayComputerPlayerIfItemRemovedFromBagAfterAttack() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.playComputerPlayer(2, false); // cpu picks item
    result += world.getTurnInformation();
    world.movePet("WestCorridor");
    // cpu attacks on its own as its random flag is true.
    result += world.getPlayerDescription("cpu");
    result += world.playComputerPlayer(2, true);
    result += world.getPlayerDescription("cpu");
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Item Knife was picked up successfully by computer player cpu\n")
            .append("\n")
            .append("Current player: sid\n")
            .append("Target's current room: LabWest\n")
            .append("Target's current health: 10\n")
            .append("Pet's current room: LabWest\n")
            .append("Current player room: LabWest\n")
            .append("Items in the current room: \n")
            .append("Current player's item bag: \n")
            .append("Players in the current room: \n")
            .append("1. sid\n")
            .append("Pet is in the same space: true\n")
            .append("Spaces visible from the current room: \n")
            .append("1. Helipad\n")
            .append("2. WestCorridor\n")
            .append("Player name: cpu\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: Knife \n")
            .append("Attack with Knife and damage 4 was successful.\n")
            .append("\n")
            .append("Current target health: 6\n")
            .append("Player name: cpu\n")
            .append("Player current room: WestCorridor\n")
            .append("Player items: \n");
    assertEquals(stringBuilder.toString(), result);
  }

  /**
   * Tests whether the function call is successful when scaleUpRow and scaleUpCol are positive.
   */
  @Test
  public void testGenerateBaseImageAllValid() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(10, 10);
  }

  /**
   * Tests whether it throws IllegalArgumentException when scaleUpRow is negative.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpRowNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(-10, 10);
  }

  /**
   * Tests whether it throws IllegalArgumentException when scaleUpRow is 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpRowZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(0, 10);
  }


  /**
   * Tests whether it throws IllegalArgumentException when scaleUpCol is negative.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpColNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(10, -10);
  }

  /**
   * Tests whether it throws IllegalArgumentException when scaleUpCol is 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpColZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(10, 0);
  }


  /**
   * Tests whether it throws IllegalArgumentException when both scaleUpRow and scaleUpCol are
   * negative.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpRowScaleUpColNegative() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(-10, -10);
  }

  /**
   * Tests whether it throws IllegalArgumentException when both scaleUpRow and scaleUpCol are 0.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGenerateBaseImageScaleUpRowScaleUpColZero() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(0, 0);
  }

  /**
   * Tests whether getBaseImage is returns a BufferedImage when called.
   */
  @Test
  public void testGetBaseImage() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.generateBaseImage(10, 10);

    BufferedImage bufferedImage = world.getBaseImage();
  }

  /**
   * Tests whether getRoomNames returns a complete set of room names in the world.
   */
  @Test
  public void testGetRoomNames() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    List<String> roomNames = world.getRoomNames();
    StringBuilder expected = new StringBuilder("");
    expected.append("Helipad LabWest WestCorridor ");
    StringBuilder actual = new StringBuilder("");
    for (String roomName : roomNames) {
      actual.append(roomName).append(" ");
    }

    assertEquals(expected.toString(), actual.toString());
  }

  /**
   * Tests whether getItemNames returns a complete set of item names in the current player's bag.
   */
  @Test
  public void testGetItemNamesInBag() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 10, true);
    world.playerPickItem("Knife");

    StringBuilder actual = new StringBuilder("");
    for (String itemName : world.getItemNamesInBag()) {
      actual.append(itemName).append(" ");
    }

    assertEquals("poke Knife ", actual.toString());
  }

  /**
   * Tests whether the function returns the list of names of items in the current player's room.
   */
  @Test
  public void testGetItemsInRoom() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("sid", "WestCorridor", 10, true);

    StringBuilder actual = new StringBuilder("");
    for (String itemName : world.getItemNamesInRoom()) {
      actual.append(itemName).append(" ");
    }
    assertEquals("Knife ", actual.toString());
  }

  /**
   * Tests whether the function returns the correct room name of the current player.
   */
  @Test
  public void testGetCurrentPlayerRoomName() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    world.addPlayerPiece("cpu", "WestCorridor", 12, false);
    world.addPlayerPiece("sid", "LabWest", 10, true);
    String result = world.getCurrentPlayerRoomName();

    assertEquals("WestCorridor", result);
  }

  /**
   * Tests whether correct room name is returned given the coordinates.
   */
  @Test
  public void testGetRoomNameFromCoordinates() {
    List<Item> itemsList = new ArrayList<>();

    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 2);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "LabWest", 5, 0, 16,
            3, itemsList);

    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "WestCorridor", 0, 4, 29,
            5, itemsList);

    roomsList.add(room3);

    room1.calculateNeighborsAndSave(roomsList);
    room2.calculateNeighborsAndSave(roomsList);
    room3.calculateNeighborsAndSave(roomsList);

    world = new WorldImpl(30, 30, "Area51", roomsList, itemsList,
            "alien", "yeti", 10, 10);

    int scaleUpRow = 10;
    int scaleUpCol = 10;

    world.generateBaseImage(scaleUpRow, scaleUpCol);

    world.generateOverlayPieceCoordinates();
    int scaledX = 1 * scaleUpRow;
    int scaledY = 2 * scaleUpCol;

    String roomName = world.getRoomNameFromCoordinates(scaledX, scaledY);

    assertEquals("Helipad", roomName);
  }
}