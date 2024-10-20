package com.javaweb.service.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.TeacherEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.model.request.TeacherRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.model.response.TeacherResponse;
import com.javaweb.repository.TeacherRepository;
import com.javaweb.service.ITeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TeacherDTO> getAllTeachers() {
            List<TeacherEntity> teachers = teacherRepository.findTeacherEntitiesByStatus("1");
        return teachers.stream()
                .map(teacherEntity -> {
                    TeacherDTO teacherDTO = modelMapper.map(teacherEntity, TeacherDTO.class);
                    List<String> courseNames = teacherEntity.getCourseEntities().stream()
                            .map(CourseEntity::getTitle)
                            .collect(Collectors.toList());
                    if (courseNames.isEmpty()) {
                        courseNames.add("Chưa được dạy !!! ");
                    }
                    teacherDTO.setCourseNames(courseNames);
                    return teacherDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addOrUpdateTeacher(TeacherDTO teacherDTO) {
        TeacherEntity teacher = modelMapper.map(teacherDTO, TeacherEntity.class);
        teacher.setStatus("1");
        teacherRepository.save(teacher);
    }

    @Override
    public TeacherDTO findTeacherEntityById(Long id) {
        TeacherEntity teacherEntity= teacherRepository.findById(id).get();
        TeacherDTO teacherDTO = modelMapper.map(teacherEntity, TeacherDTO.class);
        return teacherDTO;
    }

    @Override
    public void deleteTeachers(List<Long> Id) {
        List<TeacherEntity> teacherEntities = teacherRepository.findAllById(Id);
        for (TeacherEntity teacherEntity : teacherEntities) {
            teacherEntity.setStatus("0");
            teacherEntities.add(teacherEntity);
        }
        teacherRepository.saveAll(teacherEntities);
    }


}
