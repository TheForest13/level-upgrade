package com.theforest.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Operation(summary = "Get message \"hello\"")
    @ApiResponse(responseCode = "200", description = "get message hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
