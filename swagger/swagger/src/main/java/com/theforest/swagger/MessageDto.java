package com.theforest.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;

@Getter
@AllArgsConstructor
public class MessageDto {
    private String filed1;
    private String filed2;

    @AssertTrue(message = "Поля либо заполнены, либо оба пусты")
    private boolean isValid() {
        return (StringUtils.isBlank(filed1) && StringUtils.isBlank(filed2)) ||
                (!StringUtils.isBlank(filed1) && !StringUtils.isBlank(filed2));
    }
}
