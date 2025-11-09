package com.jjw.photoparking.domain.parkinglot;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeePolicy {

    // 기본 요금
    private int baseFee;

    // 기본 시간
    private int baseTime;

    // 추가 시간 단위 (분)
    private int additionalTimeUnit;

    // 추가 시간당 요금
    private int additionalUnitFee;
}
