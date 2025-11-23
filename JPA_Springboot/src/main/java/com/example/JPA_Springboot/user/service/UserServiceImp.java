package com.example.JPA_Springboot.user.service;

import com.example.JPA_Springboot.user.dto.UserRequestDto;
import com.example.JPA_Springboot.user.dto.UserResponseDto;
import com.example.JPA_Springboot.user.entity.User;
import com.example.JPA_Springboot.user.mapper.UserMapper;
import com.example.JPA_Springboot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String addUser(UserRequestDto userRequestDto) {
        userRepository.save(userMapper.toEntity(userRequestDto));
        return "저장 완료";
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않습니다."));
        return userMapper.toResponseDto(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAllTransDto();
    }

    @Override
    public String updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
        if(userRequestDto != null){
            userMapper.updateUserFromDto(userRequestDto, user);
            return "업뎃 완료";
        } else {
            return "";
        }
    }

    @Override
    public String deleteById(Long id) {
        if(userRepository.findById(id) != null){
            userRepository.deleteById(id);
            return "삭제 완료";
        } else {
            return "존재하지 않음";
        }
    }
}
