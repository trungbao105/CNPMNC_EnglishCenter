package com.javaweb.model.dto;

import com.javaweb.entity.CourseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ScheduleDTO extends AbstractDTO{
    private Long id;
    private String date;
    private String classTime;
    private Long courseId;
    private Long roomId;
    private List<String> courseNames;
    private List<String> roomNames;

}
