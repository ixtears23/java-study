package junseok.snr.study.pattern.design.ruleengine;

public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult();
}
