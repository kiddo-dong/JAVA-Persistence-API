package com.example.User_Order_CRUD.post.controller;

import com.example.User_Order_CRUD.post.domain.PostListDto;
import com.example.User_Order_CRUD.post.domain.PostRequestDto;
import com.example.User_Order_CRUD.post.domain.PostResponseDto;
import com.example.User_Order_CRUD.post.service.PostService;
import com.example.User_Order_CRUD.user.domain.User;
import com.example.User_Order_CRUD.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    // HTTP 1.1
    // POST
    @PostMapping("/{user_id}")
    public ResponseEntity<String> createPost(
            @PathVariable Long user_id,
            @RequestBody PostRequestDto requestDto
    ){

        User user = userService.findUser(user_id);
        // 2. 조회한 User 객체와 DTO를 서비스에 전달
        postService.createPost(user, requestDto);
        return ResponseEntity
                .ok("Post 생성 완료");
    }

    // GET
    // Post List
    @GetMapping
    public ResponseEntity<List<PostListDto>> findAllPost(){
        List<PostListDto> posts = postService.findAllPosts();
        return ResponseEntity.ok(posts);
    }
    // Post Object
    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponseDto> findPost(
            @PathVariable Long post_id
    ){
        PostResponseDto post = postService.findPostById(post_id);
        return ResponseEntity.ok(post);
    }
    // 사용자 검증 GET
    @GetMapping("/user/{user_id}/post/{post_id}")
    public ResponseEntity<Boolean> verifyUser(
        @PathVariable Long user_id,
        @PathVariable Long post_id
    ){
        boolean canEdit = postService.verifyPostOwner(post_id, user_id);
        return ResponseEntity
                .ok(canEdit);
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<String> update(
            @PathVariable Long post_id,
            @RequestBody PostRequestDto requestDto,
            @RequestHeader("user_id") Long user_id
    ){
        boolean success = postService.updatePost(post_id, requestDto, user_id);
        if(!success){
            return ResponseEntity.status(403).body("권한 없음");
        }
        return ResponseEntity.ok("수정 완료");
    }
    @DeleteMapping("/{post_id}")
    public ResponseEntity<String> deletePost(
            @PathVariable Long post_id,
            @RequestHeader("user_id") Long user_id
    ){
        boolean success = postService.deletePost(post_id, user_id);
        if(!success){
            return ResponseEntity.status(403).body("권한 없음");
        }
        return ResponseEntity.ok("삭제 완료");
    }
}