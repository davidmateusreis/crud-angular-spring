package com.david.crudspring.dto;

import lombok.Data;

@Data
public class LessonDto {

    public LessonDto(Long id, String name, String youtubeUrl) {
        this.id = id;
        this.name = name;
        this.youtubeUrl = youtubeUrl;
    }

    private Long id;
    private String name;
    private String youtubeUrl;

}
