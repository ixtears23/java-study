package junseok.snr.study.pattern.design.factorymethod.step2;

public class BCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new BCar();
    }
}
