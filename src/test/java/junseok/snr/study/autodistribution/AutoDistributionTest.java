package junseok.snr.study.autodistribution;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class AutoDistributionTest {

    @Test
    void nothing() {
    }

    private static List<OrderPass> createOrderPass01() {
        return Arrays.asList(
                new OrderPass(1, 1, 30_000, 30_000, 30_000, 0),
                new OrderPass(1, 2, 17_000, 17_000, 17_000, 0),
                new OrderPass(1, 3, 15_000, 15_000, 7_000, 8_000),
                new OrderPass(1, 4, 24_000, 24_000, 0, 24_000)
        );
    }

    private static List<OrderPayment> createOrderPayment01() {
        return Arrays.asList(
                new OrderPayment(1, 1, PaymentType.CARD, 12_000, LocalDateTime.of(2023, 3, 3, 10, 30)),
                new OrderPayment(1, 2, PaymentType.TRANSFER, 11_000, LocalDateTime.of(2023, 4, 3, 10, 30)),
                new OrderPayment(1, 3, PaymentType.CASH, 31_000, LocalDateTime.of(2023, 5, 3, 10, 30))
        );
    }

    private static List<OrderPass> createOrderPass02() {
        return Arrays.asList(
                new OrderPass(1, 1, 30_000, 30_000, 25_000, 5_000),
                new OrderPass(1, 2, 17_000, 17_000, 10_000, 7_000),
                new OrderPass(1, 3, 15_000, 15_000, 3_000, 12_000),
                new OrderPass(1, 4, 24_000, 24_000, 20_000, 4_000)
        );
    }

    private static List<OrderPayment> createOrderPayment02() {
        return Arrays.asList(
                new OrderPayment(1, 1, PaymentType.CARD, 8_000, LocalDateTime.of(2023, 3, 3, 10, 30)),
                new OrderPayment(1, 2, PaymentType.TRANSFER, 23_000, LocalDateTime.of(2023, 4, 3, 10, 30)),
                new OrderPayment(1, 3, PaymentType.CASH, 27_000, LocalDateTime.of(2023, 5, 3, 10, 30))
        );
    }

    private static List<OrderPass> createOrderPass03() {
        return Arrays.asList(
                new OrderPass(1, 1, 30_000, 30_000, 25_000, 5_000),
                new OrderPass(1, 2, 17_000, 17_000, 0, 17_000),
                new OrderPass(1, 3, 15_000, 15_000, 3_000, 12_000),
                new OrderPass(1, 4, 24_000, 24_000, 0, 24_000)
        );
    }

    private static List<OrderPayment> createOrderPayment03() {
        return Arrays.asList(
                new OrderPayment(1, 1, PaymentType.CARD, 8_000, LocalDateTime.of(2023, 3, 3, 10, 30)),
                new OrderPayment(1, 2, PaymentType.TRANSFER, 11_000, LocalDateTime.of(2023, 4, 3, 10, 30)),
                new OrderPayment(1, 3, PaymentType.CASH, 9_000, LocalDateTime.of(2023, 5, 3, 10, 30))
        );
    }

    private static List<OrderPass> createOrderPass04() {
        return Arrays.asList(
                new OrderPass(1, 1, 30_000, 30_000, 25_000, 5_000),
                new OrderPass(1, 2, 17_000, 17_000, 10_000, 7_000),
                new OrderPass(1, 3, 15_000, 15_000, 15_000, 0),
                new OrderPass(1, 4, 24_000, 24_000, 24_000, 0)
        );
    }

    private static List<OrderPayment> createOrderPayment04() {
        return Arrays.asList(
                new OrderPayment(1, 1, PaymentType.CARD, 8_000, LocalDateTime.of(2023, 3, 3, 10, 30)),
                new OrderPayment(1, 2, PaymentType.TRANSFER, 11_000, LocalDateTime.of(2023, 4, 3, 10, 30)),
                new OrderPayment(1, 3, PaymentType.CASH, 9_000, LocalDateTime.of(2023, 5, 3, 10, 30))
        );
    }


}