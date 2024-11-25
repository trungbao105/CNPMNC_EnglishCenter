package com.javaweb.api.admin;

import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.ScheduleDTO;
import com.javaweb.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleAPI {
    @Autowired
    private IScheduleService scheduleService;
    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
    @PostMapping
    public ResponseEntity<?> addOrUpdateSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.addSchedule(scheduleDTO);
    }
    @DeleteMapping("/{ids}")
    public void deleteSchedule(@PathVariable List<Long> ids ) {
        scheduleService.deleteSchedule(ids);
    }
}
