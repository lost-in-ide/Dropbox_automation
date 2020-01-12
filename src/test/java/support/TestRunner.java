package support;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestRunner {
    @BeforeClass
    public static void setup() {
        System.out.println("BeforeAll");
    }

    @AfterClass
    public static void teardown() {
        System.out.println("AfterAll");
    }

}
