package com.javaweb.service.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.repository.CourseRepository;
import com.javaweb.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;

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
}
