package junseok.snr.study.business.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JavaAndLibTest {

    @Test
    @DisplayName("String isEmpty 가 emptyString을 테스트하는지 확인")
    void stringDotIsEmptyEqualsEmptyStringTest() {
        final String emptyString = "";
        assertThat(emptyString.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("String isEmpty 가 emptyString을 테스트하는지 확인")
    void throwNPEWhenStringDotIsEmptyForNull() {
        final String emptyString = null;
        assertThatThrownBy(() -> emptyString.isEmpty())
                .isInstanceOf(NullPointerException.class);
    }
}
