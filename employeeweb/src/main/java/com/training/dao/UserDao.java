package com.training.dao;

import java.util.List;

import com.training.model.User;

public interface UserDao {


	User isValidUser(String email, String password);
}