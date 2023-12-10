package com.theforest.docker.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AppController {

    @GetMapping("/health")
    public ResponseEntity<String> sendHealthCheck() {
        log.info("sendHealthCheck() - ok");
        return ResponseEntity.ok("alive!");
    }

    @PostMapping("/health")
    public ResponseEntity<String> send(@RequestBody String msg) {
        log.info("send({})", msg);
        return ResponseEntity.ok("Send: " + msg);
    }
}
