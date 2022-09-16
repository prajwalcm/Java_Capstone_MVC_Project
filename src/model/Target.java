package model;

/**
 * Represents a set of functionalities for the target component of the game.
 */
public interface Target {
  /**
   * Gives back the copy of Room object where the player piece is currently in.
   *
   * @return the copy of current room where the player is.
   */
  public Room getCurrentRoom();

  /**
   * Gives the name of the piece.
   *
   * @return Returns the name of the piece.
   */
  public String getName();

  /**
   * Gives back the health value of the target piece.
   *
   * @return the health of the target piece.
   */
  public int getHealth();

  /**
   *  Gives the number/id of the piece.
   *
   * @return Returns the number/id of the piece.
   */
  public int getNumber();

  /**
   * Moves the character in the board 1 step at a time based on the list passed in as room list.
   */
  public void move();

  /**
   * Receive attack form other players and decrease health by the damage value of the attack.
   *
   * @throws IllegalArgumentException when damage < 0 as negative attack is not possible.
   */
  public void receiveAttack(int damage);

}
