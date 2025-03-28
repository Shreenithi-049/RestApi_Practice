package com.shree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shree.springapp.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

}
