package junseok.snr.study.java.eight;

public class Lazy {

    private Lazy lazy;

    public Lazy getLazy() {
        if (this.lazy == null) {
            this.lazy = new Lazy();
        }
        return new Lazy();
    }
}
