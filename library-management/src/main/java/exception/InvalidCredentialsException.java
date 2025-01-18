package exception;

public class InvalidCredentialsException extends IllegalStateException {
    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
}
