import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
   * Metamorphic Relation 1: Collections.sort(list) == Collections.sort(listTransformed)
   *
   * Description: Reverse the original input list
   *
   * Input transformation:
   * 1. Collections.reverse(listTransformed)
   *
   * Relation check after transformation:
   * 1. listTransformed.equals(list)
   *
   * @param list the list to be sorted
   * @param <T>  the class of the objects in the list
   */
  private <T extends Comparable<? super T>> void relationOne(List<T> list) {
    // The list transformation
    List<T> listTransformed = new ArrayList<>(list);
    Collections.reverse(listTransformed);

    System.out.println("\nRelation 1");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list              : " + list);
    System.out.println("Transformed input list           : " + listTransformed);

    // Sort both original and transformed lists
    Collections.sort(list);
    Collections.sort(listTransformed);

    System.out.println("Original input list after sort   : " + list);
    System.out.println("Transformed input list after sort: " + listTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(list, listTransformed);
  }

  /**
   * Metamorphic Relation 2: Collections.sort(list) ⊂ Collections.sort(listTransformed)
   *
   * Description: Double the size and content of original input by adding itself
   *
   * Input transformation:
   * 1. listTransformed.addAll(list)
   *
   * Relation check after transformation:
   * 1. listTransformed.size == 2 * list.size()
   * 2. listTransformed.get(2 * i) == list.get(i)
   * 3. listTransformed.get(2 * i + 1) == list.get(i)
   *
   * @param list the list to be sorted
   * @param <T>  the class of the objects in the list
   */
  private <T extends Comparable<? super T>> void relationTwo(List<T> list) {
    // The list transformation
    List<T> listTransformed = new ArrayList<>(list);
    listTransformed.addAll(list);

    System.out.println("Relation 2");
    System.out.println("-----------------------------------------");
    System.out.println("Original input list              : " + list);
    System.out.println("Transformed input list           : " + listTransformed);

    // Sort both original and transformed lists
    Collections.sort(list);
    Collections.sort(listTransformed);

    System.out.println("Original input list after sort   : " + list);
    System.out.println("Transformed input list after sort: " + listTransformed);

    // Relation check after transformation: 1.
    Assertions.assertEquals(2 * list.size(), listTransformed.size());

    // Relation check after transformation: 2. and 3.
    for (int i = 0, n = list.size(); i < n; i++) {
      Assertions.assertEquals(list.get(i), listTransformed.get(2 * i));
      Assertions.assertEquals(list.get(i), listTransformed.get(2 * i + 1));
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
   * Test Case 2, Relation 1, 1000 automated tests with random inputs
   *
   * Category combinations: L3 ∧ L4
   * Metamorphic relation: see {@link SortTest#relationOne(List)}
   */
  @Test
  void relationOneTestCaseTwoAutomated() {
    Random rand = new Random();
    List<Integer> randomList = new ArrayList<>();

    // Minimum list size = 0, maximum list size = 100
    final int listSize = rand.nextInt(101);

    // Add random integers into the list
    for (int i = 0; i < listSize; i++) {
      randomList.add(rand.nextInt());
    }

    // Run the automated test 1000 times
    for (int i = 0; i < 1000; i++) {
      relationOne(randomList);
    }
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