package com.javaweb.controller.admin;

import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value = "roomControllerOfAdmin")
public class RoomController {
    @Autowired
    private IRoomService roomService;
    @RequestMapping(value = "/admin/room-list",method = RequestMethod.GET)
    public ModelAndView roomList(){
        ModelAndView mav = new ModelAndView("admin/Room/list");
        List<RoomDTO> roomDTOS=roomService.getAllRooms();
        mav.addObject("roomDTOS", roomDTOS);
        return mav;
    }
    @RequestMapping(value = "/admin/room-edit",method = RequestMethod.GET)
    public ModelAndView roomEdit(@ModelAttribute("roomEdit") RoomDTO roomDTO){
        ModelAndView mav = new ModelAndView("admin/Room/edit");
        return mav;
    }
    @RequestMapping(value = "/admin/room-edit-{id}", method = RequestMethod.GET)
    public ModelAndView roomEdit(@PathVariable("id") Long Id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/Room/edit");
        RoomDTO roomDTO = roomService.findRoomEntityById(Id);
        mav.addObject("roomEdit",roomDTO);
        return mav;
    }
}
