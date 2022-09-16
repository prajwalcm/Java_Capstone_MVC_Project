package model;

/**
 * This represents the state of an item in the world that can be used by a player to attack the
 * target.
 */
public interface Item {
  /**
   * Gives back the index of the room that contains this item.
   *
   * @return the index of the room that contains this item.
   */
  public int getContainingRoomIndex();

  /**
   * Gives back the name of the item.
   *
   * @return the name of the item.
   */
  public String getName();

  /**
   *  Gives back the id of the item.
   *
   * @return the id of the item.
   */
  public int getId();

  /**
   * Gives back the damage value that the item can inflict.
   *
   * @return the damage value that the item can inflict.
   */
  public int getDamage();
}
