package com.example.demo.demo_enum;

public enum OrederStatus {
    CHECK("有效"),
    UNCHECK("取消");

    private String statusName;

    private OrederStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}