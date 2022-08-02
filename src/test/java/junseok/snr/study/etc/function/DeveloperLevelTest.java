package junseok.snr.study.etc.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DeveloperLevelTest {
    @Test
    @DisplayName("개발자 경험이 주니어 경력을 초과하는 경우 예외가 발생합니다.")
    void throwsExceptionIfDeveloperExperienceExceedsTheJuniorCareer() {
        final int developerYears = 4;

        assertThatThrownBy(
                () -> DeveloperLevel.JUNIOR.validateDeveloperYear(developerYears)
        ).isInstanceOf(DeveloperYearException.class);
    }
}