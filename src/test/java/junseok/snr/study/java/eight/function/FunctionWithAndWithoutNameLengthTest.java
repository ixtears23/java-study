package junseok.snr.study.java.eight.function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionWithAndWithoutNameLengthTest {

    public static final String DEFAULT_DISPLAY_NAME = "문자열 [{0}]의 길이는 [{1}]과 같아야 한다.";
    private static FunctionWithAndWithoutNameLength functionWithAndWithoutNameLength;

    @BeforeAll
    static void setUp() {
        functionWithAndWithoutNameLength = new FunctionWithAndWithoutNameLength();
    }

    @ParameterizedTest(name = "[{index}] Function을 사용하지 않은 테스트." + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = {
            "Junseok, 7",
            "'', 0",
            "Jane, 4"
    })
    void getNameLengthTest(String name, Integer expectedLength) {
        final int nameLength = functionWithAndWithoutNameLength.getNameLength(name);

        assertThat(nameLength).isEqualTo(expectedLength);
    }

    @ParameterizedTest(name = "[{index}] Function을 사용한 테스트." + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = {
            "Junseok, 7",
            "'', 0",
            "Jane, 4"
    })
    void getNameLengthFunctionTest(String name, Integer expectedLength) {
        final Integer nameLength = functionWithAndWithoutNameLength.getNameLengthFunction()
                .apply(name);

        assertThat(nameLength).isEqualTo(expectedLength);
    }
}