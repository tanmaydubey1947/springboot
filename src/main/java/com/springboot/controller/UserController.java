package com.springboot.controller;

import com.springboot.dto.ServiceResponse;
import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ServiceResponse<UserResponseDTO> getById(@PathVariable int userId) {
        UserResponseDTO userResponseDTO = userService.getById(userId);
        return new ServiceResponse<>(HttpStatus.ACCEPTED, userResponseDTO);
    }

    @PostMapping
    public ServiceResponse<UserResponseDTO> addUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.addUser(userRequestDTO);
        return new ServiceResponse<>(HttpStatus.ACCEPTED, userResponseDTO);
    }
}
