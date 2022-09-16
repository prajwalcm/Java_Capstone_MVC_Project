package view;

import controller.Features;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.ReadOnlyWorld;

/**
 * Represents the state and the set of functionalities that are expected from the AddPlayer Frame
 * of the view of the game.
 */
public class AddPlayerFrameImpl extends JFrame implements AddPlayerFrame {
  private ReadOnlyWorld model;

  //Components of the form.
  private Container c;
  private JLabel title;
  private JLabel statusMessage;
  private JLabel playerNameLabel;
  private JLabel bagLimitLabel;
  private JTextField playerNameInputField;
  private JLabel roomNameLabel;
  private JLabel playerTypeLabel;
  private JRadioButton humanRadioButton;
  private JRadioButton computerRadioButton;
  private ButtonGroup buttonGroup;
  private JButton submitButton;
  private JButton startGameButton;
  private JTextField bagLimitInputField;
  private JComboBox<String> roomDropDown;
  private JScrollPane jScrollPane;
  private List<String> playerDetails;

  /**
   * Constructs the AddPlayerFrame object and sets the read only world for this frame.
   *
   * @param world the read only model of the world.
   * @throws IllegalArgumentException when world is null.
   */
  public AddPlayerFrameImpl(ReadOnlyWorld world) throws IllegalArgumentException {
    super("Add Player Window");
    if (world == null) {
      throw new IllegalArgumentException("World parameter cannot be null.");
    }

    this.model = world;

    setBounds(300, 90, 900, 600);
    //setResizable(false);

    c = getContentPane();

    //Let's set the layout of the frame here.
    c.setLayout(null);  //Could use a border layout here.

    title = new JLabel("Add Players to the Game");
    title.setFont(new Font("Times New Roman", Font.PLAIN, 45));
    title.setSize(600, 60);
    title.setLocation(725, 30);
    c.add(title);

    statusMessage = new JLabel("");
    statusMessage.setFont(new Font("Times New Roman", Font.PLAIN, 25));
    statusMessage.setSize(1000, 40);
    statusMessage.setLocation(725, 110);
    c.add(statusMessage);


    playerNameLabel = new JLabel("Player Name: ");
    playerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    playerNameLabel.setSize(400, 50);
    playerNameLabel.setLocation(600, 300);
    c.add(playerNameLabel);

    playerNameInputField = new JTextField();
    playerNameInputField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    playerNameInputField.setSize(600, 50);
    playerNameInputField.setLocation(810, 300);
    c.add(playerNameInputField);

    roomNameLabel = new JLabel("Room Name: ");
    roomNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    roomNameLabel.setSize(400, 50);
    roomNameLabel.setLocation(600, 400);
    c.add(roomNameLabel);

    // Fetching room names
    List<String> roomNames = this.model.getRoomNames();

    // Populate the dropdown with room names.
    String[] roomChoices = new String[roomNames.size()];
    roomNames.toArray(roomChoices);
    roomDropDown = new JComboBox<String>(roomChoices);
    roomDropDown.setSize(600, 50);
    roomDropDown.setLocation(810, 400);
    c.add(roomDropDown);

    bagLimitLabel = new JLabel("Bag Limit: ");
    bagLimitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    bagLimitLabel.setSize(400, 50);
    bagLimitLabel.setLocation(600, 500);
    c.add(bagLimitLabel);

    bagLimitInputField = new JTextField();
    bagLimitInputField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    bagLimitInputField.setSize(600, 50);
    bagLimitInputField.setLocation(810, 500);
    c.add(bagLimitInputField);

    playerTypeLabel = new JLabel("Player Type:");
    playerTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    playerTypeLabel.setSize(400, 50);
    playerTypeLabel.setLocation(600, 600);
    c.add(playerTypeLabel);

    humanRadioButton = new JRadioButton("Human");
    humanRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    humanRadioButton.setSelected(true);
    humanRadioButton.setSize(180, 50);
    humanRadioButton.setLocation(810, 600);
    c.add(humanRadioButton);

    computerRadioButton = new JRadioButton("Computer");
    computerRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    computerRadioButton.setSelected(false);
    computerRadioButton.setSize(200, 50);
    computerRadioButton.setLocation(1000, 600);
    c.add(computerRadioButton);

    buttonGroup = new ButtonGroup();
    buttonGroup.add(humanRadioButton);
    buttonGroup.add(computerRadioButton);

    submitButton = new JButton("Submit");
    submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    submitButton.setSize(200, 50);
    submitButton.setLocation(800, 700);
    c.add(submitButton);

    startGameButton = new JButton("Start Game");
    startGameButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    startGameButton.setSize(200, 50);
    startGameButton.setLocation(1100, 700);
    c.add(startGameButton);
  }

  @Override
  public void setFeatures(Features features) throws IllegalArgumentException {
    if (features == null) {
      throw new IllegalArgumentException("Features parameter cannot be null.");
    }

    this.submitButton.addActionListener(l -> {
      String result = features.notifyAddPlayerPiece();
      this.statusMessage.setText(result.split("\n")[0]);
    });

    this.startGameButton.addActionListener(l -> {
      if (this.playerDetails.size() == 0) {
        this.statusMessage.setText("Add players before starting the game");
        return;
      }
      features.notifyScreenChange();
    });

    this.playerDetails = new ArrayList<>();

  }

  @Override
  public void display() {
    //This makes size of JFrame equal to entire screen.
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    // Fetching room names
    List<String> roomNames = this.model.getRoomNames();

    c.remove(roomDropDown);


    // Populate the dropdown with room names.
    String[] roomChoices = new String[roomNames.size()];

    roomNames.toArray(roomChoices);
    roomDropDown = new JComboBox<String>(roomChoices);
    roomDropDown.setSize(600, 50);
    roomDropDown.setLocation(810, 400);
    c.add(roomDropDown);

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
  public void savePlayerDetails() {
    String playerName = this.playerNameInputField.getText();
    String roomName = this.roomDropDown.getSelectedItem().toString();
    String itemBagLimit = this.bagLimitInputField.getText();
    boolean isHuman = false;
    if (humanRadioButton.isSelected()) {
      isHuman = true;
    }
    this.playerNameInputField.setText("");
    this.bagLimitInputField.setText("");

    List<String> playerDetails = new ArrayList<String>();
    playerDetails.add(playerName);
    playerDetails.add(roomName);
    playerDetails.add(itemBagLimit);
    playerDetails.add(isHuman == true ? "true" : "false");

    this.playerDetails = playerDetails;
  }

  @Override public List<String> getPlayerDetails() {
    return this.playerDetails;
  }

  @Override
  public void dispatchEventClose() {
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    this.dispose();
  }

}
