package com.david.crudspring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LessonDto {

    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @NotBlank
    @NotNull
    @Length(min = 10, max = 11)
    private String youtubeUrl;

    public LessonDto(Long id, String name, String youtubeUrl) {
        this.id = id;
        this.name = name;
        this.youtubeUrl = youtubeUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
}
