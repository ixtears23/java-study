package junseok.snr.study.etc.function;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Developer {
    DeveloperLevel developerLevel;
    int years;
}
