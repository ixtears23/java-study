package junseok.snr.study.pattern.design.factorymethod.step1;

public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World'");
    }
}
