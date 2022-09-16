package controllertest.commandtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import controller.command.Command;
import controller.command.PlayerMove;
import controllertest.InvalidMockView;
import controllertest.MockModel;
import controllertest.ValidMockView;
import model.World;
import org.junit.Test;
import view.View;

/**
 * Represents testing suite for the PlayerMove command of our world game by using mock objects.
 */
public class PlayerMoveTest {
  /**
   * Tests valid construction when view is not null.
   */
  @Test
  public void testConstructorViewNotNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(mockView);
  }

  /**
   * Tests whether it throws IllegalArgumentException when view is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorViewNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(null);
  }

  /**
   * This tests whether execute works as expected when everything is valid i.e when non-null mock
   * model is used and a valid mock view is used.
   */
  @Test
  public void testExecuteModelNotNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(mockView);
    playerMove.execute(mockModel);

    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Get room name clicked called123456abcdefMovePlayerPiece called Input: Helipad")
            .append("abcdef123456");
    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * Tests whether IllegalArgumentException is thrown when a null model is passed to execute method.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testExecuteModelNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(mockView);

    String result = playerMove.execute(null);
  }

  /**
   * This tests whether execute works as expected when a valid mock view is used.
   */
  @Test
  public void testExecuteViewValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(mockView);

    playerMove.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));

    StringBuilder expected = new StringBuilder("");
    expected.append("Get room name clicked called123456abcdefMovePlayerPiece called Input: Helipad")
            .append("abcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

  /**
   * This tests whether execute works as expected when an invalid mock view is used.
   */
  @Test
  public void testExecuteViewInValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new InvalidMockView(appendable, "123456abcdef");

    Command playerMove = new PlayerMove(mockView);

    String result = playerMove.execute(mockModel);
    assertTrue(appendable.toString().contains("123456abcdef"));

    assertEquals("Invalid room name passed.", result);
  }
}
