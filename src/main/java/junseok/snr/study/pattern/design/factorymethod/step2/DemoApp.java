package junseok.snr.study.pattern.design.factorymethod.step2;

public class DemoApp {
    public static void main(String[] args) {
        CarFactory factory1 = new ACarFactory();
        CarFactory factory2 = new BCarFactory();
        final Car car1 = factory1.createCar();
        final Car car2 = factory2.createCar();

        car1.boot();
        car1.move();

        car2.boot();
        car2.move();
    }
}
