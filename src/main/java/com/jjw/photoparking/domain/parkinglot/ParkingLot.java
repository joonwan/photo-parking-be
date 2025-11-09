package com.jjw.photoparking.domain.parkinglot;

import com.jjw.photoparking.domain.BaseEntity;
import com.jjw.photoparking.domain.discountpolicy.DiscountPolicy;
import com.jjw.photoparking.domain.monthlypassvehicle.MonthlyPassVehicle;
import com.jjw.photoparking.domain.user.User;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "parking_lots")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParkingLot extends BaseEntity {

    @Id
    @Column(name = "parking_lot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parking_lot_name", nullable = false, length = 255)
    private String parkingLotName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "parkingLot")
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    @OneToMany(mappedBy = "parkingLot")
    private List<MonthlyPassVehicle> monthlyPassVehicles = new ArrayList<>();

    @Embedded
    @Column(nullable = false)
    private FeePolicy feePolicy;

    @Builder
    private ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public void initializeUser(User user) {
        user.addParkingLot(this);
    }

    public void addDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicies.add(discountPolicy);
    }

    public void addMonthlyPassVehicle(MonthlyPassVehicle monthlyPassVehicle) {
        this.monthlyPassVehicles.add(monthlyPassVehicle);
    }
}
