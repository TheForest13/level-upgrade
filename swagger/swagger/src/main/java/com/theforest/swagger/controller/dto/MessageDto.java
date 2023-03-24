package com.theforest.swagger.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;

@Getter

@AllArgsConstructor
public class MessageDto {
    private String field1;

    private String field2;

    @AssertTrue(message = "Поля либо оба заполнены, либо оба пусты")
    private boolean isValid() {
        return StringUtils.isBlank(field1) && StringUtils.isBlank(field2) ||
                (!StringUtils.isBlank(field1) && !StringUtils.isBlank(field2));
    }
}
