package com.example.JpaRepository_Board.post.controller;

import com.example.JpaRepository_Board.post.dto.PostRequestDto;
import com.example.JpaRepository_Board.post.dto.PostResponseDto;
import com.example.JpaRepository_Board.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostRequestDto postRequestDto){
        return  ResponseEntity
                .ok(postService.addPost(postRequestDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> findAny(@PathVariable Long id){
        return ResponseEntity
                .ok(postService.findPost(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostResponseDto>> findAll(){
        return ResponseEntity
                .ok(postService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        return ResponseEntity
                .ok(postService.updateById(id,postRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return ResponseEntity
                .ok(postService.deleteById(id));
    }
}