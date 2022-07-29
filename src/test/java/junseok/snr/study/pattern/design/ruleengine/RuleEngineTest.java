package junseok.snr.study.pattern.design.ruleengine;

import static org.assertj.core.api.Assertions.assertThat;

import junseok.snr.study.pattern.design.multipleif.ruleengine.Expression;
import junseok.snr.study.pattern.design.multipleif.ruleengine.Operator;
import junseok.snr.study.pattern.design.multipleif.ruleengine.Result;
import junseok.snr.study.pattern.design.multipleif.ruleengine.RuleEngine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleEngineTest {

    private static RuleEngine ruleEngine;

    @BeforeAll
    static void setUp() {
        ruleEngine = new RuleEngine();
    }

    @Test
    @DisplayName("RuleEngine 덧셈 테스트")
    void addRuleTest() {
        Expression expression = new Expression(5, 5, Operator.ADD);
        Result result = ruleEngine.process(expression);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("RuleEngine 뺄셈 테스트")
    void subtractRuleTest() {
        final Expression expression = new Expression(10, 8, Operator.SUBTRACT);
        final Result result = ruleEngine.process(expression);

        assertThat(result.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("RuleEngine 곱셈 테스트")
    void multiplyRuleTest() {
        final Expression expression = new Expression(10, 2, Operator.MULTIPLY);
        final Result result = ruleEngine.process(expression);

        assertThat(result.getValue()).isEqualTo(20);
    }

    @Test
    @DisplayName("RuleEngine 나눗셈 테스트")
    void divideRuleTest() {
        final Expression expression = new Expression(10, 5, Operator.DIVIDE);
        final Result result = ruleEngine.process(expression);

        assertThat(result.getValue()).isEqualTo(2);
    }

}