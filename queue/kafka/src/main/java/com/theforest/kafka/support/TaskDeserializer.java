package com.theforest.kafka.support;

import com.theforest.kafka.model.Task;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class TaskDeserializer extends JsonDeserializer<Task> {
}
