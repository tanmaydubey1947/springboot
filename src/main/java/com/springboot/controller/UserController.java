package com.springboot.controller;

import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable int userId) {
        UserResponseDTO userResponseDTO = userService.getById(userId);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.addUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.ACCEPTED);
    }
}
