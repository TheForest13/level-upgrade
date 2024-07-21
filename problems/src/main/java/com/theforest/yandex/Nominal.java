package com.theforest.yandex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Nominal {
    NOMINAL_50(50),
    NOMINAL_100(100),
    NOMINAL_500(500),
    NOMINAL_1000(1000),
    NOMINAL_5000(5000);

    private int value;
}
