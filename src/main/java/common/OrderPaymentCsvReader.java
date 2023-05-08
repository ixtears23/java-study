package common;

import junseok.snr.study.autodistribution.OrderPayment;
import junseok.snr.study.autodistribution.PaymentType;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderPaymentCsvReader implements CsvReader<OrderPayment> {

    @Override
    public List<OrderPayment> mapToList(CSVParser csvParser) {
        final List<OrderPayment> orderPassList = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            final String paymentDateTimeString = csvRecord.get(4);
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            final LocalDateTime paymentDateTime = LocalDateTime.parse(paymentDateTimeString, formatter);

            orderPassList.add(
                    OrderPayment.builder()
                            .seqOrderInfo(Integer.parseInt(csvRecord.get(0)))
                            .seqOrderPayment(Integer.parseInt(csvRecord.get(1)))
                            .paymentType(PaymentType.match(csvRecord.get(2)))
                            .paymentAmount(Integer.parseInt(csvRecord.get(3)))
                            .paymentDatetime(paymentDateTime)
                            .build()
            );
        }

        return orderPassList;
    }
}
