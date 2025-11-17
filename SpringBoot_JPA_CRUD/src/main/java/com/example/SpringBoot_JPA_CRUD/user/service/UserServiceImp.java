package com.example.SpringBoot_JPA_CRUD.user.service;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.repository.TeamRepository;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserRequestDto;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import com.example.SpringBoot_JPA_CRUD.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    //DI
    @Autowired
    public UserServiceImp(UserRepository userRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public String addUser(UserRequestDto userRequestDto){
        Team team = teamRepository.findOnlyTeam(userRequestDto.getTeamName());
        if (team == null) {
            return "Team이 존재하지 않음";
        }
        userRepository.addUser(userRequestDto.toEntity(team));
        return "User 추가 완료";
    }

    @Override
    public UserResponseDto findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String updateById(Long id, UserRequestDto userRequestDto){
        User user = userRepository.updateById(id);

        if(userRequestDto.getName() != null){
            user.setName(userRequestDto.getName());
        }
        if(userRequestDto.getAge() != null){
            user.setAge(userRequestDto.getAge());
        }
        if(userRequestDto.getTeamName() != null){
            Team team = teamRepository.findOnlyTeam(userRequestDto.getTeamName());
            if(team != null){
                user.setTeam(team);
            } else {
                throw new IllegalArgumentException("팀 없음");
            }
        }
        return "업데이트 완료";
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "삭제 완료";
    }
}
