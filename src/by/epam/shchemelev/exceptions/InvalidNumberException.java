package by.epam.shchemelev.exceptions;

public class InvalidNumberException extends Throwable {
    public InvalidNumberException() {
        super();
    }

    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }
}
