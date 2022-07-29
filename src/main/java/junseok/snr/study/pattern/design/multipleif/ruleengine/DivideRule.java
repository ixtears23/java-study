package junseok.snr.study.pattern.design.multipleif.ruleengine;

public class DivideRule implements Rule {

    private int result;

    @Override
    public boolean evaluate(Expression expression) {
        boolean evalResult = false;
        if (expression.getOperator() == Operator.DIVIDE) {
            evalResult = true;
            result = expression.getX() / expression.getY();
        }
        return evalResult;
    }

    @Override
    public Result getResult() {
        return new Result(result);
    }
}
