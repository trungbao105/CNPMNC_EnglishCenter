package com.javaweb.controller.admin;

import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.model.request.CourseSearchRequest;
import com.javaweb.model.request.TeacherRequest;
import com.javaweb.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "controllerOfTeacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    @RequestMapping(value = "/admin/teacher-list", method = RequestMethod.GET)
    public ModelAndView teacherList() {
        ModelAndView mav = new ModelAndView("admin/Teacher/list");
        List<TeacherDTO> teacherDTOList= teacherService.getAllTeachers();
        mav.addObject("teachers",teacherDTOList);
        return mav;
    }
    @RequestMapping(value = "/admin/teacher-edit", method = RequestMethod.GET)
    public ModelAndView teacherEdit(@ModelAttribute("teacherEdit") TeacherDTO teacherDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Teacher/edit");
        return mav;
    }
    @RequestMapping(value = "/admin/teacher-edit-{id}", method = RequestMethod.GET)
    public ModelAndView teachereEdit(@PathVariable("id") Long Id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Teacher/edit");
        TeacherDTO teacherDTO = teacherService.findTeacherEntityById(Id);
        mav.addObject("teacherEdit",teacherDTO);
        return mav;
    }
}
