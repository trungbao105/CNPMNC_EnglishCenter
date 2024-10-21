package com.javaweb.api.admin;

import com.javaweb.model.dto.StudentDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.IStudentService;
import com.javaweb.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentAPI {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping
    public StudentDTO addOrUpdateStudent(@RequestBody StudentDTO studentDTO){
        studentService.addOrUpdateStudent(studentDTO);
        return studentDTO;
    }
    @DeleteMapping("/{ids}")
    public void deleteStudent(@PathVariable List<Long> ids){
        studentService.deleteStudents(ids);
    }
}
