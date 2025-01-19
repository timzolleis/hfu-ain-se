package service;

import entity.user.User;
import exception.InvalidCredentialsException;
import exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.user.MemoryUserService;
import service.user.UserService;

import static org.junit.jupiter.api.Assertions.*;

class MemoryUserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new MemoryUserService();
    }

    @Test
    void login() {
        final String username = "admin";
        final String password = "admin";
        this.userService.addUser(username, password);
        assertDoesNotThrow(() -> this.userService.login(username, password));
        assertThrows(InvalidCredentialsException.class, () -> this.userService.login(username, "wrongpassword"));
    }

    @Test
    void addUser() {
        final String username = "admin";
        final String password = "admin";
        this.userService.addUser(username, password);
        assertDoesNotThrow(() -> this.userService.getByUsername(username));
    }

    @Test
    void getByUsername() {
        final String username = "admin";
        final String password = "admin";
        this.userService.addUser(username, password);
        final User user = this.userService.getByUsername(username);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertThrows(UserNotFoundException.class, () -> this.userService.getByUsername("wrongusername"));

    }
}