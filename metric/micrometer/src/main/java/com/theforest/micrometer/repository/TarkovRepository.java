package com.theforest.micrometer.repository;

import com.theforest.micrometer.entity.TarkovReportEntity;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarkovRepository extends CrudRepository<TarkovReportEntity, Long> {
    @Timed("gettingPricesFromDB")
    List<TarkovReportEntity> findAll();
}
