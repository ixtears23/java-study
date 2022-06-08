package junseok.snr.study.pattern.design.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
