package modeltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemImpl;
import model.Room;
import model.RoomImpl;
import model.Target;
import model.TargetImpl;
import org.junit.Test;

/**
 * This class represents the test suite for the Target class.
 */
public class TargetImplTest {

  /**
   * Checks and instantiates Target object when number >= 0.
   */
  @Test
  public void testNumberIsNonNegative() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
  }

  /**
   * Checks for throws IllegalArgumentException if number < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNumberIsNegative() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(-1, "Alien", 100, roomsList);
  }

  /**
   * Checks for throws IllegalArgumentException when name is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfNameIsNull() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, null, 100, roomsList);
  }

  /**
   * Checks for throws IllegalArgumentException when name is an empty string.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfNameIsEmptyString() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "", 100, roomsList);
  }

  /**
   * Checks and instantiates the Target object when name != null.
   */
  @Test
  public void testIfNameNotNull() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
  }

  /**
   * Checks and instantiates the Target object when roomList != null.
   */
  @Test
  public void testRoomListNotNull() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
  }

  /**
   * Checks for IllegalArgumentException when target health < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testHealthNegative() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", -1, roomsList);
  }

  /**
   * Checks and instantiates Target object when health >= 0.
   */
  @Test
  public void testHealthNonNegative() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
  }

  /**
   * Checks whether the starting point of the target is at 0th indexed room.
   */
  @Test
  public void testStartRoomIndexZero() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);

    assertEquals(0, target.getCurrentRoom().getRoom());
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

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "alien", 100, roomsList);
    assertEquals("alien", target.getName());
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

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "alien", 100, roomsList);
    assertEquals(0, target.getNumber());
  }


  /**
   * tests whether getHealth() of Target object return current value.
   */
  @Test
  public void testGetHealth() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);

    assertEquals(100, target.getHealth());
  }

  /**
   * Checks whether currentRoom() is working as expected.
   */
  @Test
  public void testGetCurrentRoom() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);

    assertEquals(roomsList.get(0), target.getCurrentRoom());
  }

  /**
   * Checks whether move() of Target object is moving as expected i.e 1 index at a time.
   */
  @Test
  public void testMove() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room1 = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room1);

    Room room2 = new RoomImpl(1, "Lab", 0, 0, 4,
            3, itemsList);
    roomsList.add(room2);

    Room room3 = new RoomImpl(2, "AlienRoom", 0, 0, 4,
            3, itemsList);
    roomsList.add(room3);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    target.move();

    assertEquals(room2, target.getCurrentRoom());
  }

  /**
   * Test if toString() of Target object works as expected.
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

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Target name: Alien\n")
            .append("Target health: 100\n")
            .append("Target current room name: Helipad\n")
            .append("Target current room number/index: 0\n");

    assertEquals(stringBuilder.toString(), target.toString());
  }

  /**
   * Testing if the string representation of the target represents the correct value of health
   * after an attack is received.
   */
  @Test
  public void testToStringAfterReceiveAttack() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    target.receiveAttack(1);
    StringBuilder stringBuilder = new StringBuilder("");
    stringBuilder.append("Target name: Alien\n")
            .append("Target health: 99\n")
            .append("Target current room name: Helipad\n")
            .append("Target current room number/index: 0\n");

    assertEquals(stringBuilder.toString(), target.toString());
  }

  /**
   * Testing if the health of the Target object decreases when received an attack.
   */
  @Test
  public void testReceiveAttackIfWorksAsExpected() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    int healthBefore = target.getHealth();
    target.receiveAttack(1);
    int healthAfter = target.getHealth();
    assertEquals(1, healthBefore - healthAfter);
  }

  /**
   * Testing if IllegalArgumentException is thrown if damage trying to be made is negative.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testReceiveAttackDamageNegative() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    int healthBefore = target.getHealth();
    target.receiveAttack(-1);
  }

  /**
   * Testing if IllegalArgumentException is thrown if damage trying to be made is zero.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testReceiveAttackDamageZero() {
    List<Item> itemsList = new ArrayList<>();
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    itemsList.add(item);

    item = new ItemImpl(1, "Knife", 4, 1);
    itemsList.add(item);

    List<Room> roomsList = new ArrayList<>();
    Room room = new RoomImpl(0, "Helipad", 0, 0, 4,
            3, itemsList);
    roomsList.add(room);

    Target target = new TargetImpl(0, "Alien", 100, roomsList);
    int healthBefore = target.getHealth();
    target.receiveAttack(0);
  }
}
