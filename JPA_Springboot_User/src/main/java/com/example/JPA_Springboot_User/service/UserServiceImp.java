package com.example.JPA_Springboot_User.service;

import com.example.JPA_Springboot_User.domain.User;
import com.example.JPA_Springboot_User.domain.UserRequestDTO;
import com.example.JPA_Springboot_User.domain.UserResponseDto;
import com.example.JPA_Springboot_User.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserRequestDTO userRequestDTO) {
        userRepository.addUser(userRequestDTO);
    }

    @Override
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public Optional<UserResponseDto> findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void updateUserById(Long id, UserRequestDTO userRequestDTO) {
        userRepository.updateUserById(id, userRequestDTO);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
