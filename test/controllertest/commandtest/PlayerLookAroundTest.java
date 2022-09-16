package controllertest.commandtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import controller.command.Command;
import controller.command.PlayerLookAround;
import controllertest.MockModel;
import controllertest.ValidMockView;
import model.World;
import org.junit.Test;
import view.View;

/**
 * Represents testing suite for the PlayerLookAround command of our world game by using mock
 * objects.
 */
public class PlayerLookAroundTest {
  /**
   * Tests valid construction when view is not null.
   */
  @Test
  public void testConstructorViewNotNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerLookAround = new PlayerLookAround(mockView);
  }

  /**
   * Tests whether it throws IllegalArgumentException when view is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorViewNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerLookAround = new PlayerLookAround(null);
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

    Command playerLookAround = new PlayerLookAround(mockView);
    playerLookAround.execute(mockModel);

    assertTrue(appendable.toString().contains("abcdef123456"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Player Looking around called: Room1, Room2\n")
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

    Command playerLookAround = new PlayerLookAround(mockView);

    String result = playerLookAround.execute(null);
  }

  /**
   * This tests whether execute works as expected when a valid mock view is used.
   */
  @Test
  public void testExecuteViewValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command playerLookAround = new PlayerLookAround(mockView);

    playerLookAround.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));

    StringBuilder expected = new StringBuilder("");
    expected.append("Player Looking around called: Room1, Room2\n").append("abcdef123456");

    assertEquals(expected.toString(), appendable.toString());
  }

}
