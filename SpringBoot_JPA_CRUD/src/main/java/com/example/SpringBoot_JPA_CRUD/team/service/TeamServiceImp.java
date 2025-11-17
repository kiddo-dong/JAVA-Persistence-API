package com.example.SpringBoot_JPA_CRUD.team.service;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamRequestDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.repository.TeamRepository;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.entity.User;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamServiceImp implements TeamService{

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public String addTeam(TeamRequestDto teamRequestDto){
        try {
            teamRepository.addTeam(teamRequestDto.toEntity());
        } catch (PersistenceException e) {
            return "이미 존재하는 팀 이름 입니다.";
        }
        return "팀이 생성되었습니다.";
    }

    @Override
    public TeamWithUserResponseDto findTeamAndUser(String name){
        // 팀 Object 가져옴
        Team team = teamRepository.findByName(name);

        if (team == null) {
            // 팀 자체가 없으면 null 반환하거나 예외 처리
            return null;
        }

        // 객체 -> DTO Mapping
        TeamWithUserResponseDto teamWithUserResponseDto = new TeamWithUserResponseDto();
        teamWithUserResponseDto.setName(team.getName());

        // 리스트 매핑 (내부 DTO 매핑)
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        // team.getUsers()는 List로 구성되어 있음, null 체크 추가
        if (team.getUsers() != null && !team.getUsers().isEmpty()) {
            for(User user : team.getUsers()){
                UserResponseDto u = new UserResponseDto();
                u.setName(user.getName());
                u.setAge(user.getAge());
                userResponseDtos.add(u);
            }
        }

        teamWithUserResponseDto.setUserResponseDtos(userResponseDtos);

        return teamWithUserResponseDto;
    }

    @Override
    public List<TeamResponseDto> findAll(){
        return teamRepository.findAll();
    }

    @Override
    public String updateTeamName(String name, String newName){
        Team team = teamRepository.updateByName(name);
        if(team == null){
            return "팀이 존재하지 않습니다.";
        }
        team.setName(newName);
        return "업데이트 완료";
    }

    @Override
    public String deleteTeam(String name){
        Team team = teamRepository.findByName(name);

        if (team == null) {
            return "팀이 존재하지 않습니다.";
        }

        if (!team.getUsers().isEmpty()) {
            return "삭제할 수 없음 (Team에 User가 존재합니다.)";
        }

        teamRepository.deleteTeam(team);
        return "팀이 삭제되었습니다.";
    }
}