package com.example.JpaRepository_Board.post.mapper;

import com.example.JpaRepository_Board.post.dto.PostRequestDto;
import com.example.JpaRepository_Board.post.dto.PostResponseDto;
import com.example.JpaRepository_Board.post.entity.Post;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    // toEntity
    Post toEntity(PostRequestDto postRequestDto);

    // toResponseDto
    PostResponseDto toResponseDto(Post post);
    List<PostResponseDto> toPostResponseDtos(List<Post> posts);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePost(PostRequestDto postRequestDto, @MappingTarget Post post);
}
