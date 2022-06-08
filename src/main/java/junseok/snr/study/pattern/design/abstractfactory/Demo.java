package junseok.snr.study.pattern.design.abstractfactory;

public class Demo {

    private static Application configureApplication() {
        Application application;
        GUIFactory guiFactory;

        String osName = System.getenv("os.name").toLowerCase();
        if (osName.equals("mac")) {
            guiFactory = new MacOSFactory();
            application = new Application(guiFactory);
        } else {
            guiFactory = new WindowsFactory();
            application = new Application(guiFactory);
        }

        return application;
    }
    public static void main(String[] args) {
        final Application application = configureApplication();
        application.paint();
    }
}
