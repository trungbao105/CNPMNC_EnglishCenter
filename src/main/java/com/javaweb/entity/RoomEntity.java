package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roomname")
    private String roomName;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "location")
    private String location;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();

    public List<ScheduleEntity> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
