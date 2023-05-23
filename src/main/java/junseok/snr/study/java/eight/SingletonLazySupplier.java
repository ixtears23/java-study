package junseok.snr.study.java.eight;

import java.util.function.Supplier;

public class SingletonLazySupplier {
    private Supplier<SingletonLazySupplier> supplier = this::initial;
    private SingletonLazySupplier singletonLazySupplier;

    private SingletonLazySupplier initial() {
        if (this.singletonLazySupplier == null) {
            this.singletonLazySupplier = new SingletonLazySupplier();
        }
        return singletonLazySupplier;
    }

    public SingletonLazySupplier getInstance() {
        return supplier.get();
    }
}
