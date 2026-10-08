package com.training.dao.impl;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.dao.UserDao;
import com.training.model.User;

@Repository
public class UserDaoImpl implements UserDao {
@Autowired
private HibernateTemplate hibernateTemplate;

@Override
@Transactional
public User isValidUser(String email, String password) {
return hibernateTemplate.execute(session -> {
    Query<User> query = session.createQuery(
            "from User where email = :email and password = :password", User.class);
    query.setParameter("email", email);
    query.setParameter("password", password);
    return query.uniqueResult();
});
}

}
