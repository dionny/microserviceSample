package com.microservices.scheduler;

import com.microservices.scheduler.clients.ExecutionServiceClient;
import com.microservices.scheduler.dto.ScheduledExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class SchedulerService {

    @Autowired
    private ExecutionServiceClient executionClient;

    public SchedulerService() {
    }

    public SchedulerService(ExecutionServiceClient client) {
        this.executionClient = client;
    }

    public ScheduledExecution scheduleExecution() {
        return executionClient.beginExecution();
    }
}
