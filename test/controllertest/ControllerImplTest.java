package controllertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import controller.Controller;
import controller.ControllerImpl;
import model.World;
import org.junit.Test;
import view.View;

/**
 * Represents testing suite for the controller of our world game by using mock objects.
 */
public class ControllerImplTest {

  /**
   * Tests whether the constructor throws IllegalArgumentException when world is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorWorldIsNull() {
    Controller testController =
            new ControllerImpl(null);
  }

  /**
   * Tests for successful construction when world is not null and all valid.
   */
  @Test
  public void testConstructorWorldIsNotNullAllValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    Controller testController = new ControllerImpl(mockModel);
  }

  /**
   * Tests whether the method testStart returns the correct string value when called.
   */
  @Test
  public void testStart() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);

    String result = testController.start();

    assertEquals("Controller initialized and started.", result);
  }

  /**
   * Tests whether setView will throw IllegalArgumentException when the view passed is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSetViewViewNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    Controller testController = new ControllerImpl(mockModel);

    testController.setView(null);
  }

  /**
   * Tests whether setView method works as expected and initializes the controller as well as asks
   * the view to set its features as this controller.
   */
  @Test
  public void testSetViewViewNotNullAllValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456");
    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether exit game works as desired where the controller tells the view to run game over.
   */
  @Test
  public void testExitGame() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.exitGame();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456Notify ")
            .append("view game over called123456abcdef");
    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * This tests whether the notify screen change works as expected where the controller tells the
   * view to switch frames.
   */
  @Test
  public void testNotifyScreenChange() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyScreenChange();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456")
            .append("Switch frames called123456abcdef");
    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify add player piece works correctly where controller tells view to collect
   * player details and then asks model to add the player.
   */
  @Test
  public void testNotifyAddPlayerPieceValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyAddPlayerPiece();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456Extract and save player details called")
            .append("123456abcdefGet player details called123456abcdefAddPLayerPiece called: ")
            .append("Input: Player name Player room 12 trueabcdef123456Generate overlay piece ")
            .append("coordinates calledabcdef123456");
    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify add player piece works as expected when add player piece is called and
   * view returns invalid details to the controller which get passed to the mock model eventually.
   */
  @Test
  public void testNotifyAddPlayerPieceInValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new InvalidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    String result = testController.notifyAddPlayerPiece();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertEquals("Invalid room name passed.", result);
  }

  /**
   * Tests whether notify pick item works correctly where controller tells view to show item
   * chooser, get the item name selected and then asks model to tell player to pick item.
   */
  @Test
  public void testNotifyPickItemValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyPickItem();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456Get item names in room called")
            .append("abcdef123456Show item chooser called.123456abcdefPlayerPickItem ")
            .append("called Input: LaserGunabcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify pick item works as expected where controller tells invalid view to show
   * item chooser, get the invalid item name selected and then asks model to tell player to pick
   * item.
   */
  @Test
  public void testNotifyPickItemInvalid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new InvalidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    String result = testController.notifyPickItem();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));

    assertEquals("No items in the room.", result);
  }

  /**
   * This tests whether notify player look around works as expected in the flow.
   */
  @Test
  public void testNotifyPlayerLookAround() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyPlayerLookAround();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456")
            .append("Player Looking around called: Room1, Room2\nabcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify player attack works in a valid way where in the controller asks the view
   * to get the item name from show item chooser and call the attack method in the model in the
   * flow.
   */
  @Test
  public void testNotifyPlayerAttackValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyPlayerAttack();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456Get item names in bag ")
            .append("calledabcdef123456")
            .append("Show attack item chooser called.123456abcdef")
            .append("Attack called Input: LaserGunabcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify player attack works as expected when an invalid item name from the
   * invalid mock view is sent to the controller and eventually the attack is called on the mock
   * model in the flow.
   */
  @Test
  public void testPlayerAttackInValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new InvalidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    String result = testController.notifyPlayerAttack();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));

    assertEquals("Invalid item name passed.", result);
  }

  /**
   * Tests whether notify move pet works in a valid way where in the controller asks the view
   * to get the room name from show room chooser and call the move pet method in the model in the
   * flow.
   */
  @Test
  public void testNotifyMovePetValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    testController.notifyMovePet();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Set features called123456abcdefGet game play panel size called.123456abcdef")
            .append("Generate base image calledabcdef123456Show room chooser called.123456abcdef")
            .append("MovePet called Input: Helipadabcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether notify move pet works as expected when an invalid room name from the invalid mock
   * view is sent to the controller and eventually move pet is called on the mock model in the
   * flow.
   */
  @Test
  public void testNotifyMovePetInvalid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new InvalidMockView(appendable, "123456abcdef");
    Controller testController = new ControllerImpl(mockModel);
    testController.setView(mockView);
    String result = testController.notifyMovePet();
    assertTrue(appendable.toString().contains("123456abcdef"));
    assertTrue(appendable.toString().contains("abcdef123456"));

    assertEquals("Invalid room name passed.", result);
  }

}
