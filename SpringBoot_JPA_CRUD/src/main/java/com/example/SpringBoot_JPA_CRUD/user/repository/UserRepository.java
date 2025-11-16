package com.example.SpringBoot_JPA_CRUD.user.repository;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;

public interface UserRepository {
    void addUser(User user);
    UserResponseDto findUser(Long id);

}