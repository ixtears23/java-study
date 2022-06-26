package junseok.snr.study.business.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JavaAndLibTest {

    @Test
    @DisplayName("빈문자열에 대해 String.isEmpty() 는 True")
    void stringDotIsEmptyEqualsEmptyStringTest() {
        final String emptyString = "";
        assertThat(emptyString.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("null에 대해 String.isEmpty() 는 NPE 발생")
    void throwNPEWhenStringDotIsEmptyForNull() {
        final String emptyString = null;
        assertThatThrownBy(() -> emptyString.isEmpty())
                .isInstanceOf(NullPointerException.class);
    }
}
