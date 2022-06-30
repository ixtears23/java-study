package junseok.snr.study.business.password;

import java.util.Locale;
import java.util.stream.Stream;

public class PasswordStrengthVerifier {

    public void verifyBlank(String password) {
        if (password == null || password.isEmpty()) throw new PasswordLengthException("Password 는 비어있을 수 없습니다.");
    }

    public void verifyLength(String password) {
        if (password.length() < 8) throw new PasswordLengthException("패스워드는 8자리 이상이어야 합니다.");
    }

    public static void main(String[] args) {

        final String str = "azAZ09";
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            System.out.println(ascii);
        }
    }

    public void verifyCharacter(String password) {
        // 영문과 숫자를 표현하는지 확인
        // 소문자 대문자 상관없이 영문자 + 숫자 여야만 통과!!

        for (int i = 0; i < password.length(); i++) {
            final int c = password.charAt(i);

            if (c >= 97 && c <= 122) {
                final String currentCharacter = password.substring(i - 1, i);
            }

            if (!(c >= 65 && c <= 90) &&
                    !(c >= 48 && c <= 57) &&
                    !(c >= 97 && c <= 122)) {
                throw new PasswordCharacterException("패스워드는 영문과 숫자를 포함해야 합니다.");
            }
        }
    }

}
