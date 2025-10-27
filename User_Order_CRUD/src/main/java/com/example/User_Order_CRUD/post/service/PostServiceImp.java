package com.example.User_Order_CRUD.post.service;

import com.example.User_Order_CRUD.post.domain.Post;
import com.example.User_Order_CRUD.post.domain.PostListDto;
import com.example.User_Order_CRUD.post.domain.PostRequestDto;
import com.example.User_Order_CRUD.post.domain.PostResponseDto;
import com.example.User_Order_CRUD.post.repository.PostRepository;
import com.example.User_Order_CRUD.user.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImp implements PostService{
    private final PostRepository postRepository;

    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(User user, PostRequestDto dto) {
        Post post = new Post();
        post.setUser(user); // FK 연결
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        postRepository.save(post);
    }

    @Override
    public List<PostListDto> findAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostListDto(
                        post.getId(),
                        post.getUser().getName(),
                        post.getTitle(),
                        post.getUpdatedAt()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDto findPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음: " + postId));

        return new PostResponseDto(
                post.getId(),
                post.getUser().getName(),
                post.getTitle(),
                post.getContent(),
                post.getUpdatedAt()
        );
    }

    @Override
    public boolean verifyPostOwner(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음: " + postId));

        return post.getUser().getId().equals(userId);
    }

    @Override
    public boolean updatePost(Long postId, PostRequestDto requestDto, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음: " + postId));

        if(!post.getUser().getId().equals(userId)){
            return false; // 권한 없음
        }

        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        // JPA 변경 감지로 자동 flush
        return true;
    }

    @Override
    public boolean deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음: " + postId));

        if(!post.getUser().getId().equals(userId)){
            return false; // 권한 없음
        }

        postRepository.delete(post);
        return true;
    }
}
