package com.javaweb.service;

import com.javaweb.model.dto.RoomDTO;
import com.javaweb.model.dto.TeacherDTO;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> getAllRooms();
    void addOrUpdateRoom(RoomDTO roomDTO);
    RoomDTO findRoomEntityById(Long id);
    void deleteRooms(List<Long> ids);
}
