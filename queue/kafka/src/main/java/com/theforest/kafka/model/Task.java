package com.theforest.kafka.model;

import lombok.Data;

@Data
public class Task {
    private String title;
    private String uid;
    private String description;
}
