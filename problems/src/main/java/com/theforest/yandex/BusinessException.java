package com.theforest.yandex;

public class BusinessException extends RuntimeException{
    private String message;

    public BusinessException(String message) {
        super(message);
    }
}
