package com.javaweb.service;

import com.javaweb.model.dto.StudentDTO;
import com.javaweb.model.dto.TeacherDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudents();
    void addOrUpdateStudent(StudentDTO studentDTO);
    StudentDTO findStudentEntityById(Long id);
    void deleteStudents (List<Long> Id);
}
