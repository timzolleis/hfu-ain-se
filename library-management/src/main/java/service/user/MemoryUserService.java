package service.user;

import entity.user.User;
import entity.user.UserRepository;
import exception.InvalidCredentialsException;

public class MemoryUserService implements UserService {

    private final UserRepository userRepository = new UserRepository();

    @Override
    public void login(final String username, final String password) {
        userRepository.getUserByUsername(username).filter(user -> user.getPassword().equals(password))
                .orElseThrow(InvalidCredentialsException::new);
    }

    @Override
    public void addUser(final String username, final String password) {
        final User userToCreate = new User();
        userToCreate.setUsername(username);
        userToCreate.setPassword(password);
        final User createdUser = this.userRepository.addUser(userToCreate);
        System.out.println("Created user with id: " + createdUser.getId());
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.requireUserByUsername(username);
    }
}
