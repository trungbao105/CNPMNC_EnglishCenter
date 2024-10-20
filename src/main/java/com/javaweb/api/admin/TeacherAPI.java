package com.javaweb.api.admin;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherAPI {
    @Autowired
    private ITeacherService teacherService;
    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    @PostMapping
    public TeacherDTO addOrUpdateTeacher(@RequestBody TeacherDTO teacherDTO){
        teacherService.addOrUpdateTeacher(teacherDTO);
        return teacherDTO;
    }
    @DeleteMapping("/{ids}")
    public void deleteTeacher(@PathVariable List<Long> ids){
        teacherService.deleteTeachers(ids);
    }
}
