package com.david.crudspring.dto;

import java.util.List;

public class CoursePageDto {

    private List<CourseDto> courses;
    private long totalElements;
    private int totalPages;

    public CoursePageDto(List<CourseDto> courses, long totalElements, int totalPages) {
        this.courses = courses;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
