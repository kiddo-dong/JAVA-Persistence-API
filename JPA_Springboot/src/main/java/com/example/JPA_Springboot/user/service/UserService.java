package com.example.JPA_Springboot.user.service;

import com.example.JPA_Springboot.user.dto.UserRequestDto;
import com.example.JPA_Springboot.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    String addUser(UserRequestDto userRequestDto);
    UserResponseDto findById(Long id);
    List<UserResponseDto> findAll();
    String updateUser(Long id, UserRequestDto userRequestDto);
    String deleteById(Long id);
}