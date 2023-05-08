package common;

import junseok.snr.study.autodistribution.OrderPass;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;


public class OrderPassCsvReader implements CsvReader<OrderPass> {

    @Override
    public List<OrderPass> mapToList(CSVParser csvParser) {
        final List<OrderPass> orderPassList = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            orderPassList.add(
                    OrderPass.builder()
                            .seqOrderInfo(Integer.parseInt(csvRecord.get(0)))
                            .seqOrderPass(Integer.parseInt(csvRecord.get(1)))
                            .price(Integer.parseInt(csvRecord.get(2)))
                            .salePrice(Integer.parseInt(csvRecord.get(3)))
                            .paymentAmount(Integer.parseInt(csvRecord.get(4)))
                            .receivables(Integer.parseInt(csvRecord.get(5)))
                            .build()
            );
        }

        return orderPassList;
    }
}
