package com.javaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "roomControllerOfAdmin")
public class RoomController {
    @RequestMapping(value = "/admin/room-list",method = RequestMethod.GET)
    public String roomList(){
        return "admin/room/list";

    }
}
