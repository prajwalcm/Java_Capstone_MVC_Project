package model;

import java.util.List;

/**
 * This interface represents a room i.e. space in the world model.
 */
public interface Room {
  /**
   * Calculates neighbors to the current room and updates the neighborRooms list.
   *
   * @param roomsList list of rooms.
   * @throws IllegalArgumentException when roomList is null or roomlist size is < 1.
   */
  public void calculateNeighborsAndSave(List<Room> roomsList);

  /**
   * Gives back copy of list of neighbors to this room i.e. neighborRooms list.
   *
   * @return the copy of list of neighbors to this room which is the neighborRooms list.
   */
  public List<Room> getNeighbors();

  /**
   * Gives back the copy of list of items in the room.
   *
   * @return the copy of list of items present in the room.
   */
  public List<Item> getItemsList();

  /**
   * Gives the value of left top row of the room.
   *
   * @return the value of left top row of the room.
   */
  public int getLeftTopRow();

  /**
   * Gives the value of left top column of the room.
   *
   * @return the value of left top column of the room.
   */
  public int getLeftTopCol();

  /**
   * Gives the value of right bottom row of the room.
   *
   * @return the value of right top row of the room.
   */
  public int getRightBottomRow();

  /**
   * Gives the value of right bottom column of the room.
   *
   * @return the value of right bottom column of the room.
   */
  public int getRightBottomCol();

  /**
   * Gives back the room number/index of the room.
   *
   * @return the room number/index of the room.
   */
  public int getRoom();

  /**
   * Gives back name of the room.
   *
   * @return name of the room.
   */
  public String getName();

  /**
   * Adds a player to the players in room list. This happens when a player enter a room.
   *
   * @param player the player that need to be added to the room.
   * @throws IllegalArgumentException when player is null.
   */
  public void addPlayerToRoom(Player player);

  /**
   * Remove a player from the players in room list. This happens when a player moves to
   * another room.
   *
   * @param player the player that needs to be removed from the players in room list.
   * @throws IllegalArgumentException when player is null.
   */
  public void removePlayerFromRoom(Player player);

  /**
   * Removes an item from the item list, this happens when a player picks up an item.
   *
   * @param item the item that need to be removed from the room.
   * @throws IllegalArgumentException when item is null.
   */
  public void removeItemFromRoom(Item item);

  /**
   * Gives back a copy of detailed list of players in the room.
   *
   * @return copy of detailed list of players present in the room currently.
   */
  public List<Player> getPlayersInRoom();

  /**
   * Sets the status whether the pet is currently present in the room or not. This is likely to
   * be used when the pet is moved from one room to the other.
   *
   * @param isInRoom boolean denoting whether the pet is in the room or not.
   */
  public void statusChangePetInRoom(boolean isInRoom);

  /**
   * Gives back a boolean denoting whether the pet is currently present in the room or not.
   *
   * @return A boolean denoting whether the pet is currently present in the room or not.
   */
  public boolean getIsPetPresent();
}
