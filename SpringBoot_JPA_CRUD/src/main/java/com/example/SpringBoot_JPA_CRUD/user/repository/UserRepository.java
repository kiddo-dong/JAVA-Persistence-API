package com.example.SpringBoot_JPA_CRUD.user.repository;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    UserResponseDto findById(Long id);
    List<UserResponseDto> findAll();
    User updateById(Long id);
    void deleteById(Long id);
}