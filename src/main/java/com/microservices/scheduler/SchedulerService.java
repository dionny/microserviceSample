package com.microservices.scheduler;

import com.microservices.dto.SchedulingResult;
import com.microservices.execution.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class SchedulerService {

    @Autowired
    private ExecutionService executionService;

    public SchedulerService() {
    }

    public SchedulerService(ExecutionService executionService) {
        this.executionService = executionService;
    }

    public SchedulingResult scheduleTestCases() {
        executionService.beginTestExecution();
        return new SchedulingResult(true);
    }
}
