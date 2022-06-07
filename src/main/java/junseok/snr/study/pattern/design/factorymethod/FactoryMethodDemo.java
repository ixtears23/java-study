package junseok.snr.study.pattern.design.factorymethod;

public class FactoryMethodDemo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusiness();
    }

    static void configure() {
        if (System.getenv("os.name").equals("Windows 10")) {
            dialog = new WindowDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusiness() {
        dialog.renderWindow();
    }
}
