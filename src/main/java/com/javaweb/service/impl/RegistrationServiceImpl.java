package com.javaweb.service.impl;

import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.RegistrationEntity;
import com.javaweb.entity.RoomEntity;
import com.javaweb.entity.ScheduleEntity;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.RegistrationDTO;
import com.javaweb.repository.CourseRepository;
import com.javaweb.repository.RegistrationRepository;
import com.javaweb.repository.RoomRepository;
import com.javaweb.repository.ScheduleRepository;
import com.javaweb.service.IRegistration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RegistrationServiceImpl implements IRegistration {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<RegistrationDTO> getAllRegistration() {
        List<RegistrationEntity> registrationEntities = registrationRepository.findAll();
        return registrationEntities.stream()
                .map(registrationEntity -> modelMapper.map(registrationEntity, RegistrationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> Registration(RegistrationDTO registrationDTO) {
        RegistrationEntity registrationEntity = modelMapper.map(registrationDTO, RegistrationEntity.class);
        if(registrationRepository.existsByCourseAndStudent(
                registrationEntity.getCourse(),
                registrationEntity.getStudent()
        )){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Học sinh đã đăng ký khóa học này rồi.");
        }
        CourseEntity courseEntity= courseRepository.findById(registrationDTO.getCourseId()).get();
        List<ScheduleEntity> scheduleEntity = scheduleRepository.findAllByCourse(courseEntity);
        for (ScheduleEntity schedule : scheduleEntity) {
            RoomEntity roomEntity= roomRepository.findById(schedule.getRoom().getId()).get();
            if(courseEntity.getQuantity()>=roomEntity.getCapacity()){
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lớp đã đủ số lượng.");
            }
        }
        courseEntity.setQuantity(courseEntity.getQuantity() + 1);
        courseRepository.save(courseEntity);
        registrationRepository.save(registrationEntity);
        return ResponseEntity.ok("Đăng ký thành công");
    }
}
