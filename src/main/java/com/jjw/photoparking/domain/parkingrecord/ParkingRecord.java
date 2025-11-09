package com.jjw.photoparking.domain.parkingrecord;

import com.jjw.photoparking.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "parking_record")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParkingRecord extends BaseEntity {

    @Id
    @Column(name = "parking_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String vehicleNumber;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    @Enumerated(EnumType.STRING)
    private ParkingStatus parkingStatus;

    @Builder
    private ParkingRecord(String vehicleNumber, LocalDateTime entryTime, LocalDateTime exitTime, ParkingStatus parkingStatus) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingStatus = parkingStatus;
    }
}
