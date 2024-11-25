package com.javaweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<RegistrationEntity> registrations = new ArrayList<>();

}
