package junseok.snr.study.autodistribution;

import common.OrderPassCsvReader;
import common.OrderPassHistoryCsvReader;
import common.OrderPaymentCsvReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AutoDistributionTest {

    private static OrderPassCsvReader orderPassCsvReader;
    private static OrderPaymentCsvReader orderPaymentCsvReader;
    private static OrderPassHistoryCsvReader orderPassHistoryCsvReader;
    private static final String ORDER_PATH_URL = "orderpasshistory/orderpass";
    private static final String ORDER_PAYMENT_PATH_URL = "orderpasshistory/orderpayment";
    private static final String ORDER_PASS_HISTORY_PATH_URL = "orderpasshistory/orderpasshistory";


    @BeforeAll
    static void setUp() {
        orderPassCsvReader = new OrderPassCsvReader();
        orderPaymentCsvReader = new OrderPaymentCsvReader();
        orderPassHistoryCsvReader = new OrderPassHistoryCsvReader();
    }

    @MethodSource(value = "orderProvider")
    @ParameterizedTest
    void nothing(List<OrderPass> orderPassList, List<OrderPayment> orderPaymentList, List<OrderPassHistory> expectedList) {
        final AutoDistribution autoDistribution = new AutoDistribution();

        final List<OrderPassHistory> actualList = autoDistribution.autoDistribute(orderPassList, orderPaymentList);

        assertThat(actualList).isEqualTo(expectedList);
    }


    static Stream<Arguments> orderProvider() throws IOException {
        return Stream.of(
                getArguments("01.csv")
                , getArguments("02.csv")
        );
    }

    private static Arguments getArguments(String number) throws IOException {
        return Arguments.of(
                orderPassCsvReader.toList(ORDER_PATH_URL + number),
                orderPaymentCsvReader.toList(ORDER_PAYMENT_PATH_URL + number),
                orderPassHistoryCsvReader.toList(ORDER_PASS_HISTORY_PATH_URL + number)
        );
    }

}