package junseok.snr.study.pattern.design.ruleengine;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleEngineTest {

    @Test
    @DisplayName("Good")
    void nothing() {
        Expression expression = new Expression(5, 5, Operator.ADD);
        RuleEngine engine = new RuleEngine();
        Result result = engine.process(expression);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(10);

    }

}