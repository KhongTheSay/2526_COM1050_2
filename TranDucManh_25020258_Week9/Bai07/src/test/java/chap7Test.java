package com.uet.bai07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/** Tests for {@link chap7}. */
public class chap7Test {

  @Test
  public void testAdd() {
    chap7 app = new chap7();
    assertEquals(5, app.add(2, 3));
  }

  @Test
  public void testIsEven() {
    chap7 app = new chap7();
    assertTrue(app.isEven(4));
    assertFalse(app.isEven(5));
  }
}
