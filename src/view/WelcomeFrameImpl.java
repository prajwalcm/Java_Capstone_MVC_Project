package view;

import controller.Features;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.ReadOnlyWorld;

/**
 * Represents the state and the set of functionalities that are expected from the Welcome Frame of
 * the view of the game.
 */
public class WelcomeFrameImpl extends JFrame implements WelcomeFrame {
  private ReadOnlyWorld model;
  private Features features;
  private WelcomeTextPanel welcomeTextPanel;
  private JFileChooser fileChooser;
  private JMenuItem existingSpecItem;
  private JMenuItem newSpecItem;
  private JMenuItem gameRules;
  private JMenuItem exitItem;

  /**
   * Constructs the WelcomeFrame object and sets the read only world for this frame.
   *
   * @param world the read only model of the world.
   * @throws IllegalArgumentException when world is null.
   */
  public WelcomeFrameImpl(ReadOnlyWorld world) throws IllegalArgumentException {
    super("Welcome Window");

    if (world == null) {
      throw new IllegalArgumentException("World parameter cannot be null.");
    }

    // Setting the read only model
    this.model = world;

    //Let's set the layout of the frame here.
    setLayout(new BorderLayout());

    //Adding the menu to the frame.
    setJMenuBar(createMenuBar());

    //Adding a textPanel to hold our display text on welcome screen.
    welcomeTextPanel = new WelcomeTextPanel();
    this.add(welcomeTextPanel, BorderLayout.CENTER);

    //Initializing and adding a File Chooser.
    fileChooser = new JFileChooser();

    //Adding filter to get only txt files.
    FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES",
            "txt", "text");
    fileChooser.setFileFilter(filter);
  }

  /**
   * A helper method that creates a JMenuBar object which represents the menu bar to select options
   * on the welcome screen of the game.
   *
   * @return A JMenuBar object which represents the menu bar to select options on the welcome
   *        screen of the game.
   */
  private JMenuBar createMenuBar() {

    //Creating a menu bar.
    JMenuBar menuBar = new JMenuBar();

    //Creating a menu.
    JMenu optionMenu = new JMenu("Options");

    //Adding menu to menu bar.
    menuBar.add(optionMenu);

    //Creating menu items.
    JMenuItem existingSpecItem = new JMenuItem("Use existing world specification");
    JMenuItem newSpecItem = new JMenuItem("Use custom world specification");
    JMenuItem gameRules = new JMenuItem("View Game Rules");
    JMenuItem exitItem = new JMenuItem("Exit");

    //Adding menu items to menu.
    optionMenu.add(existingSpecItem);
    optionMenu.addSeparator();
    optionMenu.add(newSpecItem);
    optionMenu.addSeparator();
    optionMenu.add(gameRules);
    optionMenu.addSeparator();
    optionMenu.add(exitItem);

    this.existingSpecItem = existingSpecItem;
    this.newSpecItem = newSpecItem;
    this.gameRules = gameRules;
    this.exitItem = exitItem;

    return menuBar;
  }

  @Override
  public void setFeatures(Features features) throws IllegalArgumentException {
    if (features == null) {
      throw new IllegalArgumentException("Features parameter cannot be null.");
    }
    this.features = features;

    //Adding action listener to newSpec Menu item.
    this.newSpecItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        features.notifyCustomWorldFile();
        features.notifyScreenChange();
      }
    });

    this.exitItem.addActionListener(l -> {
      features.exitGame();
      return;
    });

    this.gameRules.addActionListener(l -> {
      //Trigger a dialogue box here.

      StringBuilder gameInfo = new StringBuilder();
      gameInfo.append("Welcome to ")
              .append("Area51 Game!\nObjective: Kill the Alien!")
              .append("\nAlien will move through the facility following certain path.")
              .append("\nGood to Know: You can add 10 players in the game who can be")
              .append(" human or computer player.\nYou may select one of following 5 ")
              .append("Moves when its your turn.\n1. Pick Item: Pick up any item from ")
              .append("the room.\n2. Look Around: Get complete information about your ")
              .append("neighbouring rooms.\n3. Move Player: Move to one of your neighbours.")
              .append("\n4. Attack: Attack the target using weapon available with you.")
              .append("\n5. You may move target's pet to any desired location.")
              .append("\nMore info:")
              .append("\n1. You can get description of player who has current turn.")
              .append(" (This does not counts as a move.)\n2. If someone was watching ")
              .append("you when you made an attempt on target's life;\nyour attack will ")
              .append("fail and you will loose your weapon as well.\n3. Presence of a ")
              .append("pet will make a room and its contents invisible to everyone outside")
              .append("the room. \n4. The pet will keep moving through the facility in a")
              .append("certain path.\n5. Player who successfully kills the target wins the")
              .append("game. \n6.If no one could kill target; the target escapes and ")
              .append("nobody wins.\nGood Luck!");

      JOptionPane.showMessageDialog(this, gameInfo.toString());
    });

    this.existingSpecItem.addActionListener(l -> {
      features.notifyScreenChange();
    });

  }

  @Override
  public String getFilePathFromFileChooser() {
    String filePath = null;
    if (fileChooser.showOpenDialog(WelcomeFrameImpl.this) == JFileChooser.APPROVE_OPTION) {
      File chosenFile = fileChooser.getSelectedFile();
      filePath = chosenFile.getAbsolutePath().toString();
    }
    return filePath;
  }

  @Override
  public void display() {
    //This makes size of JFrame equal to entire screen.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void setDisplay(boolean display) {
    this.setVisible(display);
  }

  @Override
  public void updateModel(ReadOnlyWorld world) throws IllegalArgumentException {
    if (world == null) {
      throw new IllegalArgumentException("world parameter cannot be null.");
    }
    this.model = world;
  }

  @Override
  public void dispatchEventClose() {
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    this.dispose();
  }
}
