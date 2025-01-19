package exception;

public class LibraryItemNotFoundException extends RuntimeException {
    public LibraryItemNotFoundException(String message) {
        super(message);
    }
}
