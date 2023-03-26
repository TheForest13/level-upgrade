package com.theforest.camunda.controller;

import com.theforest.camunda.dto.EventDto;
import com.theforest.camunda.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EventProcessController {

    private final EventService eventService;

    @PostMapping("/new-event")
    public String startEvent(@RequestBody EventDto event) {
        log.info("event: {}", event);

        return eventService.startProcess(event);
    }

    @PostMapping("/{processId}/waiting-event")
    public String moveWaitingEvent(@PathVariable String processId) {
        log.info("waiting event: processId {}", processId);

        return eventService.moveWaitingEvent(processId);
    }

}
