package com.theforest.docker.contorller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@Slf4j
@RestController
public class AppController {

    @GetMapping("/health")
    public ResponseEntity<String> sendHealthCheck() throws IOException {
        log.info("sendHealthCheck() - ok");
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("export.json");
        String data = readFromInputStream(inputStream);
        for (int i = 0; i < 7; i++) {
            for (String line : data.split("\n")) {
                log.info(line);
                for (CharSequence charSequence : line.split("")) {
                    log.info(charSequence.toString());
                }
            }
        }
        return ResponseEntity.ok("alive!");
    }

    @PostMapping("/health")
    public ResponseEntity<String> send(@RequestBody String msg) {
        log.info("send({})", msg);
        return ResponseEntity.ok("Send: " + msg);
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
