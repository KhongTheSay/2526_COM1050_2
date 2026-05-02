package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

/**
 * Verifies the path separator expected by this exercise.
 */
public class WindowsPathTest {

  @Test
  void testFilePath() {
    assertEquals(
        "\\",
        java.io.File.separator,
        "Sai dinh dang dau gach cheo cua he dieu hanh!");

        
    Path path = Path.of("target", "test-folder", "file.txt");
    assertTrue(path.toString().contains(File.separator));
  }


  @Test
    void testFilePath1() {
        Path path = Paths.get("target", "test-folder", "file.txt");
        String fileName = path.getFileName().toString();
        
        assertEquals("file.txt", fileName, "Tên file phải là file.txt");
    }
}
