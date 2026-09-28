package com.training.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.training.dao.UserDao;
import com.training.dao.impl.UserDaoImpl;
import com.training.model.User;
import com.training.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int id) throws ClassNotFoundException, SQLException {
        return userDao.findById(id);
    }

    @Override
    public int save(User user) throws ClassNotFoundException, SQLException {
        return userDao.save(user);
    }

    @Override
    public int update(User user) throws ClassNotFoundException, SQLException {
        return userDao.update(user);
    }

    @Override
    public int delete(User user) throws ClassNotFoundException, SQLException {
        return userDao.delete(user);
    }

    @Override
    public User isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
        return userDao.isValidUser(username, password);
    }
}
