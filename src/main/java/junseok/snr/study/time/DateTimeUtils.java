package junseok.snr.study.time;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DateTimeUtils {

    public List<Time> makeTimeUnitList(TimeRange time, int timeUnit) {

        List<Time> timeList = new ArrayList<>();

        final String start = time.getStartTime();
        final String end = time.getEndTime();

        final LocalTime localTimeStart = LocalTime.of(
                Integer.parseInt(start.substring(0, 2)),
                Integer.parseInt(start.substring(3, 5))
        );
        final LocalTime endTime = LocalTime.of(
                Integer.parseInt(end.substring(0, 2)),
                Integer.parseInt(end.substring(3, 5))
        );
        LocalTime startPlusTimeUnit = localTimeStart;
        while (startPlusTimeUnit.isBefore(endTime)) {
            startPlusTimeUnit = startPlusTimeUnit.plusMinutes(timeUnit);

            timeList.add(
                    Time.builder()
                            .hour(StringUtils.leftPad(String.valueOf(startPlusTimeUnit.getHour()), 2, "0"))
                            .minute(StringUtils.leftPad(String.valueOf(startPlusTimeUnit.getMinute()), 2, "0"))
                            .build()
            );
        }

        return timeList;
    }
}
