package junseok.snr.study.pattern.design.factorymethod.step2;

public class BCar implements Car{
    @Override
    public void boot() {
        System.out.println(this.getClass().getName() + " boot");
    }

    @Override
    public void move() {
        System.out.println(this.getClass().getName() + " move");
    }
}
