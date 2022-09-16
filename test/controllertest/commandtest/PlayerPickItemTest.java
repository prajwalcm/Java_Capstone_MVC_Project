package controllertest.commandtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import controller.command.Command;
import controller.command.PlayerPickItem;
import controllertest.InvalidMockView;
import controllertest.MockModel;
import controllertest.ValidMockView;
import model.World;
import org.junit.Test;
import view.View;

/**
 * Represents testing suite for the PlayerPickItem command of our world game by using mock objects.
 */
public class PlayerPickItemTest {

  /**
   * Tests valid construction when view is not null.
   */
  @Test
  public void testConstructorViewNotNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerPickItem = new PlayerPickItem(mockView);
  }

  /**
   * Tests whether it throws IllegalArgumentException when view is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorViewNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerPickItem = new PlayerPickItem(null);
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

    Command playerPickItem = new PlayerPickItem(mockView);
    playerPickItem.execute(mockModel);

    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Show item chooser called.123456abcdefPlayerPickItem called Input: LaserGun")
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

    Command playerPickItem = new PlayerPickItem(mockView);

    String result = playerPickItem.execute(null);
  }

  /**
   * This tests whether execute works as expected when a valid mock view is used.
   */
  @Test
  public void testExecuteViewValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerPickItem = new PlayerPickItem(mockView);

    playerPickItem.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));

    StringBuilder expected = new StringBuilder("");
    expected.append("Show item chooser called.123456abcdefPlayerPickItem called Input: LaserGun")
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

    Command playerPickItem = new PlayerPickItem(mockView);

    String result = playerPickItem.execute(mockModel);
    assertTrue(appendable.toString().contains("123456abcdef"));

    assertEquals("No items in the room.", result);
  }
}
