package multiUserChat.service;

import multiUserChat.dao.UserDao;
import multiUserChat.domain.User;

import java.util.List;
import java.util.Optional;

public class UserServiceMySql implements UserService {

    private final UserDao userDao;
    private static volatile UserServiceMySql instance;

    private UserServiceMySql() {
        this.userDao = UserDao.getInstance();
    }

    public static UserServiceMySql getInstance() {
        if (instance == null) {
            synchronized (UserServiceMySql.class) {
                if (instance == null) {
                    instance = new UserServiceMySql();
                }
            }
        }
        return instance;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

}
