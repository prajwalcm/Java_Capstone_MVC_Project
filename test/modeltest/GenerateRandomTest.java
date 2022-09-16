package modeltest;

import static org.junit.Assert.assertEquals;

import model.GenerateRandom;
import org.junit.Test;

/**
 *  This class represents the test suite for the World class.
 */
public class GenerateRandomTest {
  /**
   * Testing whether using the parameterized constructor will initialise the random variable
   * with the passed value.
   */
  @Test
  public void testGenerateRandomParamConstructor() {
    GenerateRandom generateRandom = new GenerateRandom(2);
    int value = generateRandom.getRandomInt(3);
    assertEquals(2, value);
  }

  /**
   * Testing whether getRandomInt() returns the expected value or not.
   */
  @Test
  public void testGetRandomInt() {
    GenerateRandom generateRandom = new GenerateRandom(2);
    int value = generateRandom.getRandomInt(3);
    assertEquals(2, value);
  }
}
