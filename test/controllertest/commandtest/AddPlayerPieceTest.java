package controllertest.commandtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import controller.command.AddPlayerPiece;
import controller.command.Command;
import controllertest.InvalidMockView;
import controllertest.MockModel;
import controllertest.ValidMockView;
import model.World;
import org.junit.Test;
import view.View;


/**
 * Represents testing suite for the AddPlayerPiece command of our world game by using mock objects.
 */
public class AddPlayerPieceTest {

  /**
   * Tests valid construction when view is not null.
   */
  @Test
  public void testConstructorViewNotNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command addPlayerPiece = new AddPlayerPiece(mockView);
  }

  /**
   * Tests whether it throws IllegalArgumentException when view is null.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructorViewNull() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command addPlayerPiece = new AddPlayerPiece(null);
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

    Command addPlayerPiece = new AddPlayerPiece(mockView);

    addPlayerPiece.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));
    StringBuilder expected = new StringBuilder("");
    expected.append("Extract and save player details called123456abcdefGet player details called")
            .append("123456abcdef")
            .append("AddPLayerPiece called: Input: Player name Player room 12 true")
            .append("abcdef123456Generate ")
            .append("overlay piece coordinates calledabcdef123456");
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

    Command addPlayerPiece = new AddPlayerPiece(mockView);

    String result = addPlayerPiece.execute(null);
  }

  /**
   * This tests whether execute works as expected when a valid mock view is used.
   */
  @Test
  public void testExecuteViewValid() {
    StringBuilder appendable = new StringBuilder();
    World mockModel = new MockModel(appendable, "abcdef123456");
    View mockView = new ValidMockView(appendable, "123456abcdef");

    Command addPlayerPiece = new AddPlayerPiece(mockView);

    addPlayerPiece.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));

    StringBuilder expected = new StringBuilder("");
    expected.append("Extract and save player details called123456abcdefGet player details called")
            .append("123456abcdef")
            .append("AddPLayerPiece called: Input: Player name Player room 12 true")
            .append("abcdef123456Generate ")
            .append("overlay piece coordinates calledabcdef123456");

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

    Command addPlayerPiece = new AddPlayerPiece(mockView);

    String result = addPlayerPiece.execute(mockModel);
    assertTrue(appendable.toString().contains("abcdef123456"));
    assertTrue(appendable.toString().contains("123456abcdef"));

    assertEquals("Invalid room name passed.", result);
  }
}
