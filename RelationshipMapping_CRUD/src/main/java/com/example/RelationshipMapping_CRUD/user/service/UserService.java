package com.example.RelationshipMapping_CRUD.user.service;

import com.example.RelationshipMapping_CRUD.user.dto.UserRequestDto;
import com.example.RelationshipMapping_CRUD.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    String addUser(UserRequestDto userRequestDto);
    UserResponseDto findUser(Long id);
    List<UserResponseDto> findAll(Long id);
    String updateUser(Long id, UserRequestDto userRequestDto);
    String deleteUser(Long id);
}
