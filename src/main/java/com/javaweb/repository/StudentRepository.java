package com.javaweb.repository;

import com.javaweb.entity.StudentEntity;
import com.javaweb.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    List<StudentEntity> findStudentEntitiesByStatus(String status);
}
