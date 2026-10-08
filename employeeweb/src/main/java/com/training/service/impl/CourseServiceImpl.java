package com.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.dao.CourseDao;
import com.training.model.Course;
import com.training.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course getCourseById(int id) {
        return courseDao.findById(id);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseDao.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        courseDao.delete(id);
    }
}
