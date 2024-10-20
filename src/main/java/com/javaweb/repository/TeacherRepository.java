package com.javaweb.repository;

import com.javaweb.entity.RoleEntity;
import com.javaweb.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    List<TeacherEntity> findTeacherEntitiesByStatus(String status);
}
