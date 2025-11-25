package com.example.JpaRepository_Board.post.service;

import com.example.JpaRepository_Board.post.dto.PostRequestDto;
import com.example.JpaRepository_Board.post.dto.PostResponseDto;
import com.example.JpaRepository_Board.post.entity.Post;
import com.example.JpaRepository_Board.post.mapper.PostMapper;
import com.example.JpaRepository_Board.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImp implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImp(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public String addPost(PostRequestDto postRequestDto) {
        postRepository.save(postMapper.toEntity(postRequestDto));
        return "작성 완료";
    }

    @Override
    public PostResponseDto findPost(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("존재하지 않음"));

        return postMapper.toResponseDto(post);
    }

    @Override
    public List<PostResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return postMapper.toPostResponseDtos(posts);
    }

    @Override
    public String updateById(Long id, PostRequestDto postRequestDto) {
        if(postRequestDto != null){
            Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않음"));
            postMapper.updatePost(postRequestDto, post);

            return "변경 완료";
        } else {
            return "변경 할 데이터 없음";
        }
    }

    @Override
    public String deleteById(Long id) {
        try {
            postRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            return "존재하지 않음";
        }
        return "삭제 완료";
    }
}
