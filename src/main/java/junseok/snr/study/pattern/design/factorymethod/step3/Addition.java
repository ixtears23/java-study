package junseok.snr.study.pattern.design.factorymethod.step3;

public class Addition implements Operation {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
