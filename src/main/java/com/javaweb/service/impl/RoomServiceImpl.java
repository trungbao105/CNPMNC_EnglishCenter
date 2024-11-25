package com.javaweb.service.impl;

import com.javaweb.entity.RoomEntity;
import com.javaweb.model.dto.RoomDTO;
import com.javaweb.repository.RoomRepository;
import com.javaweb.service.IRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<RoomDTO> roomDTOS = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            RoomDTO roomDTO = modelMapper.map(roomEntity, RoomDTO.class);
            roomDTOS.add(roomDTO);
        }
        return roomDTOS;
    }

    @Override
    public void addOrUpdateRoom(RoomDTO roomDTO) {
        RoomEntity roomEntity = modelMapper.map(roomDTO, RoomEntity.class);
        roomRepository.save(roomEntity);
    }

    @Override
    public RoomDTO findRoomEntityById(Long id) {
        RoomEntity roomEntity= roomRepository.findById(id).get();
        RoomDTO roomDTO = modelMapper.map(roomEntity, RoomDTO.class);
        return roomDTO;
    }

    @Override
    public void deleteRooms(List<Long> ids) {
        List<RoomEntity> roomEntities = roomRepository.findAllById(ids);
        roomRepository.deleteAll(roomEntities);
    }
}
