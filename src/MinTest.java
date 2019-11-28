import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class MinTest {

  @Test
  void minNumberTest() {
    int minNumber = 1;

    List<Integer> arrayList = new ArrayList<>();
    arrayList.add(minNumber);
    arrayList.add(2);
    arrayList.add(3);

    List<Integer> modified = arrayList;
    modified.add(4);

    assertEquals(Collections.min(arrayList), Collections.min(modified));
  }

  @Test
  void minStringTest() {
    List<String> list = new ArrayList<>();
    list.add("Donny");
    list.add("Frenco");
    list.add("A");

    System.out.println(Collections.min(list));

    assertEquals(Collections.min(list), "A");
  }
}