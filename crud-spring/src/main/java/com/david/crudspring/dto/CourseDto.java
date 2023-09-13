package com.david.crudspring.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.david.crudspring.enums.Category;
import com.david.crudspring.enums.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseDto {

    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @Length(max = 10)
    @ValueOfEnum(enumClass = Category.class)
    private String category;

    private List<LessonDto> lessons = new ArrayList<>();

    public CourseDto(Long id, String name, String category, List<LessonDto> lessons) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.lessons = lessons;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<LessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDto> lessons) {
        this.lessons = lessons;
    }
}
