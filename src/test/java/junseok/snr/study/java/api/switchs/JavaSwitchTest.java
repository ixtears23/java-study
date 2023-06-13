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
    @ParameterizedTest(name = "(java14 이전)[{0}]을 입력받으면 [{1}]요일을 반환하는 테스트")
    void previousVersionSwitchThenDayOfWeekTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.previousVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }

    @CsvSource({ "0,X", "-1,X", "8,X" })
    @ParameterizedTest(name = "(java14 이전)1~7이외의 숫자 [{0}] 입력 받으면 [{1}] 문자열을 반환하는 테스트")
    void previousVersionSwitchThenXTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.previousVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }

    @CsvSource({ "1,월", "2,화", "3,수", "4,목", "5,금", "6,토", "7,일" })
    @ParameterizedTest(name = "(java14 이후)[{0}]을 입력받으면 [{1}]요일을 반환하는 테스트")
    void java14AfterVersionSwitchThenDayOfWeekTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.java14AfterVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }

    @CsvSource({ "0,X", "-1,X", "8,X" })
    @ParameterizedTest(name = "(java14 이후)1~7이외의 숫자 [{0}] 입력 받으면 [{1}] 문자열을 반환하는 테스트")
    void java14AfterVersionSwitchThenXTest(int i, String expectedDayOfWeek) {
        final String dayOfWeek = javaSwitch.java14AfterVersionSwitch(i);

        assertEquals(expectedDayOfWeek, dayOfWeek);
    }
}