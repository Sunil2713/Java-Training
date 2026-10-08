package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.training.model.Course;
import com.training.service.CourseService;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/form")
    public String showCourseForm(@RequestParam(required = false) Integer id, Model model) {
        Course course = id == null ? new Course() : courseService.getCourseById(id);
        if (course == null) {
            return "redirect:/courses";
        }
        model.addAttribute("course", course);
        return "course-form";
    }

    @PostMapping("/courses/save")
    public String saveCourse(@ModelAttribute Course course, RedirectAttributes redirectAttributes) {
        boolean isNewCourse = course.getId() == 0;
        courseService.saveCourse(course);
        redirectAttributes.addFlashAttribute("message", isNewCourse ? "Course added." : "Course updated.");
        return "redirect:/courses";
    }

    @PostMapping("/courses/delete")
    public String deleteCourse(@RequestParam int id, RedirectAttributes redirectAttributes) {
        courseService.deleteCourse(id);
        redirectAttributes.addFlashAttribute("message", "Course deleted.");
        return "redirect:/courses";
    }
}
