package junseok.snr.study.pattern.design.multipleif.factoryclass;

public class Demo {
    public static void main(String[] args) {
        final Demo demo = new Demo();
        final Expression expression = Expression.builder()
                .x(20)
                .y(10)
                .build();

        final int resultAdd = demo.calculateUsingFactory(expression, Operator.ADD);
        final int resultSub = demo.calculateUsingFactory(expression, Operator.SUB);
        final int resultMul = demo.calculateUsingFactory(expression, Operator.MUL);
        final int resultDiv = demo.calculateUsingFactory(expression, Operator.DIV);

        System.out.println("ADD : " + resultAdd);
        System.out.println("SUB : " + resultSub);
        System.out.println("MUL : " + resultMul);
        System.out.println("DIV : " + resultDiv);
    }

    public int calculateUsingFactory(Expression expression, Operator operator) {
        return OperatorFactory.getOperation(operator)
                .orElseThrow(IllegalAccessError::new)
                .apply(expression.getX(), expression.getY());
    }
}
