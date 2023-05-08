package junseok.snr.study.autodistribution;

import java.util.Arrays;

public enum PaymentType {
    CARD, CASH, TRANSFER;

    public static PaymentType match(String name) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}
