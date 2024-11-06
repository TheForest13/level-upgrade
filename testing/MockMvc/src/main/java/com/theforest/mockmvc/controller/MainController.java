package com.theforest.mockmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
public class MainController {

    @PostMapping("/send")
    public ResponseEntity<String> semd(@RequestBody final String body) {
        return ResponseEntity.ok("Hello World!");
    }
}
