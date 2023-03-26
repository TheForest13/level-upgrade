package com.theforest.camunda.delegate;

import com.theforest.camunda.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StartEventDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        EventDto eventDto = (EventDto) execution.getVariable("eventDto");

        log.info("stage START - {}", eventDto);

        if (eventDto.getMessage().contains("extraFinal")) {
            throw new BpmnError("extraFinalError");
        }

        eventDto.setMessage(eventDto.getMessage() + " [START stage passed]");

        execution.setVariable("eventDto", eventDto);
    }
}
