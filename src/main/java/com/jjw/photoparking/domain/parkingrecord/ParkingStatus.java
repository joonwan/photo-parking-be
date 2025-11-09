package com.jjw.photoparking.domain.parkingrecord;

import lombok.Getter;

@Getter
public enum ParkingStatus {
    IN_PROGRESS("주차중"), COMPLETED("출차 완료");

    private final String description;

    ParkingStatus(String description) {
        this.description = description;
    }
}
