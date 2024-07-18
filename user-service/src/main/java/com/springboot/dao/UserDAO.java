package com.springboot.dao;

import com.springboot.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<UserEntity, Integer> {
}
