package junseok.snr.study.business.password;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PasswordStrengthVerifierTest {

    private static PasswordStrengthVerifier passwordStrengthVerifier;

    @BeforeAll
    static void setUp() {
        passwordStrengthVerifier = new PasswordStrengthVerifier();
    }

    @Test
    @DisplayName("password 길이 8자리 미만이면 PasswordLengthException 발생")
    void throwPasswordLengthExceptionThenLessThan8DigitsTest() {
        final String password = "1111111";

        assertThatThrownBy(() -> passwordStrengthVerifier.verifyLength(password))
                .isInstanceOf(PasswordLengthException.class)
                .hasMessage("패스워드는 8자리 이상이어야 합니다.");
    }

    @ParameterizedTest(name = "password가 {arguments}인 경 PasswordLengthException 발생")
    @CsvSource(
            value = {"''", "null"},
            nullValues = "null"
    )
    void nullPasswordThrowPasswordLengthExceptionTest(String password) {
        assertThatThrownBy(() -> passwordStrengthVerifier.verifyBlank(password))
                .isInstanceOf(PasswordLengthException.class);
    }

    @ParameterizedTest(name = "password {arguments} 는 영문과 숫자가 포함되어 있지 않으므로 Exception 발생")
    @CsvSource(
            value = {"aaa", "bbb", "AAA", "!@#", "!A", "33", "3%", "22", "aA", "Zz"}
    )
    void throwExceptionWhenNumberAndEnglishCharacterAreNotIncludedTest(String password) {
        assertThatThrownBy(() -> passwordStrengthVerifier.verifyCharacter(password))
                .isInstanceOf(PasswordCharacterException.class);
    }


    @ParameterizedTest(name = "password {arguments}는 영문과 숫자가 포함되어 있으므로 Exception 발생하지 않음")
    @CsvSource(
            value = {"aaaa3", "bb3bb", "3aaa", "3!@#b", "!AE#3", "Ab33", "003A", "33"}
    )
    void NumberAndEnglishCharacterAreIncludedSuccessTest(String password) {
        passwordStrengthVerifier.verifyCharacter(password);
    }

}
