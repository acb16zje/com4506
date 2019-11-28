import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SortTest {

  @Test
  void something() {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(2);
    list.add(1);

    List<Integer> sortedList = new ArrayList<>();
    sortedList.add(1);
    sortedList.add(2);
    sortedList.add(3);

    Collections.sort(list);

    assertEquals(sortedList, list);
  }
}