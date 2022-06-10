package junseok.snr.study.pattern.design.builder;

public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        final CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        director.constructSUV(carBuilder);
        final Car suvCar = carBuilder.getResult();
        System.out.println("Car built:\n" + suvCar.getCarType());
        director.constructSUV(manualBuilder);
        final Manual suvCarManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + suvCarManual.print());

    }
}
