package com.jjw.photoparking.domain.discountpolicy;

import lombok.Getter;

@Getter
public enum DiscountType {

    PERCENTAGE("정률할인"), AMOUNT("정액할인");

    private final String description;

    DiscountType(String description) {
        this.description = description;
    }
}
