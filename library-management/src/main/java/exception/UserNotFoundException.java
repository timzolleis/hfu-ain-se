package exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(final String username) {
        super("User with username " + username + " not found");
    }
}
