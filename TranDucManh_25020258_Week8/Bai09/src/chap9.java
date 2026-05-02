

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GradeClassifier {
    /**
     * Phân loại học lực dựa trên điểm GPA (thang 10).
     * [0.0, 5.0)  -> "Yếu"
     * [5.0, 6.5)  -> "Trung bình"
     * [6.5, 8.0)  -> "Khá"
     * [8.0, 10.0] -> "Giỏi"
     * Ngoài [0.0, 10.0]: ném IllegalArgumentException
     */
    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA không hợp lệ: " + gpa);
        }
        if (gpa < 5.0) return "Yếu";
        if (gpa < 6.5) return "Trung bình";
        if (gpa < 8.0) return "Khá";
        return "Giỏi";
    }
}

class GradeClassifierTest { 
    @BeforeAll
    static void start() {
        System.out.println("=== Bắt đầu test ===");
    }

    @AfterAll
    static void end() {
        System.out.println("=== Kết thúc test ===");
    }

    @Test
    void test1(){
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.1));
    }

    @Test
    void test2(){
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.1)); // Sửa chữ "bình" viết thường
    }

    @Test
    void test3(){
        assertEquals("Khá", GradeClassifier.classifyGrade(6.6));
    }

    @Test
    void test4(){
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10));
    }

    @Test
    void test5() {
        assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.1);
        });
    }

    @Test
    void test6() {
        assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-0.1);
        });
    }

    @Test
    void test7(){
        assertEquals("Yếu", GradeClassifier.classifyGrade(0)); // Điểm 0 là Yếu, không phải Giỏi
    }
}

public class chap9 {
    public static void main(String[] args) {
        System.out.println("Test");
        System.out.println("Điểm 0 thuộc loại: " + GradeClassifier.classifyGrade(0));
    }
}




// javac -d build -cp "lib/*" src/chap9.java
// java -cp "build;lib/*" org.junit.platform.console.ConsoleLauncher execute --scan-class-path build