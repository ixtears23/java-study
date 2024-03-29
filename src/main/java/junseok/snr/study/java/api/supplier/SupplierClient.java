package junseok.snr.study.java.api.supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SupplierClient {
    private final RandomSupplier randomSupplier;
    private final StringSupplier stringSupplier;

    public SupplierClient() {
        this.randomSupplier = new RandomSupplier();
        this.stringSupplier = new StringSupplier();
    }

    public static void main(String[] args) {
        final SupplierClient supplierClient = new SupplierClient();

        log.info(">>> toString : {}", supplierClient.stringSupplier.toString("Hi, Junseok"));
        log.info(">>> toRandom : {}", supplierClient.randomSupplier.toRandom());

        final Lazy lazy = new Lazy();
        log.info("first call - lazy : {}", lazy.getLazy());
        log.info("second call - lazy : {}", lazy.getLazy());
        log.info("third call - lazy : {}", lazy.getLazy());

        final LazySupplier lazySupplier = new LazySupplier();
        log.info("first call - lazySupplier : {}", lazySupplier.getLazySupplier());
        log.info("second call - lazySupplier : {}", lazySupplier.getLazySupplier());
        log.info("third call - lazySupplier : {}", lazySupplier.getLazySupplier());

        final SingletonLazySupplier singletonLazySupplier = new SingletonLazySupplier();
        log.info("first call - lazySupplier : {}", singletonLazySupplier.getInstance());
        log.info("second call - lazySupplier : {}", singletonLazySupplier.getInstance());
        log.info("third call - lazySupplier : {}", singletonLazySupplier.getInstance());

        log.info("first call - LazyBasic : {}", LazyBasic.getInstance());
        log.info("second call - LazyBasic : {}", LazyBasic.getInstance());
        log.info("third call - LazyBasic : {}", LazyBasic.getInstance());
    }
}
