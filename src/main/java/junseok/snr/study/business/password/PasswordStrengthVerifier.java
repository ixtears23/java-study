package junseok.snr.study.business.password;

public class PasswordStrengthVerifier {

    public void verifyBlank(String password) {
        if (password == null || password.isEmpty()) throw new PasswordLengthException("Password 는 비어있을 수 없습니다.");
    }

    public void verifyLength(String password) {
        if (password.length() < 8) throw new PasswordLengthException("패스워드는 8자리 이상이어야 합니다.");
    }
}
