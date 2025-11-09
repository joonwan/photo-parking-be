package com.jjw.photoparking.domain.parkinglot;

import jakarta.persistence.Embeddable;

@Embeddable
public class FeePolicy {

    // 기본 요금
    private int baseFee;

    // 기본 시간
    private int baseTime;

    // 추가 단위 시간 (분)
    private int additionalTimeUnit;

    // 추가 단위 가격
    private int additionalUnitFee;
}
