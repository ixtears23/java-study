package common;

import junseok.snr.study.autodistribution.OrderPass;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
class OrderPassCsvReaderTest {
    private OrderPassCsvReader orderPassCsvReader;

    @BeforeEach
    void setUp() {
        this.orderPassCsvReader = new OrderPassCsvReader();
    }

    @Test
    void toListTest() throws IOException {
        final List<OrderPass> orderPassList = orderPassCsvReader.toList("orderpasshistory/orderpass01.csv");

        orderPassList.forEach(orderPass -> log.info(">>>>> orderPass : {}", orderPass));
    }

}