package com.javaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "course")
public class CourseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    private TeacherEntity teacherEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "openingdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private String price;

    @Column(name = "note")
    private String note;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "course",  fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "course",  fetch = FetchType.LAZY)
    private List<RegistrationEntity> registrations = new ArrayList<>();

}
