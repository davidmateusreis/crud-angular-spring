package com.david.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.david.crudspring.dto.CourseDto;
import com.david.crudspring.dto.mapper.CourseMapper;
import com.david.crudspring.exception.RecordNotFountException;
import com.david.crudspring.repository.CourseRepository;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDto> list() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDto findById(@NotNull @Positive Long id) {
        return courseRepository.findById(id).map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFountException(id));
    }

    public CourseDto create(@Valid @NotNull CourseDto courseDto) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(courseDto)));
    }

    public CourseDto update(@NotNull @Positive Long id, @Valid @NotNull CourseDto courseDto) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(courseDto.getName());
                    recordFound.setCategory(courseMapper.convertCategoryValue(courseDto.getCategory()));
                    return courseRepository.save(recordFound);
                }).map(courseMapper::toDTO).orElseThrow(() -> new RecordNotFountException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFountException(id)));
    }
}
