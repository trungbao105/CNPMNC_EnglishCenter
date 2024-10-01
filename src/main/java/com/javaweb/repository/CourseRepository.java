package com.javaweb.repository;

import com.javaweb.entity.CourseEntity;
import com.javaweb.repository.custom.CourseRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Long > , CourseRepositoryCustom {

}
