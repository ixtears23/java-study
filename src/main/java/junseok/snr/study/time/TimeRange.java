package junseok.snr.study.time;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TimeRange {
    String startTime;
    String endTime;
}
