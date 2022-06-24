package junseok.snr.study.business.password;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PasswordTest {

    private static PasswordStrength passwordStrength;

    @BeforeAll
    static void setUp() {
        passwordStrength = new PasswordStrength();
    }

    @Test
    @DisplayName("password 8자리 이상이면 강도 높음")
    void lowPasswordStrengthLengthTest() {
        final String password = "11111111";

        final boolean result = passwordStrength.verifyLength(password);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("password 길이 8자리 미만이면 강도 낮음")
    void highPasswordStrengthLengthTest() {
        final String password = "1111111";

        final boolean result = passwordStrength.verifyLength(password);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("password null인 경우 PasswordLengthException 발생")
    void nullPasswordThrowPasswordLengthExceptionTest() {
        final String password = null;

        assertThatThrownBy(() -> passwordStrength.verifyLength(password))
                .isInstanceOf(PasswordLengthException.class);
    }

}
