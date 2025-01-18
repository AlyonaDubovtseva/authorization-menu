package lab17authorization_menu;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        super("Ошибка! Введен нерпавильный логин.");
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
