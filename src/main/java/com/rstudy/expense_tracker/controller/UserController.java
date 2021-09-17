package com.rstudy.expense_tracker.controller;

import com.rstudy.expense_tracker.dto.UserDto;
import com.rstudy.expense_tracker.exception.ResourceNotFoundException;
import com.rstudy.expense_tracker.model.User;
import com.rstudy.expense_tracker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") String id)
    {
        User user=userRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException(
            "Employee Doesn't exist: "+id
    ));
        ModelMapper modelMapper = new ModelMapper();

        UserDto userDto=modelMapper.map(user, UserDto.class);
//        userDto.setEmail(user.getEmail());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setPhone(user.getPhone());
//        userDto.setId(user.getId());
        return ResponseEntity.ok(userDto);
    }
}
