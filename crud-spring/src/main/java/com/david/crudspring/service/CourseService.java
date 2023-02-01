package com.david.crudspring.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.david.crudspring.exception.RecordNotFountException;
import com.david.crudspring.model.Course;
import com.david.crudspring.repository.CourseRepository;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> list() {
        return courseRepository.findAll();
    }

    public Course findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RecordNotFountException(id));
    }

    public Course create(@Valid Course course) {
        return courseRepository.save(course);
    }

    public Course update(@NotNull @Positive Long id, @Valid Course course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    return courseRepository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFountException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFountException(id)));
    }
}
