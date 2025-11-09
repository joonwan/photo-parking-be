package com.jjw.photoparking.domain.parkinglot;

import com.jjw.photoparking.domain.user.User;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "parking_lots")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParkingLot {

    @Id
    @Column(name = "parking_lot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parking_log_name", nullable = false, length = 255)
    private String parkingLotName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    @Column(nullable = false)
    private Address address;

    @Embedded
    @Column(nullable = false)
    private FeePolicy feePolicy;

    @Builder
    private ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public void initializeUser(User user) {
        this.user = user;
        user.addParkingLot(this);
    }
}
