package com.theforest.openfeign.controller;

import com.theforest.openfeign.integration.IntegrationFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final IntegrationFeignClient integration;

    @GetMapping("/check")
    public String get(){
        return integration.connect();
    }

    @GetMapping("/connect")
    public String connect(){
        return "success";
    }
}
