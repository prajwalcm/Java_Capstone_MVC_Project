package model;

import java.util.List;

/**
 * Represent set of functionalities that are expected of all kinds of players playing this game.
 */
public interface Player {
  /**
   * Gives back the current room the player is in.
   *
   * @return Returns the current room of the player.
   */
  public Room getCurrentRoom();

  /**
   * Gives the name of the player..
   *
   * @return Returns the name of the player.
   */
  public String getName();

  /**
   * Gives the number/id of the player.
   *
   * @return Returns the number/id of the player.
   */
  public int getNumber();

  /**
   * Gives back whether the player is human player or not.
   *
   * @return back the player is human player or not.
   */
  public boolean getIsHuman();

  /**
   * Gives the copy of the item list the player is holding.
   *
   * @return Returns the copy of item list the player is holding.
   */
  public List<Item> getItemList();

  /**
   * Makes the player to pick an item from the room it is currently in and add it to its own item
   * list.
   *
   * @param item Item to be added to players item list.
   * @return true if the item was successfully picked up i.e. itemList.size() < itemBagLimit and
   *        the itemName is valid and exists in the room; false otherwise.
   * @throws IllegalArgumentException when item is null.
   */
  public boolean pickItem(Item item);

  /**
   * Gives back the item bag limit of the player.
   *
   * @return the item bag limit of the player.
   */
  public int getItemBagLimit();

  /**
   * Gives back the current spite level of the player.
   *
   * @return back the current spite level of the player.
   */
  public int getSpiteLevel();

  /**
   * Gives back a String specifying where the player currently is and the names of the spaces that
   * can be seen from its current space. A space that contains the target's pet cannot be seen and
   * hence is excluded from the output.
   *
   * @return a string value specifying where the player currently is and the names of the spaces
   *        that can be seen from its current space.
   */
  public String lookAround();

  /**
   * Removes the item from the player's item list.
   *
   * @param item Item that needs to be removes from item list of the player.
   *
   * @return whether the removal of item from the bag was successful or not.
   * @throws IllegalArgumentException when item is null or item is not present in the item list.
   */
  public boolean removeItemFromBag(Item item);

  /**
   * Move the player to the room mentioned in the parameters.
   *
   * @param room Room where the player wants to move to.
   * @return String value representing the status of the move.
   * @throws IllegalArgumentException when room is null or the room passed is not the neighbor of
   *        the current room.
   */
  public String move(Room room);
}
