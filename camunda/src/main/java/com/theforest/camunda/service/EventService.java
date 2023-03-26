package com.theforest.camunda.service;

import com.theforest.camunda.dto.EventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {
    private final RuntimeService runtimeService;

    public String startProcess(EventDto eventDto) {
        Map<String, Object> variables = new HashMap<>();
        eventDto.setMessage(eventDto.getMessage() + " [INITIAL stage passed]");
        variables.put("isResult", eventDto.getResult());
        variables.put("eventDto", eventDto);
        String processId = UUID.randomUUID().toString();
        log.info("stage INITIAL");
        runtimeService.startProcessInstanceByKey("current_process", processId, variables);

        return MessageFormat.format("process {0} current event: {1}", processId, eventDto);
    }

    /**
     * waitingAction
     * @param processId
     * @return
     */
    public String moveWaitingEvent(String processId) {
        log.info("WAINING element - {}", processId);

        EventDto eventDto = (EventDto) runtimeService.getVariable(processId, "eventDto");
        eventDto.setMessage(eventDto.getMessage() + " [WAINING event passed]");

        runtimeService
                .createMessageCorrelation("waitingAction")
                .setVariable("eventDto", eventDto)
                .processInstanceId(processId)
                .correlate();

        return MessageFormat.format("waiting process {0} current event: {1}", processId, eventDto);
    }
}
