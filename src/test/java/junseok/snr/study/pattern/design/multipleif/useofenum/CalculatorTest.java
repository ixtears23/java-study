package junseok.snr.study.pattern.design.multipleif.useofenum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private static final int A = 15;
    private static final int B = 3;
    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈 계산 테스트 A + B")
    void addCalculateTest() {
        final int expectedValue = 18;

        final int resultCalculate = calculator.calculate(A, B, Operator.ADD);

        assertThat(resultCalculate).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("곱셈 계산 테스트 A * B")
    void multiplyCalculateTest() {
        final int expectedValue = 45;

        final int resultCalculate = calculator.calculate(A, B, Operator.MULTIPLY);

        assertThat(resultCalculate).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("뺼셈 계산 테스트 A - B")
    void subtractCalculateTest() {
        final int expectedValue = 12;

        final int resultCalculate = calculator.calculate(A, B, Operator.SUBTRACT);

        assertThat(resultCalculate).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("곱셈 계산 테스트 A / B")
    void divideCalculateTest() {
        final int expectedValue = 5;

        final int resultCalculate = calculator.calculate(A, B, Operator.DIVIDE);

        assertThat(resultCalculate).isEqualTo(expectedValue);
    }
}