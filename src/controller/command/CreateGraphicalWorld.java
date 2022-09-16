package controller.command;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.World;
import model.WorldInitializer;
import view.View;

/**
 * This class represents the command construct that will enable to create a graphical representation
 * of the world.
 */
public class CreateGraphicalWorld implements Command {
  private View view;
  private World newWorld;

  /**
   * Constructs the object that will be further enable to create a graphical representation of the
   * world.
   *
   * @param view the View object that the controller interacts to and gets the input the user
   *             entered.
   * @throws IllegalArgumentException when view is null.
   */
  public CreateGraphicalWorld(View view) throws IllegalArgumentException {
    if (view == null) {
      throw new IllegalArgumentException("Scan input cannot be null.");
    }

    this.view = view;
  }

  @Override
  public String execute(World world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("The model cannot be null.");
    }

    World newWorld = null;
    String filePath = this.view.getFileFromFileChooser();
    int maxTurns = world.getMaxTurns();
    File inputFile = new File(filePath);
    try {
      FileReader fileReader = new FileReader(inputFile);
      WorldInitializer worldInitializer = WorldInitializer.getInstance(
              new BufferedReader(fileReader), maxTurns);
      worldInitializer.updateFileReader(new BufferedReader(fileReader));
      newWorld = worldInitializer.generateWorld();
      this.view.updateModel(newWorld);
      this.newWorld = newWorld;
      Dimension gamePlayDimension = this.view.getGamePlayPanelSize();
      this.newWorld.generateBaseImage(gamePlayDimension.height, gamePlayDimension.width);

    } catch (IOException ioe) {
      throw new IllegalArgumentException("File path entered is not valid.");
    }

    Dimension gamePlayDimension = view.getGamePlayPanelSize();
    newWorld.generateBaseImage(gamePlayDimension.height, gamePlayDimension.width);

    return "Image representation created successfully.";
  }

  /**
   * Gives back the newly generated world.
   *
   * @return the newly generated world.
   */
  public World getNewWorld() {
    return this.newWorld;
  }
}
