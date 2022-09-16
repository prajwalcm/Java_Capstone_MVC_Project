package model;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Represents a common set of functionalities of the model exposed to controller to play the game.
 */
public interface World extends ReadOnlyWorld {

  /**
   * Adds a player to the game, the player can be either computer player or human player.
   *
   * @param name name of the player.
   * @param roomName name of the room the player will start in.
   * @param itemBagLimit limit of the number of items the bag of the player can carry.
   * @param isHuman whether the player is human or computer player.
   * @return String representing a message for the status of the addition of the player.
   * @throws IllegalArgumentException  when name is null or empty string, roomName is null or empty
   *         string, item bag limit < 0, playerRoom is null.
   * @throws IllegalStateException when number of players >= 10 and this function is called.
   */
  public String addPlayerPiece(String name, String roomName, int itemBagLimit,
                             boolean isHuman);

  /**
   * Moves the player to a specific room.
   *
   * @param roomName name of the room the player wants to move to.
   * @return String representing a message for the status of moving the player.
   * @throws IllegalArgumentException when roomName is null or empty string.
   * @throws IllegalStateException when number of turns >= max turns.
   */
  public String movePlayerPiece(String roomName);

  /**
   * Makes the player pick the item.
   *
   * @param itemName name of the item the player wants to pick.
   * @return String stating that whether the item pick up by the player was successful or not.
   * @throws IllegalArgumentException when itemName is null or empty string.
   */
  public String playerPickItem(String itemName);

  /**
   * Gives back number of rows in the world.
   *
   * @return number of rows in the world.
   */
  public int getRows();

  /**
   * Gives back number of columns in the world.
   *
   * @return number of columns in the world.
   */
  public int getColumns();

  /**
   * Gives information about the room the player is in along with its neighboring rooms and their
   * details.
   *
   * @return A String giving out all information about the room the player currently is in along
   *         with its neighbors.
   * @throws IllegalArgumentException when player is null.
   * @throws IllegalStateException when numberOfTurns >= maxTurns.
   */
  public String playerLookAround();

  /**
   * Gives description about a specific room in the world.
   *
   * @param roomName Name of the room.
   * @return A detailed description about the room.
   * @throws IllegalArgumentException when roomName is null or an empty String or the room does not
   *        exist in the world.
   */
  public String displayRoomInformation(String roomName);


  /**
   * Performs random activities for the simulation of the computer player and returns back the
   * string result.
   *
   * @param option integer value to specify the option number to choose from the given options
   *        of moves by computer player.
   *
   * @param flagUseRandom specifies whether to use actual Random values or specific value.
   * @return string value of the result of performing the function that was randomly chosen.
   * @throws IllegalArgumentException when option is either < 0 or > 2
   * @throws IllegalStateException when numberOfTurns > maxTurns or if current Turn is of a human.
   */
  public String playComputerPlayer(int option, boolean flagUseRandom);

  /**
   * Returns whether current turn player is human or not.
   *
   * @return gives back whether the current turn is human or not.
   */
  public boolean isCurrentTurnHuman();

  /**
   * Gives back the max number of turns.
   *
   * @return back the max number of turns.
   */
  public int getMaxTurns();

  /**
   * Gives back the number of turns played until now.
   *
   * @return the number of turns played until now.
   */
  public int getNumberOfTurns();

  /**
   * Moves the pet from one room to the intended room by the player.
   *
   * @param roomName Name of the room where the pet is intended to be moved.
   * @return a string that denotes the status of the operation of moving the pet from one room to
   *        another.
   * @throws IllegalArgumentException when roomName is either null or an empty string or no
   *        such room exists in the world.
   * @throws IllegalStateException when the number of turns >= max turns of the game.
   */
  public String movePet(String roomName);

  /**
   * Attempts an attack on the target using either an item form the item bag or pokes the target if
   *        no tem is present.
   *
   * @param itemName name of the item to be used for the attack to be made on the target.
   * @return a string representing the status of the attack attempt made on the target.
   *
   * @throws IllegalArgumentException when itemName is either null or an empty string or when there
   *        is no such item present in the item bag. Also, it is thrown when a 'poke' attack is
   *        attempted but the player still has item/items in its bag. Also, it is thrown when an
   *        attempt is made on the target when the target is ot in the same room.
   *
   * @throws IllegalStateException when the number of turns >= max turns of the game.
   */
  public String attack(String itemName);

  /**
   * Generates the BufferedImage for the world representation.
   *
   * @param scaleUpRow scaling factor for the row.
   * @param scaleUpCol scaling factor for the column.
   * @throws IllegalArgumentException panelDimension is null.
   */
  public void generateBaseImage(int scaleUpRow, int scaleUpCol);

  /**
   * Saves a 2D list of each player's scaled coordinates as a list into the overlayPieceCoordinates
   * field.
   */
  public void generateOverlayPieceCoordinates();

  /**
   *  Gives back the targetPiece from the model world.
   *
   * @return the targetPiece from the model world.
   */
  public Target getTargetPiece();

  /**
   * Gives back a copy of list of rooms in the world.
   *
   * @return a copy of list of rooms in the world.
   */
  public List<Room> getRoomsList();

  /**
   * Gives back a copy of list of players in the game.
   *
   * @return copy of player list.
   */
  public List<Player> getPlayerList();

  /**
   * Gives back the current player's room name.
   *
   * @return current player's room name.
   */
  public String getCurrentPlayerRoomName();

  /**
   * This method takes in a set of coordinates and checks and returns which room was clicked taking
   * into account that the coordinates were from a scaled image.
   *
   * @return string value of room name that was clicked.
   * @throws IllegalArgumentException when either x or y is negative.
   */
  public String getRoomNameFromCoordinates(int x, int y);
}
