import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * A JUnit class to test the {@link java.util.Collections#sort(List)} method
 *
 * @author Zer Jun Eng
 */
class SortTest {

  private final List<Integer> CASE_1 = new ArrayList<>(Collections.singletonList(1));
  private final List<Integer> CASE_2 = new ArrayList<>(Arrays.asList(6, 8, 2, 4, 7, 5, 3, 2, 9));
  private final List<Integer> CASE_3 = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: L2
   * Metamorphic relation: Reverse the original input list
   */
  @Test
  void relationOneTestCaseOne() {

  }

  /**
   * Test Case 1, Relation 2
   *
   * Category combinations: L2
   * Metamorphic relation: Double the size and content of original input by adding itself
   */
  @Test
  void relationTwoTestCaseOne() {

  }

  /**
   * Test Case 2, Relation 1
   *
   * Category combinations: L3 ∧ L4
   * Metamorphic relation: Reverse the original input list
   */
  @Test
  void relationOneTestCaseTwo() {

  }

  /**
   * Test Case 2, Relation 2
   *
   * Category combinations: L3 ∧ L4
   * Metamorphic relation: Double the size and content of original input by adding itself
   */
  @Test
  void relationTwoTestCaseTwo() {

  }

  /**
   * Test Case 3, Relation 1
   *
   * Category combinations: L3 ∧ L7
   * Metamorphic relation: Reverse the original input list
   */
  @Test
  void relationOneTestCaseThree() {

  }

  /**
   * Test Case 3, Relation 2
   *
   * Category combinations: L3 ∧ L7
   * Metamorphic relation: Double the size and content of original input by adding itself
   */
  @Test
  void relationTwoTestCaseThree() {

  }
}