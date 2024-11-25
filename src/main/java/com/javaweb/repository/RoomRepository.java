package com.javaweb.repository;

import com.javaweb.entity.RoomEntity;
import com.javaweb.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
}
