package com.training.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.training.dao.UserDao;
import com.training.model.User;
import com.training.service.UserService;
 
@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
UserDao userDao;
 
@Override
public User isValidUser(String email, String password) {
return userDao.isValidUser(email, password);
}
 
}