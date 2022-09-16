package modeltest;

import static org.junit.Assert.assertEquals;

import model.Item;
import model.ItemImpl;
import org.junit.Test;

/**
 * This class represents the test suite for the ItemImpl class.
 */
public class ItemImplTest {

  /**
   * Checks and create Item object if id >= 0.
   */
  @Test
  public void testNonNegativeId() {
    Item item = new ItemImpl(0, "Laser Gun", 4,
            0);
  }

  /**
   * Checks for IllegalArgumentException if id < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeId() {
    Item item = new ItemImpl(-1, "Laser Gun", 4,
            0);
  }

  /**
   * Checks for IllegalArgumentException if name == null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNameNull() {
    Item item = new ItemImpl(0, null, 4,
            0);
  }

  /**
   * Checks and instantiates Item object if name != null.
   */
  @Test
  public void testNameNotNull() {
    Item item = new ItemImpl(0, "Laser Gun",
            4, 0);
  }

  /**
   * Checks for IllegalArgumentException if name is an empty string.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testNameEmptyString() {
    Item item = new ItemImpl(0, "", 4,
            0);
  }

  /**
   * Checks and instantiates Item object when damage > 0.
   */
  @Test
  public void testDamageIsPositive() {
    Item item = new ItemImpl(0, "Laser Gun",
            4, 0);
  }

  /**
   * Checks for IllegalArgumentException if damage <= 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDamageLessThanEqualToZero() {
    Item item = new ItemImpl(0, "Laser Gun",
            -1, 0);
  }

  /**
   * Checks and instantiates Item object when containing room index >= 0.
   */
  @Test
  public void testContainingRoomIndexNonNegative() {
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
  }

  /**
   * Checks for IllegalArgumentException when containing room index < 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testContainingRoomIndexNegative() {
    Item item = new ItemImpl(0, "Laser Gun", 4, -10);
  }

  /**
   * Checks if getContainingRoomIndex() works as expected.
   */
  @Test
  public void testGetContainingRoomIndex() {
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    assertEquals(0, item.getContainingRoomIndex());
  }

  /**
   * Checks if getName() works as expected.
   */
  @Test
  public void testGetName() {
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    assertEquals("Laser Gun", item.getName());
  }

  /**
   * Checks if getDamage() works as expected.
   */
  @Test
  public void testGetDamage() {
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    assertEquals(4, item.getDamage());
  }

  /**
   * Checks if toString() works as expected.
   */
  @Test
  public void testToString() {
    Item item = new ItemImpl(0, "Laser Gun", 4, 0);
    assertEquals("0 4 Laser Gun", item.toString());
  }

}

