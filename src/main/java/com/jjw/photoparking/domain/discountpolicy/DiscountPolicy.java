package com.jjw.photoparking.domain.discountpolicy;

import com.jjw.photoparking.domain.BaseEntity;
import com.jjw.photoparking.domain.parkinglot.ParkingLot;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "discount_policy")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiscountPolicy extends BaseEntity {

    @Id
    @Column(name = "discount_policy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String discountPolicyName;

    @Enumerated(value = EnumType.STRING)
    private DiscountType discountType;

    private int discountAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @Builder
    private DiscountPolicy(String discountPolicyName, DiscountType discountType, int discountAmount) {
        this.discountPolicyName = discountPolicyName;
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    private void initializeParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingLot.addDiscountPolicy(this);
    }
}
