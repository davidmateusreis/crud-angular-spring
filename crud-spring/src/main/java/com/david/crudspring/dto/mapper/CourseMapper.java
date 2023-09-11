package com.david.crudspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.david.crudspring.dto.CourseDto;
import com.david.crudspring.dto.LessonDto;
import com.david.crudspring.enums.Category;
import com.david.crudspring.model.Course;
import com.david.crudspring.model.Lesson;

@Component
public class CourseMapper {

    public CourseDto toDTO(Course course) {

        if (course == null) {
            return null;
        }
        List<LessonDto> lessons = course.getLessons().stream()
                .map(lesson -> new LessonDto(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl()))
                .collect(Collectors.toList());
        return new CourseDto(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
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

        List<Lesson> lessons = courseDto.getLessons().stream().map(lessonDto -> {
            var lesson = new Lesson();
            lesson.setId(lessonDto.getId());
            lesson.setName(lessonDto.getName());
            lesson.setYoutubeUrl(lessonDto.getYoutubeUrl());
            lesson.setCourse(course);
            return lesson;

        }).collect(Collectors.toList());

        course.setLessons(lessons);
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
