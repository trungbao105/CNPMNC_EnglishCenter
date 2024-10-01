package com.javaweb.api.admin;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
