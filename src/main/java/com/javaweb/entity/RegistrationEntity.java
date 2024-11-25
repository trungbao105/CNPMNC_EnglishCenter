package com.javaweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "registration")
public class RegistrationEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studentid")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private CourseEntity course;
}