package junseok.snr.study.java.api.record;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @DisplayName("person record의 기본 기능이 제대로 동작하는지 테스트")
    @Test
    void personTest() {
        final String name = "오준석";
        final int age = 33;
        final Person person = new Person(name, age);
        final String greet = person.greet();

        assertEquals(name, person.name());
        assertEquals(age, person.age());
        assertEquals(name + age, greet);
    }
}