package com.javaweb.service.impl;

import com.javaweb.model.dto.StudentDTO;
import com.javaweb.repository.StudentRepository;
import com.javaweb.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }
}
