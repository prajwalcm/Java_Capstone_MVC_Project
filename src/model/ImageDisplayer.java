package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This class represents a set of functionality to generate a graphical representation of the world.
 *
 */
public class ImageDisplayer {
  private BufferedImage bufferedImage;
  private Graphics graphics;
  private int scaleUpRow;
  private int scaleUpCol;
  private World world;
  private List<Room> roomsList;

  /**
   * This constructor initializes the parameters required to build a graphical world.
   *
   * @param world The instance of World class.
   * @param scaleUpRow row scaling factor.
   * @param scaleUpCol column scaling factor.
   * @throws IllegalArgumentException when world model sent is null.
   * @throws IllegalArgumentException when either scaleUpRow or scaleUpCol is <=0.
   */
  public ImageDisplayer(World world, int scaleUpRow, int scaleUpCol)
          throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("World cannot be null.");
    }

    if (scaleUpRow <= 0 || scaleUpCol <= 0) {
      throw new IllegalArgumentException("Scaling factor must be greater than or equal to 1.");
    }

    this.world = world;
    this.scaleUpRow = scaleUpRow;
    this.scaleUpCol = scaleUpCol;
    this.roomsList = world.getRoomsList();
    bufferedImage = new BufferedImage((world.getColumns() * scaleUpRow),
            (world.getRows() * scaleUpCol), BufferedImage.TYPE_INT_ARGB);
    graphics = bufferedImage.getGraphics();
  }

  /**
   * This function paints the components on the bufferedImage using the graphics object.
   *
   * @param g graphics object returned by the bufferedImage object.
   * @param scaleUpRow scaling factor for the row.
   * @param scaleUpCol scaling factor for the column.
   *
   * @throws IllegalArgumentException when the graphics object g is null or when either scaleUpRow
   *          or scaleUpCol is <=0.
   */
  private void paintComponent(Graphics g, int scaleUpRow, int scaleUpCol)
          throws IllegalArgumentException {
    if (g == null) {
      throw new IllegalArgumentException("Graphics object cannot be null");
    }

    if (scaleUpRow <= 0 || scaleUpCol <= 0) {
      throw new IllegalArgumentException("Scaling factor must be greater than or equal to 1.");
    }

    // Setting background as white
    g.setColor(Color.white);

    g.fillRect(0, 0, world.getColumns() * scaleUpCol,
            world.getRows() * scaleUpRow);
    g.setColor(Color.black);

    for (Room room : roomsList) {
      int startY = (room.getLeftTopRow()) * scaleUpRow;
      int startX = (room.getLeftTopCol()) * scaleUpCol;
      int height = (room.getRightBottomRow() - room.getLeftTopRow() + 1) * scaleUpRow;
      int width = (room.getRightBottomCol() - room.getLeftTopCol() + 1) * scaleUpCol;

      g.drawRect(startX, startY, width, height);
      g.drawString(room.getName(), startX + 4, startY + 16);
    }
  }

  /**
   * This function calls the utility to draw image on buffered image and then save to a png file.
   *
   * @param scaleUpRow scaling factor for the row.
   * @param scaleUpCol scaling factor for the column.
   *
   * @throws IllegalStateException when there is an error writing to the image file.
   * @throws IllegalArgumentException when either scaleUpRow or scaleUpCol is <=0.
   */
  public BufferedImage draw(int scaleUpRow, int scaleUpCol) throws IllegalStateException,
          IllegalArgumentException {
    if (scaleUpRow <= 0 || scaleUpCol <= 0) {
      throw new IllegalArgumentException("Scaling factor must be greater than or equal to 1.");
    }

    try {
      paintComponent(graphics, scaleUpRow, scaleUpCol);
      File file = new File("world.png");
      file.createNewFile();
      ImageIO.write(bufferedImage, "png", file);
      return bufferedImage;
    } catch (IOException e) {
      throw new IllegalStateException("The argument for image file was not valid.");
    }
  }
}
