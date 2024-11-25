package com.javaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roomid")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private CourseEntity course;

    @Column(name = "date")
    private String date;

    @Column(name = "classtime")
    private String classTime;

}
