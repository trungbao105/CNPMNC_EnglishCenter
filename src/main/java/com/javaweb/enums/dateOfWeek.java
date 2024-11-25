package com.javaweb.enums;

public enum dateOfWeek {
    MONDAY("Thứ Hai"),
    TUESDAY("Thứ Ba"),
    WEDNESDAY("Thứ Tư"),
    THURSDAY("Thứ Năm"),
    FRIDAY("Thứ Sáu"),
    SATURDAY("Thứ Bảy"),
    SUNDAY("Chủ Nhật");

    private String displayName;

    dateOfWeek(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

