package com.example.User_Order_CRUD.user.repository;

import com.example.User_Order_CRUD.user.domain.User;
import com.example.User_Order_CRUD.user.domain.UserRequestDto;
import com.example.User_Order_CRUD.user.domain.UserResponseDto;

import java.util.List;

public interface UserRepository {
    void CreateUser(UserRequestDto requestDto);
    UserResponseDto findIdByUser(Long id);
    List<UserResponseDto> findAllUser();
    void updateUserById(Long id, UserRequestDto requestDto);
    void deleteUserById(Long id);
    User finduser(Long userId);
}