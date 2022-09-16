package view;

import controller.Features;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import model.ReadOnlyWorld;

/**
 * This class represents the frame, its state and set of functionalities that will enable a user to
 * interact with the the game play.
 */
public class GamePlayFrameImpl extends JFrame implements GamePlayFrame {
  private ReadOnlyWorld model;
  private Features features;
  private Container c;
  private GraphicalWorldPanel graphicalWorldPanel;
  private TurnInfoAndResultPanel turnInfoAndResultPanel;
  private Container gamePlayContainer;
  private JPanel rootPanel;
  private BufferedImage baseImage;
  private JLabel picLabel;
  private JScrollPane graphicalWorldWithScroll;

  /**
   * Constructs the GamePlayFrame object and sets the read only world for this frame.
   *
   * @param world the read only model of the world.
   * @throws IllegalArgumentException when world is null.
   */
  public GamePlayFrameImpl(ReadOnlyWorld world) throws IllegalArgumentException {
    super("Game play");

    if (world == null) {
      throw new IllegalArgumentException("World parameter cannot be null.");
    }

    this.model = world;

    //This is the panel inside the gamePlay Frame which is the master panel.
    rootPanel = new JPanel();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    rootPanel.setSize(screenSize);
    rootPanel.setPreferredSize(screenSize);

    //Let's set the layout of the Game Play frame here.
    // Set the BoxLayout to be X_AXIS: from left to right
    BoxLayout boxlayout = new BoxLayout(rootPanel, BoxLayout.X_AXIS);
    rootPanel.setLayout(boxlayout);

    //Initializing two panels of the GamePlay Frame.
    graphicalWorldPanel = new GraphicalWorldPanel();
    turnInfoAndResultPanel = new TurnInfoAndResultPanel();

    Dimension frameDim = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension graphicalWorldPanelDim = graphicalWorldPanel.getPreferredSize();
    graphicalWorldPanelDim.width = (frameDim.width * 3) / 4;
    graphicalWorldPanelDim.height = frameDim.height;

    Dimension turnInfoAndResultDim = turnInfoAndResultPanel.getPreferredSize();
    turnInfoAndResultDim.width = frameDim.width / 4;
    turnInfoAndResultDim.height = frameDim.height;

    graphicalWorldPanel.setPreferredSize(graphicalWorldPanelDim);

    turnInfoAndResultPanel.setPreferredSize(turnInfoAndResultDim);

    //Adding borders to panels to get their visibility.
    //graphicalWorldPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    turnInfoAndResultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    //Adding layout to Graphical world panel.
    this.baseImage = model.getBaseImage();

    //Adding image to the panel.
    picLabel = new JLabel(new ImageIcon(baseImage));
    picLabel.requestFocus();

    //Adding padding and margin to image.
    Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
    Border emptyBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);

    picLabel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, solidBorder));
    graphicalWorldPanel.add(picLabel);

    //Adding the panel to scroll pane panel.
    graphicalWorldWithScroll = new JScrollPane(graphicalWorldPanel);
    graphicalWorldWithScroll.setHorizontalScrollBarPolicy(JScrollPane
            .HORIZONTAL_SCROLLBAR_AS_NEEDED);
    graphicalWorldWithScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    //Adding panels to the frame.
    rootPanel.add(graphicalWorldWithScroll);
    rootPanel.add(turnInfoAndResultPanel);
    this.add(rootPanel);
  }

  /**
   * Refreshes the game play panel's picLabel so that we get updated information on the screen.
   */
  public void refreshGamePlayScreen() {
    this.baseImage = this.model.getBaseImage();
    this.graphicalWorldPanel.remove(this.picLabel);
    this.picLabel = new JLabel();
    this.picLabel.setIcon(new ImageIcon(this.baseImage));
    this.graphicalWorldPanel.add(picLabel);
    this.picLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        String turnResult = "";
        String result = "";
        result = features.notifyClick(y, x);
        turnInfoAndResultPanel.setTurnResultText(result);
        try {
          turnResult = model.getTurnInformation();
          turnInfoAndResultPanel.setTurnInfoText(turnResult);
        } catch (IllegalStateException ise) {
          turnResult = ise.getMessage();
          turnInfoAndResultPanel.setTurnInfoText(turnResult);
        }

        refreshGamePlayScreen();
      }
    });
    setVisible(true);
  }

  @Override
  public String showItemChooser() {
    ValueChooser valueChooser = new ValueChooser();
    List<String> itemNames = this.model.getItemNamesInRoom();

    String result = valueChooser.displayAndSendValue("Item", itemNames);

    return result;
  }

  @Override
  public String showAttackItemChooser() {
    ValueChooser valueChooser = new ValueChooser();
    List<String> itemNames = this.model.getItemNamesInBag();

    String result = valueChooser.displayAndSendValue("Item", itemNames);

    return result;
  }

  @Override
  public String showRoomChooser() {
    ValueChooser valueChooser = new ValueChooser();
    List<String> neighbourRoomNames = this.model.getRoomNames();

    String result = valueChooser.displayAndSendValue("Room", neighbourRoomNames);

    return result;
  }

  @Override
  public void setTurnInfoText(String text) throws IllegalArgumentException {
    if ("".equals(text) || text == null) {
      throw new IllegalArgumentException("Text string cannot be null or an empty string.");
    }

    this.turnInfoAndResultPanel.setTurnInfoText(text);
    this.turnInfoAndResultPanel.setTurnResultText(text);
  }

  @Override
  public void setFeatures(Features features) throws IllegalArgumentException {
    if (features == null) {
      throw new IllegalArgumentException("Features parameter cannot be null.");
    }

    this.features = features;

    this.rootPanel.setFocusable(true);
    this.rootPanel.requestFocus();

    this.picLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        String turnResult = "";
        String result = "";
        int x = e.getX();
        int y = e.getY();
        result = features.notifyClick(y, x);
        turnInfoAndResultPanel.setTurnResultText(result);
        try {
          turnResult = model.getTurnInformation();
          turnInfoAndResultPanel.setTurnInfoText(turnResult);
        } catch (IllegalStateException ise) {
          turnResult = ise.getMessage();
          turnInfoAndResultPanel.setTurnInfoText(turnResult);
        }

        refreshGamePlayScreen();
      }

    });

    this.rootPanel.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'l') {
          String turnResult = "";

          String result = features.notifyPlayerLookAround();
          turnInfoAndResultPanel.setTurnResultText(result);
          try {
            turnResult = model.getTurnInformation();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          } catch (IllegalStateException ise) {
            turnResult = ise.getMessage();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          }

          refreshGamePlayScreen();
        }

        if (keyEvent.getKeyChar() == 'i') {
          String turnResult = "";

          String result = features.notifyPickItem();
          turnInfoAndResultPanel.setTurnResultText(result);
          try {
            turnResult = model.getTurnInformation();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          } catch (IllegalStateException ise) {
            turnResult = ise.getMessage();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          }

          refreshGamePlayScreen();
        }

        if (keyEvent.getKeyChar() == 'a') {
          String turnResult = "";

          String result = features.notifyPlayerAttack();
          turnInfoAndResultPanel.setTurnResultText(result);
          try {
            turnResult = model.getTurnInformation();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          } catch (IllegalStateException ise) {
            turnResult = ise.getMessage();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          }

          refreshGamePlayScreen();
        }

        if (keyEvent.getKeyChar() == 'm') {
          String turnResult = "";

          String result = features.notifyMovePet();
          turnInfoAndResultPanel.setTurnResultText(result);
          try {
            turnResult = model.getTurnInformation();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          } catch (IllegalStateException ise) {
            turnResult = ise.getMessage();
            turnInfoAndResultPanel.setTurnInfoText(turnResult);
          }

          refreshGamePlayScreen();
        }
      }

      @Override
      public void keyPressed(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar();
      }

      @Override
      public void keyReleased(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar();
      }
    });

  }

  @Override
  public void dispatchEventClose() {
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    this.dispose();
  }

  @Override
  public void display() {
    //This makes size of JFrame equal to entire screen.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.turnInfoAndResultPanel.setTurnInfoText(this.model.getTurnInformation());
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
    refreshGamePlayScreen();
  }

}