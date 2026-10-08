package com.training.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.training.dao.CourseDao;
import com.training.model.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Course> findAll() {
        return hibernateTemplate.loadAll(Course.class);
    }

    @Override
    public Course findById(int id) {
        return hibernateTemplate.get(Course.class, id);
    }

    @Override
    public void save(Course course) {
        hibernateTemplate.saveOrUpdate(course);
    }

    @Override
    public void delete(int id) {
        Course course = findById(id);
        if (course != null) {
            hibernateTemplate.delete(course);
        }
    }
}
