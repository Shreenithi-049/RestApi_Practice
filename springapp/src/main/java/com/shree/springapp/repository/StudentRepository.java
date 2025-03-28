package com.shree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shree.springapp.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
