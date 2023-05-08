package common;

import junseok.snr.study.autodistribution.OrderPassHistory;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderPassHistoryCsvReader implements CsvReader<OrderPassHistory> {

    @Override
    public List<OrderPassHistory> mapToList(CSVParser csvParser) {
        final List<OrderPassHistory> orderPassHistoryList = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {

            final String paymentDateTimeString = csvRecord.get(9);
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            final LocalDateTime paymentDateTime = LocalDateTime.parse(paymentDateTimeString, formatter);

            orderPassHistoryList.add(
                    OrderPassHistory.builder()
                            .seqOrderInfo(Integer.parseInt(csvRecord.get(0)))
                            .seqOrderPass(Integer.parseInt(csvRecord.get(1)))
                            .price(Integer.parseInt(csvRecord.get(2)))
                            .salePrice(Integer.parseInt(csvRecord.get(3)))
                            .sumCardAmount(Integer.parseInt(csvRecord.get(4)))
                            .sumCashAmount(Integer.parseInt(csvRecord.get(5)))
                            .sumTransferAmount(Integer.parseInt(csvRecord.get(6)))
                            .paymentAmount(Integer.parseInt(csvRecord.get(7)))
                            .receivables(Integer.parseInt(csvRecord.get(8)))
                            .paymentDatetime(paymentDateTime)
                            .build()
            );
        }

        return orderPassHistoryList;
    }
}
