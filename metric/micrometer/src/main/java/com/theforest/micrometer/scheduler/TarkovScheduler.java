package com.theforest.micrometer.scheduler;

import com.theforest.micrometer.service.TarkovService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TarkovScheduler {
    private final TarkovService tarkovService;

    @Timed("gettingPriceScheduler")
//    @Scheduled(fixedDelay = 30_000)
    public void updatePrices() {
//        tarkovService.saveReport();
    }
}
