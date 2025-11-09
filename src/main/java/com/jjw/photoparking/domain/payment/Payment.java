package com.jjw.photoparking.domain.payment;

import com.jjw.photoparking.domain.discountpolicy.DiscountPolicy;
import com.jjw.photoparking.domain.parkinglot.ParkingLot;
import com.jjw.photoparking.domain.parkingrecord.ParkingRecord;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_record_id")
    private ParkingRecord parkingRecord;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_policy_id")
    private DiscountPolicy discountPolicy;

    // 결제 금액
    private int paymentAmount;

    // 할인 전 금액
    private int originalAmount;

    // 할인후 금액
    private int discountedAmount;

    // 결제 방법
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    // 결제 상태
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    // 결제 일시
    private LocalDateTime paymentDate;

    @Builder
    private Payment(int paymentAmount, int originalAmount, int discountedAmount, PaymentMethod paymentMethod, PaymentStatus paymentStatus, LocalDateTime paymentDate) {
        this.paymentAmount = paymentAmount;
        this.originalAmount = originalAmount;
        this.discountedAmount = discountedAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public void initializeParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingLot.getPayments().add(this);
    }

    public void initializeParkingRecord(ParkingRecord parkingRecord) {
        this.parkingRecord = parkingRecord;
    }

    public void initializeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
