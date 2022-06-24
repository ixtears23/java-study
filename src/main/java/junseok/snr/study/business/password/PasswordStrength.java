package junseok.snr.study.business.password;

public class PasswordStrength {

    public boolean verifyLength(String password) {
        return password.length() >= 8;
    }
}
