import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A JUnit class to test the {@link java.util.Collections#min(Collection)} method
 *
 * @author Zer Jun Eng
 */
class MinTest {

  private final Collection<Integer> CASE_1 = new ArrayList<>(Collections.singletonList(1));

  private final Collection<Integer> CASE_2 = new ArrayList<>(
      Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

  private final Collection<Integer> CASE_3 = new ArrayList<>(
      Arrays.asList(6, Integer.MIN_VALUE, 2, 4, 7, Integer.MIN_VALUE, 5, 3, 2, 9));


  /**
   * Metamorphic Relation 1: Collection.min(x) <= Collection.min(xTransformed)
   *
   * Description: Add a random element smaller than the minimum element in the original collection.
   * If the minimum element in the original collection is already the minimum possible element for
   * the class, then the random element added is equal to the minimum element.
   *
   * Input transformation:
   * 1. xTransformed.add(---a random element smaller (or equal to) than minimum of x---)
   *
   * Relation check after transformation:
   * 1. output >= outputTransformed
   *
   * @param coll the collection whose minimum element is to be determined
   */
  private void relationOne(Collection<Integer> coll) {
    Collection<Integer> x = new ArrayList<>(coll);

    // Create output from original collection
    Integer output = Collections.min(x);

    // The collection transformation
    Collection<Integer> xTransformed = new ArrayList<>(coll);
    Integer randomMin = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, output + 1);
    xTransformed.add(randomMin);

    // Create output from transformed collection
    Integer outputTransformed = Collections.min(xTransformed);

    System.out.println("Relation 1");
    System.out.println("-----------------------------------------");
    System.out.println("Original input collection    : " + x);
    System.out.println("Transformed input collection : " + xTransformed);
    System.out.println("Original output              : " + output);
    System.out.println("Transformed output           : " + outputTransformed);

    // Relation check after transformation: 1.
    Assertions.assertTrue(output >= outputTransformed);
  }

  /**
   * Metamorphic Relation 2:
   * 1. Collection.min(x) < Collection.min(xTransformed) if and only if {@code x} does not contain
   * only duplicate minimum elements and {@code xTransformed} is not empty
   *
   * 2. Collection.min(x) == Collection.min(xTransformed) if and only if {@code x} contains only
   * duplicate minimum elements and {@code xTransformed} is empty
   *
   * Description: Remove all minimum elements from the original collection
   *
   * Input transformation:
   * 1. xTransformed.removeIf(output::equals)
   *
   * Relation check after transformation:
   * 1. If xTransformed is an empty collection, output == outputTransformed
   * 2. If xTransformed is not an empty collection, output < outputTransformed
   *
   * @param coll the collection whose minimum element is to be determined
   * @param <T>  the class of the objects in the collection
   */
  private <T extends Object & Comparable<? super T>> void relationTwo(
      Collection<? extends T> coll) {
    Collection<T> x = new ArrayList<>(coll);

    // Create output from original collection
    T output = Collections.min(x);

    // The collection transformation
    Collection<T> xTransformed = new ArrayList<>(coll);
    xTransformed.removeIf(output::equals);

    // Create output from transformed collection
    T outputTransformed = xTransformed.isEmpty() ? output : Collections.min(xTransformed);

    System.out.println("Relation 2");
    System.out.println("-----------------------------------------");
    System.out.println("Original input collection    : " + x);
    System.out.println("Transformed input collection : " + xTransformed);
    System.out.println("Original output              : " + output);
    System.out.println("Transformed output           : " + outputTransformed);

    if (xTransformed.isEmpty()) {
      // Relation check after transformation: 1.
      Assertions.assertEquals(output, outputTransformed);

    } else {
      // Relation check after transformation: 2.
      Assertions.assertTrue(output.compareTo(outputTransformed) < 0);
    }
  }

  /**
   * Test Case 1, Relation 1
   *
   * Category combinations: C1
   * Metamorphic relation: Add an element smaller than the minimum element in the original
   * collection
   */
  @Test
  void relationOneTestCaseOne() {
    relationOne(CASE_1);
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
    relationTwo(CASE_1);
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
    relationOne(CASE_2);
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
    relationTwo(CASE_2);
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
    relationOne(CASE_3);
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
    relationTwo(CASE_3);
  }
}