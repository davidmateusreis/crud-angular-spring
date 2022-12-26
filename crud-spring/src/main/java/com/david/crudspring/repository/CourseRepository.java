package com.david.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
    
}
