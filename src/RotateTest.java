import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A JUnit class to test the {@link java.util.Collections#rotate(List, int)} method
 *
 * @author Zer Jun Eng
 */
class RotateTest {

  private final List<Object> CASE_1 = new ArrayList<>(Collections.emptyList());
  private final int CASE_1_DISTANCE = 0;

  private final List<Object> CASE_2 = new ArrayList<>(Arrays.asList(1, 2, 'a', 'b', 3.7, 4, "str"));
  private final int CASE_2_DISTANCE = Integer.MAX_VALUE;

  private final List<Integer> CASE_3 = IntStream.rangeClosed(1, 201).boxed()
      .collect(Collectors.toList());
  private final int CASE_3_DISTANCE = Integer.MIN_VALUE;


  /**
   * Metamorphic Relation 1:
   * 1. Collections.rotate(list, distance) == Collections.rotate(listTransformed,
   * distanceTransformed) if and only if {@code list == listTransformed} before the rotation
   *
   * 2. Otherwise, Collections.rotate(list, distance) == Collections.rotate(listTransformed,
   * distanceTransformed) if and only if {@code listTransformed} is reversed after the rotation
   *
   * Description: Reverse the original input list, convert distance to opposite sign after modulo
   * with the size of original input list
   *
   * Input transformation:
   * 1. Collections.reverse(listTransformed);
   * 2. distanceTransformed = -(distance % list.size())
   *
   * Relation check after transformation:
   * 1. After reversing listTransformed again, then listTransformed.equals(list)
   *
   * @param list     the list to be rotated
   * @param distance the distance to rotate the list. There are no
   *                 constraints on this value; it may be zero, negative, or
   *                 greater than {@code list.size()}.
   */
  private void relationOne(List<?> list, int distance) {
    // The list transformation
    List<?> listTransformed = new ArrayList<>(list);
    Collections.reverse(listTransformed);

    // The distance transformation
    int distanceTransformed = list.size() == 0 ? 0 : -(distance % list.size());

    System.out.println("Relation 1");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list                : " + list);
    System.out.println("Transformed input list             : " + listTransformed);

    // Rotate both original and transformed list
    Collections.rotate(list, distance);
    Collections.rotate(listTransformed, distanceTransformed);

    System.out.println("Original input list after rotate   : " + list);
    System.out.println("Transformed input list after rotate: " + listTransformed);

    // Reverse listTransformed again
    Collections.reverse(listTransformed);

    System.out.println("Reverse transformed input again    : " + listTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(list, listTransformed);
  }

  /**
   * Metamorphic Relation 2:
   * 1. Collections.rotate(list, distance) == Collections.rotate(listTransformed,
   * distanceTransformed) if and only if {@code list == listTransformed} before the rotation
   *
   * 2. Collections.rotate(list, distance != Collections.rotate(listTransformed,
   * distanceTransformed), but after rotating, every element in {@code listTransformed} is "behind"
   * {@code list}
   *
   * Description: Decrease distance to observe the index difference of each element
   *
   * Input transformation:
   * 1. Collections.reverse(listTransformed);
   * 2. distanceTransformed < (distance % list.size())
   *
   * Relation check after transformation:
   * 1. Every element in listTransformed is (distance % list.size()) - distanceTransformed indices
   * "behind" list
   *
   * @param list     the list to be rotated
   * @param distance the distance to rotate the list. There are no
   *                 constraints on this value; it may be zero, negative, or
   *                 greater than {@code list.size()}.
   */
  private void relationTwo(List<?> list, int distance) {
    // The list transformation
    List<?> listTransformed = new ArrayList<>(list);

    // The distance transformation - transform distance to any number that is < original distance
    Random rand = new Random();
    int dTransformed = list.size() == 0 ? 0 : rand.nextInt(Math.floorMod(distance, list.size()));

    int deltaDistance = list.size() == 0 ? 0 : (distance % list.size()) - dTransformed;

    System.out.println("Relation 2");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list                : " + list);
    System.out.println("Transformed input list             : " + listTransformed);
    System.out.println("Delta distance                     : " + deltaDistance);

    // Rotate both original and transformed list
    Collections.rotate(list, distance);
    Collections.rotate(listTransformed, dTransformed);

    System.out.println("Original input list after rotate   : " + list);
    System.out.println("Transformed input list after rotate: " + listTransformed);

    // Relation check after transformation: 1.
    for (int i = 0, n = list.size(); i < n; i++) {
      Assertions
          .assertEquals(list.get(i), listTransformed.get(Math.floorMod(i - deltaDistance, n)));
    }
  }

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: L1, D2 ∧ D5
   * Metamorphic relation: see {@link RotateTest#relationOne(List, int)}
   */
  @Test
  void relationOneTestCaseOne() {
    relationOne(CASE_1, CASE_1_DISTANCE);
  }

  /**
   * Test Case 1, Relation 2
   *
   * Category combinations: L1, D2 ∧ D5
   * Metamorphic relation: see {@link RotateTest#relationTwo(List, int)}
   */
  @Test
  void relationTwoTestCaseOne() {
    relationTwo(CASE_1, CASE_1_DISTANCE);
  }

  /**
   * Test Case 2, Relation 1
   *
   * Category combinations: L3 ∧ L5, D3 ∧ D4 ∧ D8
   * Metamorphic relation: see {@link RotateTest#relationOne(List, int)}
   */
  @Test
  void relationOneTestCaseTwo() {
    relationOne(CASE_2, CASE_2_DISTANCE);
  }

  /**
   * Test Case 2, Relation 2
   *
   * Category combinations: L3 ∧ L5, D3 ∧ D4 ∧ D8
   * Metamorphic relation: see {@link RotateTest#relationTwo(List, int)}
   */
  @Test
  void relationTwoTestCaseTwo() {
    relationTwo(CASE_2, CASE_2_DISTANCE);
  }

  /**
   * Test Case 3, Relation 1
   *
   * Category combinations: L3 ∧ L8, D1 ∧ D6 ∧ D7
   * Metamorphic relation: see {@link RotateTest#relationOne(List, int)}
   */
  @Test
  void relationOneTestCaseThree() {
    relationOne(CASE_3, CASE_3_DISTANCE);
  }

  /**
   * Test Case 3, Relation 2
   *
   * Category combinations: L3 ∧ L8, D1 ∧ D6 ∧ D7
   * Metamorphic relation: see {@link RotateTest#relationTwo(List, int)}
   */
  @Test
  void relationTwoTestCaseThree() {
    relationTwo(CASE_3, CASE_3_DISTANCE);
  }
}