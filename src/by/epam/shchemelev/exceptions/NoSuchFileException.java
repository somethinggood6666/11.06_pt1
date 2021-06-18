package by.epam.shchemelev.exceptions;

public class NoSuchFileException extends Exception{
    public NoSuchFileException() {
        super();
    }

    public NoSuchFileException(String message) {
        super(message);
    }

    public NoSuchFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFileException(Throwable cause) {
        super(cause);
    }
}
