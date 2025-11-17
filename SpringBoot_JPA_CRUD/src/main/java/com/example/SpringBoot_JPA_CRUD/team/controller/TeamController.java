package com.example.SpringBoot_JPA_CRUD.team.controller;

import com.example.SpringBoot_JPA_CRUD.team.Entity.Team;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamRequestDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.dto.TeamWithUserResponseDto;
import com.example.SpringBoot_JPA_CRUD.team.repository.TeamRepository;
import com.example.SpringBoot_JPA_CRUD.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    // DI
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Create Team
    @PostMapping
    public ResponseEntity<String> addTeam(@RequestBody TeamRequestDto teamRequestDto){
        return ResponseEntity
                .ok(teamService.addTeam(teamRequestDto));
    }

    // Read Team & Users
    @GetMapping("/{name}")
    public ResponseEntity<TeamWithUserResponseDto> findTeamAndUser(@PathVariable String name){
        return ResponseEntity
                .ok(teamService.findTeamAndUser(name));
    }

    // Read AllTeam
    @GetMapping("/all")
    public ResponseEntity<List<TeamResponseDto>> findAll(){
        return ResponseEntity
                .ok(teamService.findAll());
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updateTeam(@PathVariable String name, @RequestBody Map<String, String> body){
        return ResponseEntity
                .ok(teamService.updateTeamName(name, body.get("newName")));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteTeam(@PathVariable String name){
        return ResponseEntity
                .ok(teamService.deleteTeam(name));
    }
}