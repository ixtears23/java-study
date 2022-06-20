package junseok.snr.study.pattern.design.factorymethod.step2;

public class ACarFactory extends CarFactory{

    @Override
    public Car createCar() {
        return new ACar();
    }
}
