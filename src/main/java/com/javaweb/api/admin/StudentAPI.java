package com.javaweb.api.admin;
import com.javaweb.entity.CourseEntity;
import com.javaweb.entity.RegistrationEntity;
import com.javaweb.model.dto.RegistrationDTO;
import com.javaweb.model.dto.StudentDTO;
import com.javaweb.repository.CourseRepository;
import com.javaweb.repository.RegistrationRepository;
import com.javaweb.service.IRegistration;
import com.javaweb.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IRegistration registrationService;
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping
    public StudentDTO addOrUpdateStudent(@RequestBody StudentDTO studentDTO){
        studentService.addOrUpdateStudent(studentDTO);
        return studentDTO;
    }
    @PostMapping("/registration")
    public ResponseEntity<?> Registration(@RequestBody RegistrationDTO registrationDTO){
        return registrationService.Registration(registrationDTO);
    }
    @GetMapping("/regis-{id}")
    public ResponseEntity<List<RegistrationDTO>> getRegistrationInfo (@PathVariable("id") Long id){
        List<RegistrationEntity> registrationEntity= registrationRepository.findAllByStudent_Id(id);
        List<RegistrationDTO> registrationDTOS =new ArrayList<>();
        for (RegistrationEntity regEntity : registrationEntity) {
            RegistrationDTO registrationDTO = modelMapper.map(regEntity, RegistrationDTO.class);
            CourseEntity courseEntity = courseRepository.findById(regEntity.getCourse().getId()).get();
            registrationDTO.setCourseName(courseEntity.getTitle());
            registrationDTOS.add(registrationDTO);
        }
        return ResponseEntity.ok(registrationDTOS);
    }
    @DeleteMapping("/{ids}")
    public void deleteStudent(@PathVariable List<Long> ids){
        studentService.deleteStudents(ids);
    }
}