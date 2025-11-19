package com.example.RelationshipMapping_CRUD.user.service;

import com.example.RelationshipMapping_CRUD.team.entity.Team;
import com.example.RelationshipMapping_CRUD.team.repository.TeamRepository;
import com.example.RelationshipMapping_CRUD.user.dto.UserRequestDto;
import com.example.RelationshipMapping_CRUD.user.dto.UserResponseDto;
import com.example.RelationshipMapping_CRUD.user.entity.User;
import com.example.RelationshipMapping_CRUD.user.mapper.UserMapper;
import com.example.RelationshipMapping_CRUD.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final UserMapper userMapper;


    public UserServiceImp(UserRepository userRepository, TeamRepository teamRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String addUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        userRepository.addUser(user);

        return "생성되었습니다.";
    }

    @Override
    public UserResponseDto findUser(Long id) {
        User user = userRepository.findById(id);
        if(user == null){
            return null;
        }
        return userMapper.toResponseDto(user);
    }


    @Override
    public List<UserResponseDto> findAll(Long id) {
        return userMapper.toResponseDtoList(userRepository.findAll());
    }

    @Override
    public String updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id);
        // setter 도 MapStruct로 보일러 플레이트 줄이기 가능
        // 이 Setter의 보일러 플레이트를 줄여보자
        if(user != null){
            if(userRequestDto.getName() != null){
                user.setName(userRequestDto.getName());
            }
            if(userRequestDto.getAge() != null){
                user.setAge(userRequestDto.getAge());
            }
            if(userRequestDto.getTeamName() != null){
                Team team = (teamRepository.findByName(userRequestDto.getTeamName()));
                if(team != null){
                    user.setTeam(team);
                } else {
                    return "팀이 존재하지 않아 업데이트 할 수 없습니다.";
                }
            }
        }else {
            return "User가 존재하지 않아 업데이트 할 수 없습니다.";
        }
        return "업데이트 완료!";
    }

    public String updateUserMapStruct(Long id, UserRequestDto userRequestDto){
        User user = userRepository.findById(id);
        if(user != null){
            // 새로 지정한 Team이 있다면
            if(userRequestDto.getTeamName() != null){
                // 팀 찾아서 user 객체에 주입
                Team team = teamRepository.findByName(userRequestDto.getTeamName());
                user.setTeam(team);
            }
            userMapper.updateUserFromRequestDto(userRequestDto, user);
        } else {
            return "User가 존재하지 않아 업데이트 할 수 없습니다.";
        }
        return "업데이트 완료";
    }



    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id);
        if(user == null){
            return null;
        }
        return "삭제되었습니다.";
    }
}
