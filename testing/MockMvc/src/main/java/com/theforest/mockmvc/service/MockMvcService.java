package com.theforest.mockmvc.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MockMvcService {

    @SneakyThrows
    public MockMvcService() {
        log.info("MockMvcService start");
        TimeUnit.SECONDS.sleep(15);
        log.info("MockMvcService end");
    }

    public String test(String input) {
        return input + 1;
    }
}
