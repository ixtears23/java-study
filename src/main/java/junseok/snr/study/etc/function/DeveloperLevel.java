package junseok.snr.study.etc.function;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Getter
@RequiredArgsConstructor
public enum DeveloperLevel {
    JUNIOR(years -> years <= DeveloperYear.JUNIOR),
    MIDDLE(years -> years <= DeveloperYear.MIDDLE),
    SENIOR(years -> years <= DeveloperYear.SENIOR);

    private final Function<Integer, Boolean> validateFunction;

    public void validateDeveloperYear(int years) {
        if (Boolean.FALSE.equals(validateFunction.apply(years))) throw new DeveloperYearException();
    }
}
