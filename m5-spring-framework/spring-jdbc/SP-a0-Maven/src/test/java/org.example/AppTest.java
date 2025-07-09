package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testGetMessage() {
        App app = new App();
        assertEquals("Hello World! Maven project setup", app.getMessage());
    }
}
