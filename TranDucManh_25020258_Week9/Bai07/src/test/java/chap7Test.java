import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Lớp kiểm thử cho các phương thức trong class chap7.
 */
public class chap7Test {

  @Test
  public void testAdd() {
    chap7 app = new chap7();
    assertEquals(5, app.add(2, 3), "2 + 3 phải bằng 5");
  }

  @Test
  public void testIsEven() {
    chap7 app = new chap7();
    assertTrue(app.isEven(4), "4 phải là số chẵn");
  }
}