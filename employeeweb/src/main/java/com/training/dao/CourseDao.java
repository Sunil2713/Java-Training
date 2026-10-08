package com.training.dao;

import java.util.List;

import com.training.model.Course;

public interface CourseDao {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void delete(int id);
}
