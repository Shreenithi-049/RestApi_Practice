package com.shree.springapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shree.springapp.model.Course;
import com.shree.springapp.model.Student;
import com.shree.springapp.service.StudentService;

public class StudentController {
  @Autowired
    private StudentService studentService;

    @PostMapping("/{studentId}/enroll/{courseId}")
    public Student enrollStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.enrollStudentInCourse(studentId, courseId);
    }

    @GetMapping("/{studentId}/courses")
    public Set<Course> getCourses(@PathVariable Long studentId) {
        return studentService.getStudentCourses(studentId);
    }
}
