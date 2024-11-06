package com.theforest.mockmvc.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MockMvcServiceTest {
    @Autowired
    private MockMvcService service;

    @Test
    void case1() {
        String actual = service.test("ku-ku");

        assertThat(actual)
                .isEqualTo("ku-ku");
    }
}