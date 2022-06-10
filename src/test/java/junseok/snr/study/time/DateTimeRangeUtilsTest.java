package junseok.snr.study.time;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DateTimeRangeUtilsTest {

    private static DateTimeUtils dateTimeUtils;

    @BeforeAll
    static void setUp() {
        dateTimeUtils = new DateTimeUtils();
    }

    @Test
    void nothing() {

        final TimeRange time = TimeRange.builder()
                .startTime("08:00")
                .endTime("10:00")
                .build();

        final int timeUnit = 10;

        final List<Time> times = dateTimeUtils.makeTimeUnitList(time, timeUnit);

        assertThat(times).hasSize(12);
    }
}
