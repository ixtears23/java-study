package common;

import junseok.snr.study.autodistribution.OrderPassHistory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

@Slf4j
class OrderPassHistoryCsvReaderTest {
    private CsvReader<OrderPassHistory> csvReader;

    @BeforeEach
    void setUp() {
        csvReader = new OrderPassHistoryCsvReader();
    }

    @CsvSource(value = { "01", "02"})
    @ParameterizedTest
    void mapToListTest(String fileNumber) throws IOException {
        final List<OrderPassHistory> orderPassHistoryList = csvReader.toList("orderpasshistory/orderpasshistory" + fileNumber + ".csv");
        for (OrderPassHistory orderPassHistory : orderPassHistoryList) {
            log.info(">>>>> orderPassHistory : {}", orderPassHistory);
        }
    }

}