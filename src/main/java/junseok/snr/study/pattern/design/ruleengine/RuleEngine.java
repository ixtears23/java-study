package junseok.snr.study.pattern.design.ruleengine;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private static List<Rule> rules = new ArrayList<>();

    static {
        rules.add(new AddRule());
    }

    public Result process(Expression expression) {
        return rules.stream()
                .filter(r -> r.evaluate(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Expression does not mathes any rule"));
    }
}
