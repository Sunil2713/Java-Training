package com.training.service;

import java.util.List;

import com.training.model.Course;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(int id);

    void saveCourse(Course course);

    void deleteCourse(int id);
}
