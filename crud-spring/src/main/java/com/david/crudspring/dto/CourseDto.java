package com.david.crudspring.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CourseDto {

    public CourseDto(Long id, @NotBlank @NotNull @Length(min = 5, max = 100) String name,
            @NotNull @Length(max = 10) @Pattern(regexp = "Backend|Frontend") String category, List<LessonDto> lessons) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.lessons = lessons;
    }

    @JsonProperty("_id")
    private Long id; // DTO de response teria id, DTO de request, não

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Backend|Frontend")
    private String category;

    private List<LessonDto> lessons = new ArrayList<>();

}
