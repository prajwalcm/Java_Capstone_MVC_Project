package main;

import controller.Controller;
import controller.ControllerImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.World;
import model.WorldInitializer;
import view.View;
import view.ViewImpl;

/**
 * This represents the class that drives the program from initialization to the start phase.
 */
public class Driver {
  /**
   * The main function that will drive the creation of model, controller and call the
   * controller's start method.
   *
   * @param args Variable length command line arguments.
   */
  public static void main(String[] args) {
    try {
      File inputFile = new File(args[0]);
      int maxTurns = Integer.parseInt(args[1]);
      FileReader fileReader = new FileReader(inputFile);
      WorldInitializer worldInitializer = WorldInitializer.getInstance(
              new BufferedReader(fileReader), maxTurns);
      World world = worldInitializer.generateWorld();
      View view = new ViewImpl(world);
      Controller controller = new ControllerImpl(world);
      controller.setView(view);
      view.showScreen();

    } catch (IOException ioe) {
      System.out.println("Error reading the file.");
    } catch (NumberFormatException nfe) {
      System.out.println("Enter valid max number of turns");
    }
  }
}
