package com.javaweb.repository.custom;

import com.javaweb.entity.CourseEntity;
import com.javaweb.model.request.CourseSearchRequest;

import java.util.List;

public interface CourseRepositoryCustom {
    List<CourseEntity> findAll(CourseSearchRequest courseSearchRequest);
}
