package lab17authorization_menu;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Ошибка! Введен неправильный пароль.");
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
