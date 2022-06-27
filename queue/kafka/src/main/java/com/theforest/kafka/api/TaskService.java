package com.theforest.kafka.api;

import com.theforest.kafka.model.Task;

public interface TaskService {
    void create(Task task);
}
