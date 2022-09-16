package model;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Represents a common set of functionalities for read only operations exposed to the view.
 */
public interface ReadOnlyWorld {
  /**
   * Gives back the String which contains current player's name and also the return String from
   * CPU players if the CPU players were next in the list.
   *
   * @return a String which contains current player's name and also the return String from
   *        CPU players if the CPU players were next in the list.
   * @throws IllegalStateException when (numberOfTurns >= maxTurns) or when playerList is empty or
   *        when target's health becomes <= 0.
   */
  public String getTurnInformation();

  /**
   * Gives description of a specific player including the room it is in and the item it is carrying.
   *
   * @param playerName name of the player.
   * @return A string representation describing information about a specific player including the
   *        room it is in and the item it is carrying.
   * @throws IllegalArgumentException when playerName is null or empty string.
   */
  public String getPlayerDescription(String playerName);

  /**
   * This gives back the buffered image representation of the world with its spaces.
   * @return Buffered Image representation of the world with its spaces.
   */
  public BufferedImage getBaseImage();

  /**
   * Gives back a list of all the room names in the world.
   *
   * @return a list of all the room names in the world.
   */
  public List<String> getRoomNames();

  /**
   * Gives back a list of names of items in the current player's room.
   *
   * @return a list of names of items in the current player's room.
   */
  public List<String> getItemNamesInRoom();

  /**
   * Gives back a list of names of items in the current player's bag.
   *
   * @return a list of names of items in the current player's bag.
   */
  public List<String> getItemNamesInBag();

}
