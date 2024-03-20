package com.theforest.camunda.delegate;

import com.theforest.camunda.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NegativeEventDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        EventDto eventDto = (EventDto) execution.getVariable("eventDto");
        eventDto.setMessage(eventDto.getMessage() + " [NEGATIVE stage passed]");

        log.info("stage NEGATIVE - {}", eventDto);

        execution.setVariable("eventDto", eventDto);

        throw new BpmnError("COMPENSATION_ERROR");
    }
}
