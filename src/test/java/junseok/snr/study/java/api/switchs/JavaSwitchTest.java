package junseok.snr.study.java.api.switchs;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class JavaSwitchTest {
    
    private static JavaSwitch javaSwitch;

    @BeforeAll
    static void setUp() {
        javaSwitch = new JavaSwitch();
    }

    @AfterAll
    static void tearDown() {
        javaSwitch = null;
    }

    @CsvSource({ "1,월", "2,화", "3,수", "4,목", "5,금", "6,토", "7,일" })
    @ParameterizedTest
    void previousVersionSwitchTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.previousVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }

    @CsvSource({ "1,월", "2,화", "3,수", "4,목", "5,금", "6,토", "7,일" })
    @ParameterizedTest
    void java14AfterVersionSwitchTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.java14AfterVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }
}