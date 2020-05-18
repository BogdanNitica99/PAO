package multiUserChat.service;

import multiUserChat.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);

    void updateUser(User user);

    void addUser(User user);

    void removeUser(User user);

}
