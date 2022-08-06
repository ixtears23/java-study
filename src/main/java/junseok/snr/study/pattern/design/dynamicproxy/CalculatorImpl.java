package junseok.snr.study.pattern.design.dynamicproxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int left, int right) {
        return left + right;
    }
}
