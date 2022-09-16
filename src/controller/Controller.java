package controller;

import view.View;

/**
 * This represents an interface that contains functionalities that a Controller for the game must
 * possess.
 */
public interface Controller extends Features {
  /**
   * Starts the controller when called.
   *
   * @return String representing that the controller has started.
   */
  public String start();

  /**
   * Sets the view parameter in the controller to allow for communicating back to the view on what
   * to do next.
   *
   * @param view Sets the view parameter of the controller so that controller can communicate back
   *          to the view.
   *
   * @throws IllegalArgumentException when view is null.
   */
  public void setView(View view);
}
