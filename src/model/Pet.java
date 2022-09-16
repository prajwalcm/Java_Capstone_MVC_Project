package model;

/**
 * Represents set of functionalities that are expected from the target character's pet in the game.
 */
public interface Pet {
  /**
   * Gives back the copy of the current room in which the pet is residing currently.
   *
   * @return the copy of the current room in which the pet is residing currently.
   */
  public Room getCurrentRoom();

  /**
   * Gives back the name of the target character's pet.
   *
   * @return the name of the target character's pet.
   */
  public String getName();

  /**
   * Moves the pet to the room specified.
   * @param room Room object where the pet is about to be moved to.
   *
   * @return String representation specifying the status of the pet move operation.
   * @throws IllegalArgumentException When room is null or when the room passed is not present in
   *        the roomslist.
   */
  public String movePet(Room room);

  /**
   * Moves the pet through the world in a DFS manner and returns the current room after the
   * operation of DFS based move is done. THe DFS operation is done in a way of order of the rooms
   * in the rooms list of the world.
   *
   * @return the current room the pet is in after moving in the Depth First manner as per the order
   *        of list of rooms in the world specs.
   */
  public Room movePetDfs();
}
