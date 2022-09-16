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
 * This class represents the panel that display the information related to a turn's result.
 */
public class TurnResultPanel extends JPanel {
  private JTextArea turnResultTitle;
  private JTextArea turnResultText;
  private JScrollPane scrollableResult;

  /**
   * This constructs the panel that display the information related to a turn's result.
   */
  public TurnResultPanel() {
    BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
    setLayout(boxlayout);
    add(Box.createRigidArea(new Dimension(15, 2)));

    turnResultTitle = new JTextArea(1, 40);
    turnResultTitle.setText("Turn Result: ");
    turnResultTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    add(turnResultTitle);

    turnResultText = new JTextArea(50, 40);
    turnResultText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    turnResultText.setLineWrap(true);

    scrollableResult = new JScrollPane(turnResultText);
    scrollableResult.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    add(scrollableResult);

    add(Box.createVerticalGlue());
  }

  /**
   * This method sets the results of a turn into the turnResultText JLabel.
   *
   * @param textResult the string representing the result text.
   * @throws IllegalArgumentException when textResult is either null or an empty string.
   */
  public void setTurnResultText(String textResult) throws IllegalArgumentException {
    if ("".equals(textResult) || textResult == null) {
      throw new IllegalArgumentException("Text result cannot be null or an empty string.");
    }

    this.turnResultText.setText("" + textResult + "");
  }
}