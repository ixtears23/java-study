package junseok.snr.study.java.eight;

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
    }
}
