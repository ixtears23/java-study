package junseok.snr.study.business.password;

public class PasswordStrength {

    public boolean verifyLength(String password) {
        if (password == null) throw new PasswordLengthException("Password는 Null일 수 없습니다.");
        return password.length() >= 8;
    }
}
