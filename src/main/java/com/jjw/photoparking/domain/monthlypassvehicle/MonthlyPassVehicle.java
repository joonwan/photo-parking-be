package com.jjw.photoparking.domain.monthlypassvehicle;

import com.jjw.photoparking.domain.BaseEntity;
import com.jjw.photoparking.domain.parkinglot.ParkingLot;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "monthly_pass_vehicle")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MonthlyPassVehicle extends BaseEntity {

    @Id
    @Column(name = "monthly_pass_vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    private LocalDate startDate;

    private LocalDate endDate;

    // 차량 번호
    private String vehicleNumber;

    // 연락처
    private String contact;

    @Builder
    private MonthlyPassVehicle(LocalDate startDate, LocalDate endDate, String vehicleNumber, String contact) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicleNumber = vehicleNumber;
        this.contact = contact;
    }

    public void initializeParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingLot.addMonthlyPassVehicle(this);
    }
}
