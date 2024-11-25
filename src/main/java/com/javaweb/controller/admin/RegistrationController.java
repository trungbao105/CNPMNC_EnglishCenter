package com.javaweb.controller.admin;

import com.javaweb.model.dto.*;
import com.javaweb.service.ICourseService;
import com.javaweb.service.IRegistration;
import com.javaweb.service.IScheduleService;
import com.javaweb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller(value = "RegistrationControllerOfAdmin")
public class RegistrationController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IScheduleService scheduleService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IRegistration registrationService;
    @RequestMapping(value = "/admin/registration-list", method = RequestMethod.GET)
    public ModelAndView registration(@ModelAttribute("registration") RegistrationDTO registrationDTO) {
        ModelAndView mav = new ModelAndView("admin/Registration/list");
        List<ScheduleDTO> scheduleDTOS = scheduleService.getAllSchedules();
        List<CourseDTO> courses = courseService.getAllCourses();
        List<StudentDTO> students = studentService.getAllStudents();
        List<RegistrationDTO> registrationDTOS=registrationService.getAllRegistration();
        mav.addObject("registrationDTOS", registrationDTOS);
        mav.addObject("scheduleDTOS", scheduleDTOS);
        mav.addObject("courses", courses);
        mav.addObject("students", students);
        return mav;
    }
}
