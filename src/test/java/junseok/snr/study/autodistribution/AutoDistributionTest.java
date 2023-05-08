package junseok.snr.study.autodistribution;

import common.OrderPassCsvReader;
import common.OrderPaymentCsvReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class AutoDistributionTest {

    private static OrderPassCsvReader orderPassCsvReader;
    private static OrderPaymentCsvReader orderPaymentCsvReader;
    private static final String ORDER_PATH_URL = "orderpasshistory/orderpass";
    private static final String ORDER_PAYMENT_PATH_URL = "orderpasshistory/orderpayment";


    @BeforeAll
    static void setUp() {
        orderPassCsvReader = new OrderPassCsvReader();
        orderPaymentCsvReader = new OrderPaymentCsvReader();
    }

    @MethodSource()
    @ParameterizedTest
    void nothing(List<OrderPass> orderPassList, List<OrderPayment> orderPaymentList, List<OrderPassHistory> orderPassHistoryList) {
    }


    static Stream<Arguments> orderProvider() throws IOException {
        return Stream.of(
                Arguments.of(
                        orderPassCsvReader.toList(ORDER_PATH_URL + "01"),
                        orderPaymentCsvReader.toList(ORDER_PAYMENT_PATH_URL + "01")
                ),
                Arguments.of(
                        orderPassCsvReader.toList(ORDER_PATH_URL + "02"),
                        orderPaymentCsvReader.toList(ORDER_PAYMENT_PATH_URL + "02")
                ),
                Arguments.of(
                        orderPassCsvReader.toList(ORDER_PATH_URL + "03"),
                        orderPaymentCsvReader.toList(ORDER_PAYMENT_PATH_URL + "03")
                ),
                Arguments.of(
                        orderPassCsvReader.toList(ORDER_PATH_URL + "04"),
                        orderPaymentCsvReader.toList(ORDER_PAYMENT_PATH_URL + "04")
                )
        );
    }


    }