package com.javaweb.controller.admin;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.response.CourseSearchResponse;
import com.javaweb.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @RequestMapping(value = "/admin/course-list", method = RequestMethod.GET)
    public ModelAndView courseList(@ModelAttribute CourseSearchRequest courseSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/Course/list");
        mav.addObject("modelSearchRequest", courseSearchRequest);
        mav.addObject("courses",courseService.findAll(courseSearchRequest));
        return mav;
    }
    @RequestMapping(value = "/admin/course-edit", method = RequestMethod.GET)
    public ModelAndView courseEdit(@ModelAttribute("courseEdit") CourseDTO courseDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Course/edit");
        return mav;
    }
    @RequestMapping(value = "/admin/course-edit-{id}", method = RequestMethod.GET)
    public ModelAndView courseEdit(@PathVariable("id") Long Id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Course/edit");
        CourseDTO courseDTO = courseService.findCourseEntityById(Id);
        mav.addObject("courseEdit",courseDTO);
        return mav;
    }
}
