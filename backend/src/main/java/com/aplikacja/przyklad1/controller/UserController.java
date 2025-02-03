package com.aplikacja.przyklad1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.aplikacja.przyklad1.model.User;
import com.aplikacja.przyklad1.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;
// @Controller - zwraca stringi
// @Controller 
// @RestController zwraca JSON
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //Pobieranie wszystkich użytkowników SPA
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll;
    }
    // Widok z tabelą użytkowników MPA
    // @GetMapping
    // public String showAllUsers(Model model) {
    //     System.out.println("Metoda została wywołana");
    //     model.addAttribute("allUsers", userRepository.findAll());
    //     return "users";
    // }
    // Dodawanie nowego użytkownika SPA
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    // Dodawanie użytkownika MPA
    // @PostMapping
    // public String addUser(@RequestParam String name, @RequestParam String email, Model model) {
    //     User user = new User(name, email);
    //     userRepository.save(user);
    //     return "redirect:/users";
    // }
    // Usuwanie użytkownika SPA
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
    //Usuwanie użytkownika MPA
    // @PostMapping("/delete/{id}")
    // public String deleteUser(@PathVariable String id) {
    //     userRepository.deleteById(id);
    //     return "redirect:/users";
    // }
    // Edycja użytkownika SPA
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElse(null);
    }
    //Edycja użytkownika (formularz) MPA
    // @GetMapping("/edit/{id}")
    // public String editUserForm(@PathVariable String id, Model model) {
    //     Optional<User> user = userRepository.findById(id);
    //     user.ifPresent(u -> model.addAttribute("user",u));
    //     return  "edit-user";
    // }
    //Zapis użytkownika SPA
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Strind id, @RequestBody User user) {
        return userRepository.findById(id)
        .map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }).orElseGet(() -> {
            user.setId(id);
            return userRepository.save(user);
        });
    }
}
    //Zapis edytowane użytkownika MPA
    // @PostMapping("/edit")
    // public String updateUser(@RequestParam String id, @RequestParam String name, @RequestParam String email) {
    //     Optional<User> existingUser = userRepository.findById(id);
    //     if (existingUser.isPresent()) {
    //         User user = existingUser.get();
    //         user.setName(name);
    //         user.setEmail(email);
    //         userRepository.save(user);
    //     }
    //     return "redirect:/users";
    // }

//    @GetMapping
//        public List<User> getAllUsers() {
//            return userRepository.findAll();
//        }
//    @PostMapping
//        public User createUser(@RequestBody User user) {
//            return userRepository.save(user);
//        }
