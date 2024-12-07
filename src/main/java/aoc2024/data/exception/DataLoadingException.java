package aoc2024.data.exception;

public class DataLoadingException extends RuntimeException {
    public DataLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
