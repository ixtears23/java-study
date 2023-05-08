package common;

import junseok.snr.study.autodistribution.OrderPayment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
class OrderPaymentCsvReaderTest {
    private CsvReader< OrderPayment> csvReader;

    @BeforeEach
    void setUp() {
        csvReader = new OrderPaymentCsvReader();
    }

    @Test
    void mapToListTest() throws IOException {
        final List<OrderPayment> orderPaymentList = csvReader.toList("orderpasshistory/orderpayment01.csv");
        for (OrderPayment orderPayment : orderPaymentList) {
            log.info(">>>>> orderPayment : {}", orderPayment);
        }
    }

}