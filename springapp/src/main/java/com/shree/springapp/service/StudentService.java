package com.shree.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.springapp.model.Course;
import com.shree.springapp.model.Student;
import com.shree.springapp.repository.CourseRepository;
import com.shree.springapp.repository.StudentRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();
            student.getCourses().add(course);
            return studentRepository.save(student);
        }
        return null;
    }

    public Set<Course> getStudentCourses(Long studentId) {
        return studentRepository.findById(studentId).map(Student::getCourses).orElse(null);
    }
}
