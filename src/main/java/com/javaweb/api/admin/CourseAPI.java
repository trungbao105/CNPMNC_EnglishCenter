package com.javaweb.api.admin;
import com.javaweb.model.dto.AssignTeacherDTO;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "courseAPIOfAdmin")
@RequestMapping("/api/course")
public class CourseAPI {
    @Autowired
    private ICourseService courseService;
    @PostMapping
    public CourseDTO addOrUpdateCourse(@RequestBody CourseDTO courseDTO){
        courseService.addOrUpdateCourse(courseDTO);
        return courseDTO;
    }
    @DeleteMapping("/{ids}")
    public void deleteCourse(@PathVariable List<Long> ids){
        courseService.deleteCourses(ids);
    }
    @PostMapping("/{courseId}/assign-teacher")
    public ResponseEntity<String> assignTeacherToCourse(@PathVariable Long courseId, @RequestBody AssignTeacherDTO assignTeacherDTO) {
        courseService.assignTeacherToCourse(courseId, assignTeacherDTO.getTeacherIds());
        return new ResponseEntity<>("Giao khóa học thành công!", HttpStatus.OK);
    }
    @GetMapping("/{courseId}/assigned-teachers")
    public ResponseEntity<List<TeacherDTO>> getAssignedTeachers(@PathVariable Long courseId) {
        List<TeacherDTO> assignedTeachers = courseService.getAssignedTeachers(courseId);
        return new ResponseEntity<>(assignedTeachers, HttpStatus.OK);
    }
}
