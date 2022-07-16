package junseok.snr.study.pattern.design.multipleif.factoryclass;

public class Multiplication implements Operation {
    @Override
    public int apply(int a, int b) {
        return a * b;
    }
}
