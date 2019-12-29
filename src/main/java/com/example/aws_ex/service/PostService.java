package com.example.aws_ex.service;

import com.example.aws_ex.domain.posts.Posts;
import com.example.aws_ex.domain.posts.PostsRepository;
import com.example.aws_ex.web.dto.PostUpdateRequestDto;
import com.example.aws_ex.web.dto.PostsResponseDto;
import com.example.aws_ex.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 없스니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
