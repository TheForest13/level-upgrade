package com.theforest.kafka.service;

import com.theforest.kafka.api.TaskService;
import com.theforest.kafka.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Value("${topic.save}")
    private String topicSaveName;
    private final KafkaTemplate<String, Task> kafkaTemplate;

    @Override
    public void create(Task task) {
        ListenableFuture<SendResult<String, Task>> send = kafkaTemplate.send(topicSaveName, task.getUid(), task);
        send.addCallback(new ListenableFutureCallback<SendResult<String, Task>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Failure send: {}", ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Task> result) {
                log.info("Success send: {}", result);
            }
        });
        kafkaTemplate.flush();
    }
}
