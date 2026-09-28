package com.training.service;

import java.sql.SQLException;
import java.util.List;

import com.training.model.User;

public interface UserService {

    List<User> getAllUsers() throws ClassNotFoundException, SQLException;

    User getUserById(int id) throws ClassNotFoundException, SQLException;

    int save(User user) throws ClassNotFoundException, SQLException;

    int update(User user) throws ClassNotFoundException, SQLException;

    int delete(User user) throws ClassNotFoundException, SQLException;

    User isValidUser(String username, String password) throws ClassNotFoundException, SQLException;
}
