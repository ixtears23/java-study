package common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public interface CsvReader<T> {

    List<T> mapToList(CSVParser csvParser);

    default List<T> toList(final String filePath) throws IOException {
        ClassLoader classLoader = CsvReader.class.getClassLoader();

        try (
                InputStream inputStream = classLoader.getResourceAsStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.Builder.create()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build())
        ) {
            return mapToList(csvParser);
        }
    }

}
