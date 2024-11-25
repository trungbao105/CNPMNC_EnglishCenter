package com.javaweb.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CourseDTO extends AbstractDTO {
    private Long id;
    private Long teacherId;
    private String title;
    private Date openingDate;
    private String image;
    private String price;
    private String note;
    private Integer quantity;

}
