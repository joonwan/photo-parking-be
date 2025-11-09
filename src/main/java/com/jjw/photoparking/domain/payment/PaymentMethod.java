package com.jjw.photoparking.domain.payment;

public enum PaymentMethod {
    CARD("카드"), CASH("현금"), TRANSFER("계좌이체");

    private String description;

    PaymentMethod(String description) {
        this.description = description;
    }
}
