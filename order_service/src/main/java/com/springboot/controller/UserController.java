package com.springboot.controller;

import com.springboot.dto.ServiceResponse;
import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Operation(summary = "Get the user detail by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Id Found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "User Not Found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDTO.class))
                    })
    })
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

    @GetMapping("/log")
    public String log() {
        logger.trace("Trace Level Log");
        logger.debug("Debug Level Log");
        logger.info("Info Level Log");
        logger.warn("Warn Level Log");
        logger.error("Error Level Log");
        return "Log printed in console...";
    }
}
