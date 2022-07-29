package junseok.snr.study.pattern.design.multipleif.ruleengine;

public class MultiplyRule implements Rule {

    private int result;

    @Override
    public boolean evaluate(Expression expression) {
        boolean evalResult = false;
        if (expression.getOperator() == Operator.MULTIPLY) {
            this.result = expression.getX() * expression.getY();
            evalResult = true;
        }
        return evalResult;
    }

    @Override
    public Result getResult() {
        return new Result(this.result);
    }
}
