package service;

import entity.User;

import java.util.Optional;

public interface UserService {
    void login(final String username, final String password);
    void addUser(final String username, final String password);

    User getByUsername(String username);


}
