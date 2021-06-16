package by.epam.shchemelev.exceptions;

public class ArrayExistencyException extends Exception{
    public ArrayExistencyException() {
        super();
    }

    public ArrayExistencyException(String message) {
        super(message);
    }

    public ArrayExistencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayExistencyException(Throwable cause) {
        super(cause);
    }
}
