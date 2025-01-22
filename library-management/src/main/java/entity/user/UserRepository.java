package entity.user;

import exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Optional;

public class UserRepository {

    private final HashMap<Integer, User> users = new HashMap<>();

    public final User addUser(final User user) {
        final int id = users.size() + 1;
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public final Optional<User> getUser(final int id) {
        return Optional.ofNullable(users.get(id));
    }

    public final Optional<User> getUserByUsername(final String username) {
        return users.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public final User requireUserByUsername(final String username) {
        return users.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new UserNotFoundException(username));
    }
}
