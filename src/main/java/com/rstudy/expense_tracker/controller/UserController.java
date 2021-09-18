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
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public String addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return "User added Successfully";
    }

    @GetMapping("/{id}")
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

    @PutMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id,@RequestBody UserDto userDto)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't exist: "+id
                ));
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.map(userDto, user);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Employee Doesn't exist: "+id
                ));
        userRepository.delete(user);
        return ResponseEntity.ok("User Deleted");
    }

}
