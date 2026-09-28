package com.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.dao.UserDao;
import com.training.model.User;
import com.training.util.DBConnection;

public class UserDaoImpl implements UserDao {

    private static final String USER_COLUMNS = "user_id, username, password, full_name, email, role";

    @Override
    public List<User> findAll() throws ClassNotFoundException, SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT " + USER_COLUMNS + " FROM `user`";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(toUser(resultSet));
            }
        }
        return users;
    }

    @Override
    public User findById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT " + USER_COLUMNS + " FROM `user` WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? toUser(resultSet) : null;
            }
        }
    }

    @Override
    public int save(User user) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO `user` (" + USER_COLUMNS + ") VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            setUser(statement, user);
            return statement.executeUpdate();
        }
    }

    @Override
    public int update(User user) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE `user` SET username = ?, password = ?, full_name = ?, email = ?, role = ? "
                + "WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getRole());
            statement.setInt(6, user.getUserId());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(User user) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM `user` WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserId());
            return statement.executeUpdate();
        }
    }

    @Override
    public User isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
        String selectSql = "SELECT * FROM `user` WHERE username = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(selectSql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFullName(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
                user.setRole(resultSet.getString(6));
                return user;
            }
        }
    }

    private User toUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("user_id"), resultSet.getString("username"),
                resultSet.getString("password"), resultSet.getString("full_name"), resultSet.getString("email"),
                resultSet.getString("role"));
    }

    private void setUser(PreparedStatement statement, User user) throws SQLException {
        statement.setInt(1, user.getUserId());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getFullName());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getRole());
    }
}
