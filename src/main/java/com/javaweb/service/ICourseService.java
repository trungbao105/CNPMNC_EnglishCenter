package com.javaweb.service;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.impl.CourseServiceImpl;

import java.util.List;

public interface ICourseService {
    List<CourseSearchResponse> findAll(CourseSearchRequest courseSearchRequest);
    void addOrUpdateCourse(CourseDTO courseDTO);
    CourseDTO findCourseEntityById(Long id);
    void deleteCourses (List<Long> Id);
    void assignTeacherToCourse(Long courseId, List<Long> teacherIds);
    List<TeacherDTO> getAssignedTeachers(Long courseId);
    List<CourseDTO> getAllCourses();
}
