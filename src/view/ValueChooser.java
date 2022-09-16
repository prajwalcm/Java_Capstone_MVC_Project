package view;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * This class represents a set of functionalities that will enable the user to choose from a
 * dropdown menu.
 */
public class ValueChooser {
  /**
   * This method display the JComboBox and enables the user to choose an option from a dropdown and
   * return the chosen option back.
   *
   * @param name name of the combo box.
   * @param dropdownList List of choices to be displayed in the dropdown.
   * @return value of the chosen option.
   * @throws IllegalArgumentException when either name is null or an empty string or when dropdown
   *        list is null.
   */
  public String displayAndSendValue(String name, List<String> dropdownList)
          throws IllegalArgumentException {
    if ("".equals(name) || name == null) {
      throw new IllegalArgumentException("Name cannot be null or an empty string.");
    }

    if (dropdownList == null) {
      throw new IllegalArgumentException("Dropdown list cannot be null.");
    }

    String[] dropDownArray = new String[dropdownList.size()];
    dropdownList.toArray(dropDownArray);
    String result = "";

    Object option = JOptionPane.showInputDialog(null, "Choose the " + name
                   + ":\n", "Object Chooser Box", JOptionPane.QUESTION_MESSAGE, null,
            dropDownArray, dropDownArray[0]);

    result = option.toString();

    return result;
  }
}
