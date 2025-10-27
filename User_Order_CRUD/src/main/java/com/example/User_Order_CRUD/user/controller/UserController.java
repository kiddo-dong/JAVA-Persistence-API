package com.example.User_Order_CRUD.user.controller;

import com.example.User_Order_CRUD.user.domain.UserRequestDto;
import com.example.User_Order_CRUD.user.domain.UserResponseDto;
import com.example.User_Order_CRUD.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // HTTP 1.1

    // POST
    @PostMapping
    public ResponseEntity<String> createUser(
            @RequestBody UserRequestDto requestDto
    ){
        userService.CreateUser(requestDto);
        return ResponseEntity
                .ok("Success");
    }

    // GET
    // Object
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(
            @PathVariable Long id
    ){
        return ResponseEntity
                .ok(userService.findIdByUser(id));
    }
    // List
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        return ResponseEntity
                .ok(userService.findAllUser());
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDto requestDto
    ){
        userService.updateUserById(id, requestDto);
        return ResponseEntity
                .ok("Success");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Long id
    ){
        userService.deleteUserById(id);
        return ResponseEntity
                .ok("Success");
    }
}
