package com.example.User_Order_CRUD.post.repository;

import com.example.User_Order_CRUD.post.domain.Post;
import com.example.User_Order_CRUD.post.domain.PostListDto;

import java.lang.ScopedValue;
import java.util.Arrays;
import java.util.List;

public interface PostRepository {
    void save(Post post);
    List<PostListDto> findAll();

    Post findById(Long postId);

    void delete(Post post);
}