package com.theforest.camunda.delegate;

import com.theforest.camunda.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FinalEventDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        EventDto eventDto = (EventDto) execution.getVariable("eventDto");
        eventDto.setMessage(eventDto.getMessage() + " [FINAL stage passed]");

        log.info("stage FINAL - {}", eventDto);

        execution.setVariable("eventDto", eventDto);
    }
}
