package com.theforest.micrometer.apiclient;

import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tarkovApiClient", url = "${tarkov.url}")
public interface TarkovApiClient {

    @Timed("gettingReportFromTarkov")
    @GetMapping("/api")
    String getTarkovReport();
}
