import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
public class chap8 {

    public static void main(String[] args) {
        System.out.println("=== Demo ===");
        System.out.println(MathUtils.max(5, 3));
        System.out.println(MathUtils.divide(10, 2));
    }
}

 class MathUtils {
    public static int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }
}
class MathUtilsTest {

    @BeforeAll
    static void start() {
        System.out.println("=== Bắt đầu test ===");
    }

    @AfterAll
    static void end() {
        System.out.println("=== Kết thúc test ===");
    }

    // max
    @Test
    void test1() {
        assertEquals(5, MathUtils.max(5, 3));
    }

    @Test
    void test2() {
        assertEquals(3, MathUtils.max(3, 3));
    }

    @Test
    void test3() {
        assertEquals(5, MathUtils.max(2, 5));
    }

    @Test
    void test4() {
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
    }

    @Test
    void test5() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    }

    @Test
    void test6() {
        assertEquals(0, MathUtils.max(0, Integer.MIN_VALUE));
    }

    @Test
    void test7() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
    }

    // divide
    @Test
    void testDivide1() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    void testDivide2() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    @Test
    void testDivide3() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
    }
}

// java -cp "build;lib/junit-platform-console-standalone-1.10.0.jar" org.junit.platform.console.ConsoleLauncher --scan-class-path
// java -cp "build;lib/junit-platform-console-standalone-1.10.0.jar" org.junit.platform.console.ConsoleLauncher --scan-class-path