package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void startup() {
        System.out.println("tests startup");
    }

    @BeforeEach
    void startBrowser() {
        System.out.println("browser has started");
    }
    @AfterEach
    void stopBrowser() {
        System.out.println("browser has stopped");
    }
    @AfterAll
    static void teardown() {
        System.out.println("tests ended");
    }


    @Test
    void firstTest() {
        System.out.println(" - firstTest");
    }

    @Test
    void secondTest() {
        System.out.println(" - secondTest");
    }

}
