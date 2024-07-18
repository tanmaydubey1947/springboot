package com.springboot.utility;

import com.springboot.dto.UserRequestDTO;
import com.springboot.dto.UserResponseDTO;
import com.springboot.entity.UserEntity;

public class UserMapperUtility {


    public static UserEntity userDTOtoEntity(UserRequestDTO requestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(requestDTO.getName());
        userEntity.setDuration(requestDTO.getDuration());
        userEntity.setType(requestDTO.getType());
        userEntity.setFees(requestDTO.getFees());
        userEntity.setStartDate(requestDTO.getStartDate());
        return userEntity;

    }

    public static UserResponseDTO userEntityToDTO(UserEntity userEntity) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(userEntity.getName());
        userResponseDTO.setDuration(userEntity.getDuration());
        userResponseDTO.setType(userEntity.getType());
        userResponseDTO.setFees(userEntity.getFees());
        userResponseDTO.setStartDate(userEntity.getStartDate());
        return userResponseDTO;
    }

}
