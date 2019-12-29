package com.example.aws_ex.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
