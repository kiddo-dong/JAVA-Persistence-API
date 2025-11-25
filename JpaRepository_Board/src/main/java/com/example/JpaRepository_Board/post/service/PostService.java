package com.example.JpaRepository_Board.post.service;

import com.example.JpaRepository_Board.post.dto.PostRequestDto;
import com.example.JpaRepository_Board.post.dto.PostResponseDto;
import com.example.JpaRepository_Board.post.entity.Post;

import java.util.List;

public interface PostService {
    String addPost(PostRequestDto postRequestDto);
    PostResponseDto findPost(Long id);
    List<PostResponseDto> findAll();
    String updateById(Long id, PostRequestDto postRequestDto);
    String deleteById(Long id);
}