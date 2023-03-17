package com.david.crudspring.dto.mapper;

import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.david.crudspring.dto.CourseDto;
import com.david.crudspring.enums.Category;
import com.david.crudspring.model.Course;

@Component
public class CourseMapper {

    public CourseDto toDTO(Course course) {

        if (course == null) {
            return null;
        }
        return new CourseDto(course.getId(), course.getName(), course.getCategory().getValue());
    }

    public Course toEntity(CourseDto courseDto) {

        if (courseDto == null) {
            return null;
        }

        Course course = new Course();
        if (courseDto.getId() != null) {
            course.setId(courseDto.getId());
        }
        course.setName(courseDto.getName());
        course.setCategory(convertCategoryValue(courseDto.getCategory()));
        return course;
    }

    public Category convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Category.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
