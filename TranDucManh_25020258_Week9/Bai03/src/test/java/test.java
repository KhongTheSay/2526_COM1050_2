package test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class test {
    @Test
    void testGreeting() {
        chap3 app = new chap3();
        assertNotNull(app.getGreeting(), null);
    }
} 
    
