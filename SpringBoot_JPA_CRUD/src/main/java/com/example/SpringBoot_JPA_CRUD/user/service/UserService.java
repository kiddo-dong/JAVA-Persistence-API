package com.example.SpringBoot_JPA_CRUD.user.service;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserRequestDto;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    String addUser(UserRequestDto userRequestDto);
    UserResponseDto findById(Long id);
    List<UserResponseDto> findAll();
    String updateById(Long id, UserRequestDto userRequestDto);
    String deleteById(Long id);
}
