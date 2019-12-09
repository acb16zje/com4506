import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/**
 * A JUnit class to test the  {@link java.util.Collections#min(Collection)} method
 *
 * @author Zer Jun Eng
 */
class MinTest {

  private final Collection<Integer> CASE_1 = new ArrayList<>(Collections.singletonList(1));

  private final Collection<Integer> CASE_2 = new ArrayList<>(
      Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

  private final Collection<Integer> CASE_3 = new ArrayList<>(
      Arrays.asList(6, 8, 2, 4, 7, Integer.MIN_VALUE, 5, 3, 2, 9));

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: C1
   * Metamorphic relation: Add an element smaller than the minimum element in the original
   * collection
   */
  @Test
  void relationOneTestCaseOne() {
  }

  /**
   * Test Case 1, Relation 2
   *
   * Category combinations: C1
   * Metamorphic relation: Add an element larger than the minimum element in the original
   * collection
   */
  @Test
  void relationTwoTestCaseOne() {

  }

  /**
   * Test Case 2, Relation 1
   *
   * Category combinations: C2 ∧ C7
   * Metamorphic relation: Add an element smaller than the minimum element in the original
   * collection
   */
  @Test
  void relationOneTestCaseTwo() {

  }

  /**
   * Test Case 2, Relation 2
   *
   * Category combinations: C2 ∧ C7
   * Metamorphic relation: Add an element larger than the minimum element in the original
   * collection
   */
  @Test
  void relationTwoTestCaseTwo() {

  }

  /**
   * Test Case 3, Relation 1
   *
   * Category combinations: C2 ∧ C3 ∧ C4 ∧ C5
   * Metamorphic relation: Add an element smaller than the minimum element in the original
   * collection
   */
  @Test
  void relationOneTestCaseThree() {

  }

  /**
   * Test Case 3, Relation 2
   *
   * Category combinations: C2 ∧ C3 ∧ C4 ∧ C5
   * Metamorphic relation: Add an element larger than the minimum element in the original
   * collection
   */
  @Test
  void relationTwoTestCaseThree() {

  }
}