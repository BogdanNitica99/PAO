package multiUserChat.dao;

import multiUserChat.domain.User;
import multiUserChat.util.ChatDatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private static final String INSERT_SQL = "INSERT INTO user VALUES (?,?)";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM user WHERE username=?";
    private final Connection connection;
    private static volatile UserDao instance;

    private UserDao() {
        this.connection = ChatDatabaseConnection.getChatDatabaseConnection();
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // the iterator is like a cursor placed before first row
            while (rs.next()) { // returns true if a next row exists and moves to that row
                User user = UserRowMapper.mapRow(rs);
                users.add(user);
                System.out.println(user);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_SQL);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = UserRowMapper.mapRow(rs);
                return Optional.of(user);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }

    static class UserRowMapper {
        public static User mapRow(ResultSet rs) throws SQLException {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            return new User(id, username, password);
        }
    }

}
