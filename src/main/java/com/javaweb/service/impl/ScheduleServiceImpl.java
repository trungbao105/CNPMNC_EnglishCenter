package com.javaweb.service.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.RoomEntity;
import com.javaweb.entity.ScheduleEntity;
import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.ScheduleDTO;
import com.javaweb.repository.CourseRepository;
import com.javaweb.repository.RoomRepository;
import com.javaweb.repository.ScheduleRepository;
import com.javaweb.service.IScheduleService;
import javassist.tools.web.BadHttpRequest;
import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleEntity> scheduleEntities = scheduleRepository.findAll();
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();
        for (ScheduleEntity scheduleEntity : scheduleEntities) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setId(scheduleEntity.getId());
            scheduleDTO.setDate(scheduleEntity.getDate());
            scheduleDTO.setClassTime(scheduleEntity.getClassTime());
            List<String> courseNames = new ArrayList<>();
            courseNames.add(scheduleEntity.getCourse().getTitle());
            scheduleDTO.setCourseNames(courseNames);
            List<String> roomNames = new ArrayList<>();
            roomNames.add(scheduleEntity.getRoom().getRoomName());
            scheduleDTO.setRoomNames(roomNames);
            scheduleDTOS.add(scheduleDTO);
        }

        return scheduleDTOS;
    }

    @Override
    public ResponseEntity<?> addSchedule(ScheduleDTO scheduleDTO) {
        ScheduleEntity scheduleEntity = modelMapper.map(scheduleDTO, ScheduleEntity.class);
        RoomEntity roomEntity = roomRepository.findById(scheduleDTO.getRoomId()).get();
        CourseEntity courseEntity = courseRepository.findById(scheduleDTO.getCourseId()).get();
        scheduleEntity.setRoom(roomEntity);
        scheduleEntity.setCourse(courseEntity);
        if (scheduleRepository.existsByDateAndRoomAndClassTime(
                scheduleEntity.getDate(),
                scheduleEntity.getRoom(),
                scheduleEntity.getClassTime()
        )) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lịch học này đã bị trùng. Vui lòng chọn thời gian hoặc phòng học khác.");
        }
        scheduleRepository.save(scheduleEntity);
        return ResponseEntity.ok("Lịch học đã được thêm thành công!");
    }



    @Override
    public void deleteSchedule(List<Long> ids) {
        List<ScheduleEntity> scheduleEntities = scheduleRepository.findAllById(ids);
        scheduleRepository.deleteAll(scheduleEntities);
    }
}
