package com.shree.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.springapp.model.User;
import com.shree.springapp.service.UserService;

@RestController
@RequestMapping("/USERS")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User creatUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/getbyid/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

     @PutMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable long id,@RequestBody User newUser)
    {
        try{
            return new ResponseEntity<>(userService.updateUser(id,newUser),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return "User deleted Successfully";
    }


}
