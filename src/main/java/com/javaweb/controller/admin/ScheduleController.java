package com.javaweb.controller.admin;

import com.javaweb.enums.dateOfWeek;
import com.javaweb.model.dto.CourseDTO;
import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.ScheduleDTO;
import com.javaweb.service.ICourseService;
import com.javaweb.service.IRoomService;
import com.javaweb.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/admin/schedule-list", method = RequestMethod.GET)
    public ModelAndView scheduleList(@ModelAttribute("scheduleEdit") ScheduleDTO scheduleDTO) {
        ModelAndView mav = new ModelAndView("admin/Schedule/list");
        List<ScheduleDTO> scheduleDTOS = scheduleService.getAllSchedules();
        List<CourseDTO> courses = courseService.getAllCourses();
        List<RoomDTO> rooms = roomService.getAllRooms();
        List<String> weekdays = Arrays.asList("Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật");
        List<String> classTimes = Arrays.asList("7h00", "9h00", "13h00", "15h00", "17h00", "19h00", "21h00");
        mav.addObject("scheduleDTOS", scheduleDTOS);
        mav.addObject("courses", courses);
        mav.addObject("rooms", rooms);
        mav.addObject("weekdays", weekdays);
        mav.addObject("classTimes", classTimes);
        return mav;
    }

}
