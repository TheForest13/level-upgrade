package com.theforest.micrometer.service;

import com.theforest.micrometer.apiclient.TarkovApiClient;
import com.theforest.micrometer.entity.TarkovReportEntity;
import com.theforest.micrometer.repository.TarkovRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
public class TarkovService {
    private final TarkovApiClient apiClient;
    private final TarkovRepository repository;
//    private volatile String currentLocation;


    public TarkovService(TarkovApiClient tarkovApiClient,
                         TarkovRepository tarkovRepository
//                         MeterRegistry meterRegistry
    ) {
        this.apiClient = tarkovApiClient;
        this.repository = tarkovRepository;
//        currentLocation = "none";
//        meterRegistry.gauge("currentLocation", currentLocation);
    }

//    @Transactional
//    public void saveReport() {
//        String report = apiClient.getTarkovReport();
//        log.info("report - {}", report);
//
//        TarkovReportEntity tarkovReportEntity = mapper.toEntity(report);
//        repository.save(tarkovReportEntity);
//    }

    public String getReport() {
        String tarkovReport = apiClient.getTarkovReport();
        return apiClient.getTarkovReport();
//        throw new RuntimeException();

    }

    public List<TarkovReportEntity> getCurrentLocation() {
        return repository.findAll();
//        throw new RuntimeException();
    }
}
