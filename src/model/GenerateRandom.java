package model;

import java.util.Random;

/**
 * This represents a class to get random numbers which can be generated truly randomly
 * or in a predictable way.
 */
public class GenerateRandom {
  private Integer randomInt;
  private Random random;

  /**
   * Constructs the GenerateRandom object by initializing randomInt and random.
   */
  public GenerateRandom() {
    random = new Random();
    randomInt = null;
  }

  /**
   * Constructs the GenerateRandom object by initializing randomInt and random. It also uses
   * the parameter to send out the 'predictable' random number.
   *
   * @param randomInt the integer value that will be used to set the randomInt value.
   */
  public GenerateRandom(int randomInt) {
    this();
    this.randomInt = randomInt;
  }

  /**
   * Gives back a random number as in the range from 0 to the parameter passed if 'predictable'
   * randomInt is not set.
   *
   * @param range the higher bound for the range of random integer values needed.
   * @return the random or pseudo-random integer.
   */
  public int getRandomInt(int range) {
    if (randomInt != null) {
      return this.randomInt;
    } else {
      return random.nextInt(range);
    }
  }
}
