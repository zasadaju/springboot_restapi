package com.aplikacja.przyklad1.controller;


import com.aplikacja.przyklad1.model.User;
import com.aplikacja.przyklad1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    Widok z tabelą użytkowników
    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userRepository.findAll());
        return "users";
    }
//    Obsługa formularza
    @PostMapping
    public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
        User user = new User(name, email);
        userRepository.save(user);
        return "redirect:/users";
    }
}

//    @GetMapping
//        public List<User> getAllUsers() {
//            return userRepository.findAll();
//        }
//    @PostMapping
//        public User createUser(@RequestBody User user) {
//            return userRepository.save(user);
//        }
