package common;

import junseok.snr.study.autodistribution.OrderPass;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OrderPassCsvReaderTest {
    private OrderPassCsvReader orderPassCsvReader;

    @BeforeEach
    void setUp() {
        this.orderPassCsvReader = new OrderPassCsvReader();
    }


    @Test
    void nothing() throws IOException {
        final List<OrderPass> orderPass = orderPassCsvReader.toList("orderpass01.csv");
        log.info(">>>>> orderPass : {}", orderPass);
    }

}