package view;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the state of the panel that will display the welcome message and the
 * developers that contribute to this project.
 */
public class WelcomeTextPanel extends JPanel {
  private JLabel welcomeMessage;
  private JLabel developerTitle;
  private JLabel developerOne;
  private JLabel developerTwo;

  /**
   * This constructs the welcome panel object and initializes its state.
   */
  public WelcomeTextPanel() {
    //Choosing the box layout for our welcome page.
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    welcomeMessage = new JLabel("Welcome to Area51 Game");
    developerTitle = new JLabel("Developers:");
    developerOne = new JLabel("Siddharth Lalit Chakravorty");
    developerTwo = new JLabel("Prajwal Vijaykumar Chinchmalatpure");
    
    //Formatting JLabels.
    welcomeMessage.setFont(new java.awt.Font("Times New Roman", 0, 84)); // NOI18N
    welcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
   
    //developerTitle.setVerticalAlignment(54);
    developerTitle.setFont(new java.awt.Font("\nTimes New Roman", 0, 54));
    developerOne.setFont(new java.awt.Font("\nTimes New Roman", 0, 34));
    developerTwo.setFont(new java.awt.Font("\nTimes New Roman", 0, 34));
    
    this.add(Box.createRigidArea(new Dimension(550, 30)));
    this.add(welcomeMessage);
    this.add(Box.createRigidArea(new Dimension(550, 300)));
    this.add(developerTitle);
    this.add(Box.createRigidArea(new Dimension(550, 30)));
    this.add(developerOne);
    this.add(Box.createRigidArea(new Dimension(550, 10)));
    this.add(developerTwo);
  }
}