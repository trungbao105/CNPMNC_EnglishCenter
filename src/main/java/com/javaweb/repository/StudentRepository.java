package com.javaweb.repository;

import com.javaweb.entity.StudentEntity;
import com.javaweb.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
