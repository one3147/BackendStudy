package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {

        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}