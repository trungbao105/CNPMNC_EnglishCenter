package com.javaweb.service.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.TeacherEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.CourseRepository;
import com.javaweb.repository.TeacherRepository;
import com.javaweb.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<CourseSearchResponse> findAll(CourseSearchRequest courseSearchRequest) {
        List<CourseEntity> course =courseRepository.findAll(courseSearchRequest);
        List<CourseSearchResponse> courseSearchResponses = new ArrayList<>();
        for(CourseEntity it : course ){
            CourseSearchResponse bookSearchResponse = modelMapper.map(it, CourseSearchResponse.class); ;
            courseSearchResponses.add(bookSearchResponse);
        }
        return courseSearchResponses;
    }

    @Override
    public void addOrUpdateCourse(CourseDTO courseDTO) {
        CourseEntity course = modelMapper.map(courseDTO, CourseEntity.class);
        course.setQuantity(0);
        courseRepository.save(course);
    }

    @Override
    public CourseDTO findCourseEntityById(Long id) {
        CourseEntity courseEntity= courseRepository.findById(id).get();
        CourseDTO courseDTO = modelMapper.map(courseEntity, CourseDTO.class);
        return courseDTO;
    }

    @Override
    public void deleteCourses(List<Long> Id) {
        List<CourseEntity> courseEntities = courseRepository.findAllById(Id);
        courseRepository.deleteAll(courseEntities);
    }

    @Override
    public void assignTeacherToCourse(Long courseId, List<Long> teacherIds) {
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        List<TeacherEntity> teachers = teacherRepository.findAllById(teacherIds);
        if (!teachers.isEmpty()) {
            course.setTeacherEntity(teachers.get(0));
        }
        courseRepository.save(course);

    }

    @Override
    public List<TeacherDTO> getAssignedTeachers(Long courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Khóa học không tồn tại"));
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        TeacherEntity assignedTeacher = courseEntity.getTeacherEntity();
        if (assignedTeacher != null) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(assignedTeacher.getId());
            teacherDTO.setName(assignedTeacher.getName());
            teacherDTOs.add(teacherDTO);
        }
        return teacherDTOs;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<CourseEntity> courseEntities = courseRepository.findAll();
        return courseEntities.stream()
                .map(courseEntity -> modelMapper.map(courseEntity, CourseDTO.class))
                .collect(Collectors.toList());
    }


}
