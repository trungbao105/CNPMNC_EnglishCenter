package com.javaweb.service;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.service.impl.CourseServiceImpl;

import java.util.List;

public interface ICourseService {
    List<CourseSearchResponse> findAll(CourseSearchRequest courseSearchRequest);
    void addOrUpdateCourse(CourseDTO courseDTO);
    CourseDTO findCourseEntityById(Long id);
    void deleteCourses (List<Long> Id);
}
