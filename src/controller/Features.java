package controller;

/**
 * This interface represents set of functions that will be exposed to the View to make calls to the
 * controller.
 */
public interface Features {
  /**
   * Method to exit the game after cleaning up all resources.
   */
  public void exitGame();

  /**
   * This method is used when view wants to communicate to controller that user requested for next
   * frame.
   */
  public void notifyScreenChange();

  /**
   * This method is used when view wants to communicate to controller that user requested for a
   * custom world input specification file to be input into the game for the model to be built.
   */
  public void notifyCustomWorldFile();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * the functionality of add player piece.
   *
   * @return String representing a value to let the view know what is the result.
   */
  public String notifyAddPlayerPiece();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * the functionality of picking an item.
   *
   * @return String representing a value to let the view know what is the result.
   */
  public String notifyPickItem();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * the functionality of player attempting an attack.
   *
   * @return String representing a value to let the view know what is the result.
   */
  public String notifyPlayerAttack();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * the functionality of moving the pet.
   *
   * @return String representing a value to let the view know what is the result.
   */
  public String notifyMovePet();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * the functionality of player looking around.
   *
   * @return String representing a value to let the view know what is the result.
   */
  public String notifyPlayerLookAround();

  /**
   * This enables the view to communicate to the controller that user event triggered is for
   * a click event which can be a get player description or a player move.
   *
   * @param x x coordinate of the click.
   * @param y y coordinate of the click.
   * @return String representing a value to let the view know what is the result.
   * @throws IllegalArgumentException when either x or y is negative.
   */
  public String notifyClick(int x, int y);

}
