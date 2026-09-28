package com.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.training.model.User;

public interface UserDao {

    List<User> findAll() throws ClassNotFoundException, SQLException;

    User findById(int id) throws ClassNotFoundException, SQLException;

    int save(User user) throws ClassNotFoundException, SQLException;

    int update(User user) throws ClassNotFoundException, SQLException;

    int delete(User user) throws ClassNotFoundException, SQLException;

    User isValidUser(String username, String password) throws ClassNotFoundException, SQLException;
}
