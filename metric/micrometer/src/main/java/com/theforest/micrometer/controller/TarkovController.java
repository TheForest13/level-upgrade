package com.theforest.micrometer.controller;

import com.theforest.micrometer.service.TarkovService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TarkovController {
    private final TarkovService tarkovService;

    @GetMapping("/goons/current-location")
    public ResponseEntity<String> getCurrentLocation() {
        return ResponseEntity.ok(tarkovService.getReport());
    }

}
