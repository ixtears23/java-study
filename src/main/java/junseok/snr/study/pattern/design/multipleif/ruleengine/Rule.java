package junseok.snr.study.pattern.design.multipleif.ruleengine;

public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult();
}
