package junseok.snr.study.java.api.supplier;

import java.util.function.Supplier;

public class LazySupplier {
    private Supplier<LazySupplier> lazySupplier = () -> new LazySupplier();

    public LazySupplier getLazySupplier() {
        return lazySupplier.get();
    }

}
