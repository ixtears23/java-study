package common;

import junseok.snr.study.autodistribution.OrderPayment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

@Slf4j
class OrderPaymentCsvReaderTest {
    private CsvReader<OrderPayment> csvReader;

    @BeforeEach
    void setUp() {
        csvReader = new OrderPaymentCsvReader();
    }

    @CsvSource(value = { "01", "02"})
    @ParameterizedTest
    void mapToListTest(String fileNumber) throws IOException {
        final List<OrderPayment> orderPaymentList = csvReader.toList("orderpasshistory/orderpayment" + fileNumber + ".csv");
        for (OrderPayment orderPayment : orderPaymentList) {
            log.info(">>>>> orderPayment : {}", orderPayment);
        }
    }

}