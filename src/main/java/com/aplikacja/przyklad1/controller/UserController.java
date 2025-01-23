package com.aplikacja.przyklad1.controller;


import com.aplikacja.przyklad1.model.User;
import com.aplikacja.przyklad1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    @PostMapping
        public User createUser(@RequestBody User user) {
            return userRepository.save(user);
        }
}
