package com.theforest.kafka.web;

import com.theforest.kafka.api.TaskService;
import com.theforest.kafka.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public void create(@RequestBody Task task) {
        task.setUid(UUID.randomUUID().toString());
        log.info("Create to: {}", task);
        taskService.create(task);
    }
}
