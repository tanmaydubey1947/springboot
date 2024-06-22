package com.springboot.service;

import com.springboot.dao.UserDAO;
import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.entity.UserEntity;
import com.springboot.exception.UserServiceException;
import com.springboot.utility.UserMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

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
