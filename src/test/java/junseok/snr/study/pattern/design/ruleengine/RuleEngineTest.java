package junseok.snr.study.pattern.design.ruleengine;

import static org.assertj.core.api.Assertions.assertThat;

import junseok.snr.study.pattern.design.multipleif.ruleengine.Expression;
import junseok.snr.study.pattern.design.multipleif.ruleengine.Operator;
import junseok.snr.study.pattern.design.multipleif.ruleengine.Result;
import junseok.snr.study.pattern.design.multipleif.ruleengine.RuleEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleEngineTest {

    @Test
    @DisplayName("RuleEngine 덧셈 테스트")
    void addRuleTest() {
        Expression expression = new Expression(5, 5, Operator.ADD);
        RuleEngine engine = new RuleEngine();
        Result result = engine.process(expression);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("RuleEngine 뺄셈 테스트")
    void subtractRuleTest() {
        final Expression expression = new Expression(10, 8, Operator.SUBTRACT);
        final RuleEngine ruleEngine = new RuleEngine();
        final Result result = ruleEngine.process(expression);

        assertThat(result.getValue()).isEqualTo(2);
    }

}