package com.example.User_Order_CRUD.post.service;

import com.example.User_Order_CRUD.post.domain.PostListDto;
import com.example.User_Order_CRUD.post.domain.PostRequestDto;
import com.example.User_Order_CRUD.post.domain.PostResponseDto;
import com.example.User_Order_CRUD.user.domain.User;

import java.util.List;

public interface PostService {
    void createPost(User user, PostRequestDto dto);
    List<PostListDto> findAllPosts();
    PostResponseDto findPostById(Long postId);
    // Post 수정을 위한 권한 검증 Logic
    boolean verifyPostOwner(Long postId, Long userId);
    // 권한 검증 포함
    boolean updatePost(Long postId, PostRequestDto requestDto, Long userId);
    boolean deletePost(Long postId, Long userId);
}
