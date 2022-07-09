package junseok.snr.study.pattern.design.factorymethod.step3;

public class Demo {
    public static void main(String[] args) {
        final Demo demo = new Demo();
        demo.calculateUsingFactory(10, 20, Operator.DIVIDE);
    }

    public int calculateUsingFactory(int a, int b, Operator operator) {
        return OperatorFactory.getOperation(operator)
                .orElseThrow(IllegalAccessError::new)
                .apply(a, b);
    }
}
