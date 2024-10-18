package com.theforest.micrometer.type;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum TarkovLocationType {
    CUSTOMS("Customs"),
    WOODS("Woods"),
    LIGHTHOUSE("Lighthouse"),
    SHORELINE("Shoreline"),
    OTHER("Other");
    private final String value;

    private static final Map<String, TarkovLocationType> map = new HashMap<>();

    static {
        for (TarkovLocationType location : TarkovLocationType.values()) {
            map.put(location.getValue(), location);
        }
    }

    public static TarkovLocationType fromValue(String value) {
        return map.get(value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
