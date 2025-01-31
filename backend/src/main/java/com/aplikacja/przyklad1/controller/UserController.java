package com.aplikacja.przyklad1.controller;


import com.aplikacja.przyklad1.model.User;
import com.aplikacja.przyklad1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    Widok z tabelą użytkowników
    @GetMapping
    public String showAllUsers(Model model) {
        System.out.println("Metoda została wywołana");
        model.addAttribute("allUsers", userRepository.findAll());
        return "users";
    }
//    Dodawanie użytkownika
    @PostMapping
    public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
        User user = new User(name, email);
        userRepository.save(user);
        return "redirect:/users";
    }
//    Usuwanie użytkownika
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
//    Edycja użytkownika (formularz)
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable String id, Model model) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> model.addAttribute("user",u));
        return  "edit-user";
    }
//    Zapis edytowane użytkownika
    @PostMapping("/edit")
    public String updateUser(@RequestParam String id, @RequestParam String name, @RequestParam String email) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
        }
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
