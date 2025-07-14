package smartex;

/**
 * Custom exception InvalidMarksException
 * Thrown when marks <0 or >100.
 */
public class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}
