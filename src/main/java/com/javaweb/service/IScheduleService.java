package com.javaweb.service;

import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.ScheduleDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IScheduleService {
    List<ScheduleDTO> getAllSchedules();
    ResponseEntity<?> addSchedule(ScheduleDTO scheduleDTO);
    void deleteSchedule(List<Long> ids);

}
