package junseok.snr.study.pattern.design.multipleif.ruleengine;

public class SubtractRule implements Rule {

    private int result;

    @Override
    public boolean evaluate(Expression expression) {
        boolean evalResult = false;

        if (expression.getOperator() == Operator.SUBTRACT) {
            this.result = expression.getX() - expression.getY();
            evalResult = true;
        }

        return evalResult;
    }

    @Override
    public Result getResult() {
        return new Result(this.result);
    }
}
