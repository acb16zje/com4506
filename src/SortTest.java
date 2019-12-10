import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
   * Metamorphic Relation 1: Collections.sort(x) == Collections.sort(xTransformed)
   *
   * Description: Reverse the original input list
   *
   * Input transformation:
   * 1. Collections.reverse(xTransformed)
   *
   * Relation check after transformation:
   * 1. xTransformed.equals(x)
   *
   * @param list the list to be sorted
   * @param <T>  the class of the objects in the list
   */
  private <T extends Comparable<? super T>> void relationOne(List<T> list) {
    List<T> x = new ArrayList<>(list);

    // The list transformation
    List<T> xTransformed = new ArrayList<>(list);
    Collections.reverse(xTransformed);

    System.out.println("Relation 1");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list              : " + x);
    System.out.println("Transformed input list           : " + xTransformed);

    // Sort both original and transformed lists
    Collections.sort(x);
    Collections.sort(xTransformed);

    System.out.println("Original input list after sort   : " + x);
    System.out.println("Transformed input list after sort: " + xTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(x, xTransformed);
  }

  /**
   * Metamorphic Relation 2: Collections.sort(x) ⊂ Collections.sort(xTransformed)
   *
   * Description: Double the size and content of original input by adding itself
   *
   * Input transformation:
   * 1. xTransformed.addAll(x)
   *
   * Relation check after transformation:
   * 1. xTransformed.size == 2 * x.size()
   * 2. xTransformed.get(2 * i) == x.get(i)
   * 3. xTransformed.get(2 * i + 1) == x.get(i)
   *
   * @param list the list to be sorted
   * @param <T>  the class of the objects in the list
   */
  private <T extends Comparable<? super T>> void relationTwo(List<T> list) {
    List<T> x = new ArrayList<>(list);

    // The list transformation
    List<T> xTransformed = new ArrayList<>(list);
    xTransformed.addAll(x);

    System.out.println("Relation 2");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list              : " + x);
    System.out.println("Transformed input list           : " + xTransformed);

    // Sort both original and transformed lists
    Collections.sort(x);
    Collections.sort(xTransformed);

    System.out.println("Original input list after sort   : " + x);
    System.out.println("Transformed input list after sort: " + xTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(2 * x.size(), xTransformed.size());

    // Relation check after transformation: 2. and 3.
    for (int i = 0, n = x.size(); i < n; i++) {
      Assertions.assertEquals(x.get(i), xTransformed.get(2 * i));
      Assertions.assertEquals(x.get(i), xTransformed.get(2 * i + 1));
    }
  }

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: L2
   * Metamorphic relation: see {@link SortTest#relationOne(List)}
   */
  @Test
  void relationOneTestCaseOne() {
    relationOne(CASE_1);
  }

  /**
   * Test Case 1, Relation 2
   *
   * Category combinations: L2
   * Metamorphic relation: see {@link SortTest#relationTwo(List)}
   */
  @Test
  void relationTwoTestCaseOne() {
    relationTwo(CASE_1);
  }

  /**
   * Test Case 2, Relation 1
   *
   * Category combinations: L3 ∧ L4
   * Metamorphic relation: see {@link SortTest#relationOne(List)}
   */
  @Test
  void relationOneTestCaseTwo() {
    relationOne(CASE_2);
  }

  /**
   * Test Case 2, Relation 2
   *
   * Category combinations: L3 ∧ L4
   * Metamorphic relation: see {@link SortTest#relationTwo(List)}
   *
   * @see SortTest#relationTwo(List)
   */
  @Test
  void relationTwoTestCaseTwo() {
    relationTwo(CASE_2);
  }

  /**
   * Test Case 3, Relation 1
   *
   * Category combinations: L3 ∧ L7
   * Metamorphic relation: see {@link SortTest#relationOne(List)}
   */
  @Test
  void relationOneTestCaseThree() {
    relationOne(CASE_3);
  }

  /**
   * Test Case 3, Relation 2
   *
   * Category combinations: L3 ∧ L7
   * Metamorphic relation: see {@link SortTest#relationTwo(List)}
   */
  @Test
  void relationTwoTestCaseThree() {
    relationTwo(CASE_3);
  }
}