package junseok.snr.study.business.password;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PasswordStrengthVerifierTest {

    private static PasswordStrengthVerifier passwordStrengthVerifier;

    @BeforeAll
    static void setUp() {
        passwordStrengthVerifier = new PasswordStrengthVerifier();
    }

    @Test
    @DisplayName("password 8자리 이상이면 강도 높음")
    void lowPasswordStrengthLengthTest() {
        final String password = "11111111";

        final boolean result = passwordStrengthVerifier.verifyLength(password);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("password 길이 8자리 미만이면 강도 낮음")
    void highPasswordStrengthLengthTest() {
        final String password = "1111111";

        final boolean result = passwordStrengthVerifier.verifyLength(password);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("password null인 경우 PasswordLengthException 발생")
    void nullPasswordThrowPasswordLengthExceptionTest() {
        final String password = null;

        assertThatThrownBy(() -> passwordStrengthVerifier.verifyLength(password))
                .isInstanceOf(PasswordLengthException.class);
    }

}
