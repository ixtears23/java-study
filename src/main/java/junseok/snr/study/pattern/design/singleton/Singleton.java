package junseok.snr.study.pattern.design.singleton;

public class Singleton {

    public String value;
    private static Singleton instance;

    private Singleton() {}

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
