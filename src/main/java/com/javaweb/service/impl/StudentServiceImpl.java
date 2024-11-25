package com.javaweb.service.impl;

import com.javaweb.entity.StudentEntity;
import com.javaweb.model.dto.StudentDTO;
import com.javaweb.repository.StudentRepository;
import com.javaweb.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> students = studentRepository.findStudentEntitiesByStatus("1");
        return students.stream()
                .map(studentEntity -> {
                    StudentDTO studentDTO = modelMapper.map(studentEntity, StudentDTO.class);
                    return studentDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addOrUpdateStudent(StudentDTO studentDTO) {
        StudentEntity student = modelMapper.map(studentDTO, StudentEntity.class);
        student.setStatus("1");
        studentRepository.save(student);
    }

    @Override
    public StudentDTO findStudentEntityById(Long id) {
        StudentEntity studentEntity= studentRepository.findById(id).get();
        StudentDTO studentDTO = modelMapper.map(studentEntity, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public void deleteStudents(List<Long> Id) {
        List<StudentEntity> studentEntities = studentRepository.findAllById(Id);
        for (StudentEntity studentEntity : studentEntities) {
            studentEntity.setStatus("0");
            studentEntities.add(studentEntity);
            studentRepository.saveAll(studentEntities);
        }
    }
}
