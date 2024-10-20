package com.javaweb.model.dto;

import java.util.List;

public class AssignTeacherDTO extends AbstractDTO {
    private List<Long> teacherIds;

    public List<Long> getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(List<Long> teacherIds) {
        this.teacherIds = teacherIds;
    }
}
