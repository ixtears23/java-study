package junseok.snr.study.java.eight.supplier;

public class Lazy {

    private Lazy lazy;

    public Lazy getLazy() {
        if (this.lazy == null) {
            this.lazy = new Lazy();
        }
        return this.lazy;
    }
}
