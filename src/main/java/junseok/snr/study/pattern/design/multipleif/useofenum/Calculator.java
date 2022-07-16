package junseok.snr.study.pattern.design.multipleif.useofenum;

public class Calculator {
    public int calculate(int a, int b, Operator operator) {
        return operator.apply(a, b);
    }
}
