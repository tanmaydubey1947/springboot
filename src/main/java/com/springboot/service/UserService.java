package com.springboot.service;

import com.springboot.dao.UserDAO;
import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.entity.UserEntity;
import com.springboot.exception.UserServiceException;
import com.springboot.utility.UserMapperUtility;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"dev","stg","prod"})
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Value("${application.message}")
    private String envMessage;

    @PostConstruct
    public void init() {
        System.out.println("******************* " + envMessage);
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        UserEntity userEntity = UserMapperUtility.userDTOtoEntity(userRequestDTO);
        UserEntity savedEntity = userDAO.save(userEntity);
        return UserMapperUtility.userEntityToDTO(savedEntity);
    }

    public UserResponseDTO getById(int id) {
        UserEntity userEntity = userDAO.findById(id)
                .orElseThrow(() -> new UserServiceException(id + " is not a valid course id..."));
        return UserMapperUtility.userEntityToDTO(userEntity);
    }
}
