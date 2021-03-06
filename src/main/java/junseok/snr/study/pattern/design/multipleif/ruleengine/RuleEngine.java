package junseok.snr.study.pattern.design.multipleif.ruleengine;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private static final List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new AddRule());
        rules.add(new SubtractRule());
        rules.add(new DivideRule());
        rules.add(new MultiplyRule());
    }

    public Result process(Expression expression) {
        Rule rule = rules.stream()
                .filter(r -> r.evaluate(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Expression does not matches any rule"));
        return rule.getResult();
    }
}
