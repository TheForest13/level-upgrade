package com.theforest.kafka.service;

import com.theforest.kafka.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskListener {

    @KafkaListener(topics = "${topic.save}")
    public void executeTask(ConsumerRecord<String, Task> task) {
        log.info("\n\t TaskListener. Request: key - {}, value - {} \n", task.key(), task.value());
    }
}
