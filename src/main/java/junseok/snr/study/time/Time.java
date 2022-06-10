package junseok.snr.study.time;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Time {
    String hour;
    String minute;
}
