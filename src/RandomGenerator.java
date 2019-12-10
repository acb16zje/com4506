import java.util.Random;

/**
 * A class to generate random things
 *
 * @author Zer Jun Eng
 */
class RandomGenerator {
  private static final Random random = new Random();

  /**
   * Generate a random int
   *
   * @param max the upper bound (exclusive). Must be positive.
   * @return int A random integer
   */
  static int getRandomInt(int max) {
    return random.nextInt(max);
  }
}
