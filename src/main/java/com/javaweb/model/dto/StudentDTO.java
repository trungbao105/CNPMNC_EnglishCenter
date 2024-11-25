package com.javaweb.model.dto;

import lombok.Data;

@Data
public class StudentDTO extends AbstractDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String status;

}
