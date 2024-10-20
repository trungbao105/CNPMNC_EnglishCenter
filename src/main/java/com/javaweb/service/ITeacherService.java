package com.javaweb.service;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.model.request.TeacherRequest;
import com.javaweb.model.response.TeacherResponse;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> getAllTeachers();
    void addOrUpdateTeacher(TeacherDTO teacherDTO);
    TeacherDTO findTeacherEntityById(Long id);
    void deleteTeachers (List<Long> Id);

}
