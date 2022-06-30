package junseok.snr.study.business.password;

public class PasswordStrengthVerifier {

    public void verifyBlank(String password) {
        if (password == null || password.isEmpty()) throw new PasswordLengthException("Password 는 비어있을 수 없습니다.");
    }

    public void verifyLength(String password) {
        if (password.length() < 8) throw new PasswordLengthException("패스워드는 8자리 이상이어야 합니다.");
    }

    public void verifyCharacter(String password) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < password.length(); i++) {
            final int c = password.charAt(i);

            if (isNotApplicable(a) && isEnglishLetters(c)) {
                a++;
            }

            if (isNotApplicable(b) && isNumber(c)) {
                b++;
            }

            if (a > 0 && b > 0) {
                break;
            }
        }

        if (a == 0 || b == 0) {
            throw new PasswordCharacterException("패스워드는 영문과 숫자를 포함해야 합니다.");
        }
    }

    private boolean isNotApplicable(int a) {
        return a == 0;
    }

    private boolean isNumber(int character) {
        return character >= 48 && character <= 57;
    }

    private boolean isEnglishLetters(int character) {
        return (character >= 65 && character <= 90) ||
                (character >= 97 && character <= 122);
    }

}
