package com.javaweb.service;

import com.javaweb.model.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudents();
}
