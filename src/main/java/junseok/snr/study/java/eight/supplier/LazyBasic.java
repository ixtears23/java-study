package junseok.snr.study.java.eight.supplier;

public class LazyBasic {
    private static class LazyHolder {
        private static final LazyBasic INSTANCE = new LazyBasic();
    }

    public static LazyBasic getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void print() {
        System.out.println(">>>>>");
    }
}
