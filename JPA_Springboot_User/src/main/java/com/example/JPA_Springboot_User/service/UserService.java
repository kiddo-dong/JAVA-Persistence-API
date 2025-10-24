package com.example.JPA_Springboot_User.service;

import com.example.JPA_Springboot_User.domain.User;
import com.example.JPA_Springboot_User.domain.UserRequestDTO;
import com.example.JPA_Springboot_User.domain.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(UserRequestDTO userRequestDTO);
    List<UserResponseDto> findAllUser();
    Optional<UserResponseDto> findUserById(Long id);
    void updateUserById(Long id, UserRequestDTO userRequestDTO);
    void deleteUserById(Long id);
}
