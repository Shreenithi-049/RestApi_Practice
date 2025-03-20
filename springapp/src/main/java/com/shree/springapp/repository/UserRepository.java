package com.shree.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shree.springapp.model.User;

public interface UserRepository extends JpaRepository<User,Long>
 {


}
