package com.javaweb.repository;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.RegistrationEntity;
import com.javaweb.entity.RoomEntity;
import com.javaweb.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Long> {
    boolean existsByCourseAndStudent(CourseEntity course, StudentEntity student);

    RegistrationEntity findByStudent_Id(Long studentId);

    List<RegistrationEntity> findAllByStudent_Id(Long studentId);
}
