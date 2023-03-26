package com.theforest.camunda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EventDto implements Serializable {
    private String message;
    private Boolean result;

}
