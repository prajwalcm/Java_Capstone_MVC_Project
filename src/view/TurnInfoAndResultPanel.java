package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This class represents the functionalities and the state of a panel that is responsible for
 * displaying the pre-turn information as well ar results of a turn.
 */
public class TurnInfoAndResultPanel extends JPanel {
  private TurnInfoPanel turnInfoPanel;
  private TurnResultPanel turnResultPanel;

  /**
  * This constructs the JPanel object which displays pre-turn information as well as results
  * of a turn.
  */
  public TurnInfoAndResultPanel() {
    BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
    setLayout(boxlayout);
    add(Box.createRigidArea(new Dimension(5, 0)));

    turnInfoPanel = new TurnInfoPanel();
    turnResultPanel = new TurnResultPanel();

    //Adding border to both panels.
    turnInfoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    turnResultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    //Setting size of both panel.
    Dimension frameDim = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension turnInfoPanelDim = turnInfoPanel.getPreferredSize();
    //Subtracting 4 to account for border of the panel and scrollbar width.
    turnInfoPanelDim.width = (frameDim.width / 4) - 34;
    turnInfoPanelDim.height = frameDim.height / 2;
    turnInfoPanel.setPreferredSize(turnInfoPanelDim);

    Dimension turnResultPanelDim = turnResultPanel.getPreferredSize();
    turnResultPanelDim.width = (frameDim.width / 4) - 34;
    turnResultPanelDim.height = frameDim.height / 2;
    turnResultPanel.setPreferredSize(turnResultPanelDim);

    add(turnInfoPanel);
    add(turnResultPanel);
  }

  /**
  * This method sets the results of a turn into the TurnResultPanel object.
  *
  * @param textResult string value of result of a turn.
  * @throws IllegalArgumentException when textResult is null or an empty string.
  */
  public void setTurnResultText(String textResult) throws IllegalArgumentException {
    if ("".equals(textResult) || textResult == null) {
      throw new IllegalArgumentException("textResult cannot be null or an empty string.");
    }
    this.turnResultPanel.setTurnResultText(textResult);
  }

  /**
  * This method sets the information of pre-turn into the TurnInfoPanel object.
  *
  * @param turnInfo string value of pre-turn information.
  * @throws IllegalArgumentException when turnIngo is either null or an empty string.
  */
  public void setTurnInfoText(String turnInfo) throws IllegalArgumentException {
    if ("".equals(turnInfo) || turnInfo == null) {
      throw new IllegalArgumentException("turnInfo cannot be null or an empty string.");
    }
    this.turnInfoPanel.setTurnInfoText(turnInfo);
  }
}