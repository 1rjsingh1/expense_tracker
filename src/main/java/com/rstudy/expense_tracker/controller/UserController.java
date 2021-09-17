package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "User added Successfully";
    }
}
