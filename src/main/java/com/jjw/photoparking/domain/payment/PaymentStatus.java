package com.jjw.photoparking.domain.payment;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("결제 대기"), COMPLETED("결제 완료");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }
}
