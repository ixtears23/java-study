package junseok.snr.study.business.password;

public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException(String message) {
        super(message);
    }
}
