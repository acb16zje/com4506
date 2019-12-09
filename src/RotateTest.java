import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * A JUnit class to test the  {@link java.util.Collections#rotate(List, int)} )} method
 *
 * @author Zer Jun Eng
 */
class RotateTest {

  private final List<Object> CASE_1 = new ArrayList<>();
  private final int CASE_1_DISTANCE = 0;

  private final List<Object> CASE_2 = new ArrayList<>(Arrays.asList(1, 2, 'a', 'b', 3.7, 4, "str"));
  private final int CASE_2_DISTANCE = Integer.MAX_VALUE;

  private final List<Integer> CASE_3 = IntStream.rangeClosed(1, 201).boxed()
      .collect(Collectors.toList());
  private final int CASE_3_DISTANCE = Integer.MIN_VALUE;

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: L1, D2 ∧ D5
   * Metamorphic relation: Reverse the original input list, convert distance to opposite sign
   */
  @Test
  void relationOneTestCaseOne() {
    System.out.println(CASE_3);
  }

  /**
   * Test Case 1, Relation 2
   *
   * Category combinations: L1, D2 ∧ D5
   * Metamorphic relation: Add the value of distance * list.size() to distance
   */
  @Test
  void relationTwoTestCaseOne() {

  }

  /**
   * Test Case 2, Relation 1
   *
   * Category combinations: L3 ∧ L5, D3 ∧ D4 ∧ D8
   * Metamorphic relation: Reverse the original input list, convert distance to opposite sign
   */
  @Test
  void relationOneTestCaseTwo() {

  }

  /**
   * Test Case 2, Relation 2
   *
   * Category combinations: L3 ∧ L5, D3 ∧ D4 ∧ D8
   * Metamorphic relation: Add the value of distance * list.size() to distance
   */
  @Test
  void relationTwoTestCaseTwo() {

  }

  /**
   * Test Case 3, Relation 1
   *
   * Category combinations: L3 ∧ L8, D1 ∧ D6 ∧ D7
   * Metamorphic relation: Reverse the original input list, convert distance to opposite sign
   */
  @Test
  void relationOneTestCaseThree() {

  }

  /**
   * Test Case 3, Relation 2
   *
   * Category combinations: L3 ∧ L8, D1 ∧ D6 ∧ D7
   * Metamorphic relation: Add the value of distance * list.size() to distance
   */
  @Test
  void relationTwoTestCaseThree() {

  }
}