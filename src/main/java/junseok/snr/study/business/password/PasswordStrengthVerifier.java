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
        int a = 0;
        int b = 0;

        for (int i = 0; i < password.length(); i++) {
            final int c = password.charAt(i);

            if (a == 0) {
                if ((c >= 65 && c <= 90) ||
                        (c >= 97 && c <= 122)) {
                    a++;
                }
            }

            if (b == 0) {
                if (c >= 48 && c <= 57) {
                    b++;
                }
            }

            if (a > 0 && b > 0) {
                break;
            }
        }

        if (a == 0 || b == 0) {
            throw new PasswordCharacterException("패스워드는 영문과 숫자를 포함해야 합니다.");
        }
    }

}
