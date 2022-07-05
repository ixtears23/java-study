package junseok.snr.study.pattern.design.ruleengine;

import java.beans.Expression;

public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult;
}
