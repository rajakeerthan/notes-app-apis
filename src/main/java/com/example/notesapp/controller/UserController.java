package com.example.notesapp.controller;

import com.example.notesapp.dto.UserDto;
import com.example.notesapp.model.Users;
import com.example.notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    //TODO: convert users to UserDto
    @PostMapping("/create-user")
    public ResponseEntity<Users> createUser(@RequestBody UserDto userDto) {
        Users createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable UUID id) {
        Users user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
