package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This singleton class represents a utility class that helps parse the input file and generate
 * data that can be understood by the World for construction of other components.
 */
public class WorldInitializer {
  private static WorldInitializer worldInitializer;
  private BufferedReader fileReader;
  private World area51;
  private int maxTurns;

  /**
   * Private Constructor to initialize the fields.
   *
   * @param fileReader this is the Readable reference sent from Main class to WorldInitializer.
   * @param maxTurns this is the maximum number of turns allowed in the game.
   * @throws IllegalArgumentException when fileReader == null or maxTurns <= 0.
   */
  private WorldInitializer(Readable fileReader, int maxTurns) throws IllegalArgumentException {
    if (fileReader == null) {
      throw new IllegalArgumentException("Filereader here cannot be null.");
    }
    if (maxTurns <= 0) {
      throw new IllegalArgumentException("Max turns cannot be non positive.");
    }

    this.fileReader = (BufferedReader) fileReader;
    this.maxTurns = maxTurns;
  }

  /**
   * It initializes the singleton instance or returns the already existing instance.
   *
   * @param fileReader this is the Readable reference sent from Main class to WorldInitializer.
   * @param maxTurns this is the maximum number of turns allowed in the game.
   * @return the singleton instance or the already existing instance.
   * @throws IllegalArgumentException when fileReader == null or maxTurns <= 0.
   */
  public static WorldInitializer getInstance(Readable fileReader, int maxTurns)
          throws IllegalArgumentException {
    if (fileReader == null) {
      throw new IllegalArgumentException("Filereader here cannot be null.");
    }

    if (maxTurns <= 0) {
      throw new IllegalArgumentException("Max turns cannot be non positive.");
    }

    if (worldInitializer == null) {
      worldInitializer = new WorldInitializer(fileReader, maxTurns);
    }
    return worldInitializer;
  }

  /**
   * Updates the current fileReader to use another file reader readable.
   *
   * @param fileReader Readable that helps in reading the input specification file.
   * @throws IllegalArgumentException when fileReader is null.
   */
  public void updateFileReader(Readable fileReader) throws IllegalArgumentException {
    if (fileReader == null) {
      throw new IllegalArgumentException("File reader cannot be null.");
    }

    this.fileReader = (BufferedReader) fileReader;
  }

  /**
   * parse the input file and generate data that can be understood by the World for construction
   * of other components.
   *
   * @return the world model object initialized ot its initial state.
   * @throws IllegalArgumentException when duplicate room names exist in the specification or when
   *        the file name argument passed is wrong.
   */
  public World generateWorld() throws IllegalArgumentException {
    List<Room> roomsList = new ArrayList<>();
    List<Item> itemsList = new ArrayList<>();


    try {
      // Getting World variables
      String[] worldSpecs = fileReader.readLine().strip().split("\\s+");

      StringBuilder stringBuilder = new StringBuilder("");
      for (int i = 2; i < worldSpecs.length; i++) {
        stringBuilder.append(worldSpecs[i]).append(" ");
      }

      // Getting Target variables
      String[] targetSpecs = fileReader.readLine().strip().split("\\s+");

      stringBuilder = new StringBuilder("");
      for (int i = 1; i < targetSpecs.length; i++) {
        stringBuilder.append(targetSpecs[i]).append(" ");
      }

      // Getting pet information
      String petName = fileReader.readLine();

      // Getting number of rooms
      int numberOfRooms = Integer.parseInt(fileReader.readLine().strip());
      // Getting room details
      String[][] roomsDetails = new String[numberOfRooms][];
      for (int i = 0; i < numberOfRooms; i++) {
        roomsDetails[i] = fileReader.readLine().strip().split("\\s+");
      }

      // Getting number of items
      int numberOfItems = Integer.parseInt(fileReader.readLine().strip());

      // Getting item details
      String[][] itemDetails = new String[numberOfItems][];
      for (int i = 0; i < numberOfItems; i++) {
        itemDetails[i] = fileReader.readLine().strip().split("\\s+");
      }

      // Storing Items in itemList
      for (int i = 0; i < numberOfItems; i++) {
        String[] itemArr = itemDetails[i];
        int roomIndex = Integer.parseInt(itemArr[0].strip());
        int damage = Integer.parseInt(itemArr[1].strip());

        stringBuilder = new StringBuilder("");
        for (int j = 2; j < itemArr.length; j++) {
          stringBuilder.append(itemArr[j]).append(" ");
        }
        String itemName = stringBuilder.toString();

        Item item = new ItemImpl(i, itemName.strip(), damage, roomIndex);
        itemsList.add(item);
      }

      Set<Room> roomsSet = new HashSet<>();
      // Storing Room in roomsList and adding rooms to hashSet to compare later if
      // hashSet.size() == roomsList.size(). If not, it means there were duplicate room names where
      // we wanted only unique room names.
      for (int i = 0; i < numberOfRooms; i++) {
        String[] roomArr = roomsDetails[i];
        int leftTopRow = Integer.parseInt(roomArr[0]);
        int leftTopCol = Integer.parseInt(roomArr[1]);
        int rightBottomRow = Integer.parseInt(roomArr[2]);
        int rightBottomCol = Integer.parseInt(roomArr[3]);

        stringBuilder = new StringBuilder("");
        for (int j = 4; j < roomArr.length; j++) {
          stringBuilder.append(roomArr[j]).append(" ");
        }
        String roomName = stringBuilder.toString().strip();

        Room room = new RoomImpl(i, roomName.strip(), leftTopRow, leftTopCol, rightBottomRow,
                rightBottomCol, itemsList);
        roomsList.add(room);

        roomsSet.add(room);
      }

      if (roomsList.size() != roomsSet.size()) {
        throw new IllegalArgumentException("Room names cannot have duplicates.");
      }

      int worldRows = Integer.parseInt(worldSpecs[0]);
      int worldCols = Integer.parseInt(worldSpecs[1]);
      String worldName = worldSpecs[2];
      String targetName = targetSpecs[1];
      int targetHealth = Integer.parseInt(targetSpecs[0]);

      area51 = new WorldImpl(worldRows, worldCols, worldName, roomsList, itemsList, targetName,
              petName, targetHealth, maxTurns);

      area51.generateBaseImage(29, 40);

      return area51;
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Argument wrong, could not read.");
    }
  }
}