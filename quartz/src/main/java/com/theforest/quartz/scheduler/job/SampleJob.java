package com.theforest.quartz.scheduler.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;

@Slf4j
@Component
@DisallowConcurrentExecution // аннотация, которая отмечает класс задания как класс, который не должен выполнять несколько экземпляров
public class SampleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final JobDetail jobDetail = context.getJobDetail();

        log.info("\n\nSampleJob executed: time - {}, thread: {}\n", LocalDateTime.now(),  Thread.currentThread().getName());
    }
}
