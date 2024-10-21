package com.javaweb.controller.admin;

import com.javaweb.model.dto.StudentDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.IStudentService;
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

@Controller(value = "controllerOfStudent")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @RequestMapping(value = "/admin/student-list", method = RequestMethod.GET)
    public ModelAndView studentList() {
        ModelAndView mav = new ModelAndView("admin/Student/list");
        List<StudentDTO> studentDTOList= studentService.getAllStudents();
        mav.addObject("students",studentDTOList);
        return mav;
    }
    @RequestMapping(value = "/admin/student-edit", method = RequestMethod.GET)
    public ModelAndView studentEdit(@ModelAttribute("studentEdit") StudentDTO studentDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Student/edit");
        return mav;
    }
    @RequestMapping(value = "/admin/student-edit-{id}", method = RequestMethod.GET)
    public ModelAndView studentEdit(@PathVariable("id") Long Id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Student/edit");
        StudentDTO studentDTO = studentService.findStudentEntityById(Id);
        mav.addObject("studentEdit",studentDTO);
        return mav;
    }
}
