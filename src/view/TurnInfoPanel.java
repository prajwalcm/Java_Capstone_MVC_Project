package view;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * This class represents the panel that displays the pre-turn information.
 */
public class TurnInfoPanel extends JPanel {
  private JTextArea turnInfoTitle;
  private JTextArea turnInfoText;
  private JScrollPane scrollableTurnInfo;

  /**
   * This constructs the panel that displays the pre-turn information.
   */
  public TurnInfoPanel() {
    BoxLayout boxlayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
    //gamePlayContainer.setLayout(boxlayout);
    setLayout(boxlayout);
    //add(Box.createHorizontalBox());
    add(Box.createRigidArea(new Dimension(15, 2)));

    turnInfoTitle = new JTextArea(1, 40);
    turnInfoTitle.setText("Turn Information:");
    turnInfoTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    //turnInfoTitle.setSize(480, 50);
    add(turnInfoTitle);

    turnInfoText = new JTextArea(50, 40);
    turnInfoText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    turnInfoText.setLineWrap(true);
    turnInfoText.setEditable(false);

    scrollableTurnInfo = new JScrollPane(turnInfoText);
    scrollableTurnInfo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    add(scrollableTurnInfo);
  }

  /**
   * This method sets the information of pre-turn into the turnInfoText JLabel.
   *
   * @param turnInfo string value of pre-turn information.
   * @throws IllegalArgumentException when turnInfo is either null or an empty string.
   */
  public void setTurnInfoText(String turnInfo) throws IllegalArgumentException {
    if ("".equals(turnInfo) || turnInfo == null) {
      throw new IllegalArgumentException("turnInfo cannot be null or an empty string.");
    }
    this.turnInfoText.setText("Game Controls:\n1. Pick Item: i\n2. Look Around: l\n"
           + "3. Move Player: Mouse click on neighbour room\n4. Attack: a\n"
           + "5. Move Pet: m\n6. Player Info: Mouse Click on current player\n***"
           + "******************************************\n" + turnInfo + "");
  }
}