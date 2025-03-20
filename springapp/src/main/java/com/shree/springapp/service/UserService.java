package com.shree.springapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shree.springapp.model.Address;
import com.shree.springapp.model.User;
import com.shree.springapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    // public User savUser(User user)
    // {
    //     return userRepository.save(user);
    // }
    public User saveUser(User user) {
        for (Address address : user.getAddress()) {
            address.setUser(user); // Ensure bidirectional link
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }
    public User updateUser(long id,User newUser)
    {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setId(newUser.getId());
            existingUser.setName(newUser.getName());
            existingUser.setAddress(newUser.getAddress());
            return userRepository.save(existingUser);

        }).orElseThrow(() -> new RuntimeException("Course not found with id"+id));
    }


}
