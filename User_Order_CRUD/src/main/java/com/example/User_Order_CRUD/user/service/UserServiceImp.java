package com.example.User_Order_CRUD.user.service;

import com.example.User_Order_CRUD.user.domain.User;
import com.example.User_Order_CRUD.user.domain.UserRequestDto;
import com.example.User_Order_CRUD.user.domain.UserResponseDto;
import com.example.User_Order_CRUD.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    // DI
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void CreateUser(UserRequestDto requestDto) {
        userRepository.CreateUser(requestDto);
    }

    @Override
    public UserResponseDto findIdByUser(Long id) {
        return userRepository.findIdByUser(id);
    }

    @Override
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public void updateUserById(Long id, UserRequestDto requestDto) {
        userRepository.updateUserById(id, requestDto);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.finduser(userId);
    }
}
