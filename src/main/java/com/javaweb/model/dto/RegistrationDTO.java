package com.javaweb.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationDTO extends AbstractDTO{
    private Long courseId;
    private Long studentId;
    private List<String> courseNames;
    private List<String> studentNames;
    private String courseName;

}
