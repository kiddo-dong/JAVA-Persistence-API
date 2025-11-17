package com.example.SpringBoot_JPA_CRUD.user.controller;

import com.example.SpringBoot_JPA_CRUD.user.dto.UserRequestDto;
import com.example.SpringBoot_JPA_CRUD.user.dto.UserResponseDto;
import com.example.SpringBoot_JPA_CRUD.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity
                .ok(userService.addUser(userRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(userService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity
                .ok(userService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity
                .ok(userService.updateById(id,userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(Long id){
        return ResponseEntity
                .ok(userService.deleteById(id));
    }
}
