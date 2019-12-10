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
  private final int CASE_2_DISTANCE = 27;

  private final List<Integer> CASE_3 = IntStream.rangeClosed(1, 201).boxed()
      .collect(Collectors.toList());
  private final int CASE_3_DISTANCE = Integer.MIN_VALUE;


  /**
   * Metamorphic Relation 1:
   * 1. Collections.rotate(x, d) == Collections.rotate(xTransformed, dTransformed) if and only if
   * {@code x == xTransformed} before the rotation
   *
   * 2. Collections.rotate(x, d) == Collections.rotate(xTransformed, dTransformed) if and only if
   * {@code xTransformed} is reversed after the rotation
   *
   * Description: Reverse the original input list, convert distance to opposite sign after modulo
   * with the size of original input list
   *
   * Input transformation:
   * 1. Collections.reverse(xTransformed);
   * 2. dTransformed = -(distance % x.size())
   *
   * Relation check after transformation:
   * 1. After reversing xTransformed again, then xTransformed.equals(x)
   *
   * @param list     the list to be rotated
   * @param distance the distance to rotate the list. There are no
   *                 constraints on this value; it may be zero, negative, or
   *                 greater than {@code list.size()}.
   */
  private void relationOne(List<?> list, int distance) {
    List<?> x = new ArrayList<>(list);

    // The list transformation
    List<?> xTransformed = new ArrayList<>(x);
    Collections.reverse(xTransformed);

    // The distance transformation
    int dTransformed = x.size() == 0 ? 0 : -(distance % x.size());

    System.out.println("Relation 1");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list                : " + x);
    System.out.println("Transformed input list             : " + xTransformed);

    // Rotate both original and transformed list
    Collections.rotate(x, distance);
    Collections.rotate(xTransformed, dTransformed);

    System.out.println("Original input list after rotate   : " + x);
    System.out.println("Transformed input list after rotate: " + xTransformed);

    // Reverse xTransformed again
    Collections.reverse(xTransformed);

    System.out.println("Reverse transformed input again    : " + xTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(x, xTransformed);
  }

  /**
   * Metamorphic Relation 2:
   * 1. Collections.rotate(x, d) == Collections.rotate(xTransformed, dTransformed) if and only if
   * {@code x == xTransformed} before the rotation
   *
   * 2. Collections.rotate(x, d) != Collections.rotate(xTransformed, dTransformed), but after
   * rotating, every element in {@code xTransformed} is "behind" {@code x}
   *
   * Description: Decrease distance to observe the index difference of each element
   *
   * Input transformation:
   * 1. Collections.reverse(xTransformed);
   * 2. dTransformed < (distance % x.size())
   *
   * Relation check after transformation:
   * 1. Every element in xTransformed is (distance % x.size()) - dTransformed indices "behind" x
   *
   * @param list     the list to be rotated
   * @param distance the distance to rotate the list. There are no
   *                 constraints on this value; it may be zero, negative, or
   *                 greater than {@code list.size()}.
   */
  private void relationTwo(List<?> list, int distance) {
    List<?> x = new ArrayList<>(list);

    // The list transformation
    List<?> xTransformed = new ArrayList<>(x);

    // The distance transformation - transform distance to any number that is < original distance
    Random rand = new Random();
    int dTransformed = x.size() == 0 ? 0 : rand.nextInt(Math.floorMod(distance, x.size()));

    int deltaDistance = x.size() == 0 ? 0 : (distance % x.size()) - dTransformed;

    System.out.println("Relation 2");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list                : " + x);
    System.out.println("Transformed input list             : " + xTransformed);
    System.out.println("Delta distance                     : " + deltaDistance);

    // Rotate both original and transformed list
    Collections.rotate(x, distance);
    Collections.rotate(xTransformed, dTransformed);

    System.out.println("Original input list after rotate   : " + x);
    System.out.println("Transformed input list after rotate: " + xTransformed);

    // Relation check after transformation: 1.
    for (int i = 0, n = x.size(); i < n; i++) {
      Assertions.assertEquals(x.get(i), xTransformed.get(Math.floorMod(i - deltaDistance, n)));
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