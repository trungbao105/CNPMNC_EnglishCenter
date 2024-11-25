package com.javaweb.api.admin;

import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.TeacherDTO;
import com.javaweb.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomAPI {
    @Autowired
    private IRoomService roomService;
    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }
    @PostMapping
    public RoomDTO addOrUpdateRoom(@RequestBody RoomDTO roomDTO) {
        roomService.addOrUpdateRoom(roomDTO);
        return roomDTO;
    }
    @DeleteMapping("/{ids}")
    public void deleteRoom(@PathVariable List<Long> ids ) {
        roomService.deleteRooms(ids);
    }

}
