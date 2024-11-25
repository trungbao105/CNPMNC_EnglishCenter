package com.javaweb.repository;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.RoomEntity;
import com.javaweb.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
    List<ScheduleEntity> findByCourse(CourseEntity course);
    boolean existsByDateAndRoomAndClassTime( String date, RoomEntity room, String classTime);

    List<ScheduleEntity> findAllByCourse(CourseEntity course);
}
