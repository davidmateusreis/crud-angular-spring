package com.david.crudspring.dto.mapper;

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
        return new CourseDto(course.getId(), course.getName(), "Frontend");
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
        course.setCategory(Category.FRONTEND);
        course.setStatus("Active");
        return course;
    }
}
