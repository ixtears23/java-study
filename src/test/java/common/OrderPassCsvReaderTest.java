package common;

import junseok.snr.study.autodistribution.OrderPass;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

@Slf4j
class OrderPassCsvReaderTest {
    private OrderPassCsvReader orderPassCsvReader;

    @BeforeEach
    void setUp() {
        this.orderPassCsvReader = new OrderPassCsvReader();
    }

    @CsvSource(value = { "01", "02"})
    @ParameterizedTest
    void toListTest(String fileNumber) throws IOException {
        final List<OrderPass> orderPassList = orderPassCsvReader.toList("orderpasshistory/orderpass" + fileNumber + ".csv");

        orderPassList.forEach(orderPass -> log.info(">>>>> orderPass : {}", orderPass));
    }

}