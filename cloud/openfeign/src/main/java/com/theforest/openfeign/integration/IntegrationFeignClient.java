package com.theforest.openfeign.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "integration", url = "http://localhost:8080")
public interface IntegrationFeignClient {
    @GetMapping("/connect")
    String connect();
}
