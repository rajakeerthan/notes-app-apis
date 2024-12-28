package com.example.notesapp.service;

import com.example.notesapp.dto.UserDto;
import com.example.notesapp.model.Users;
import com.example.notesapp.model.Users;
import com.example.notesapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Users createUser(UserDto userDto){
        Users user=new Users();
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);

    }


    public Users getUserById(UUID id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
