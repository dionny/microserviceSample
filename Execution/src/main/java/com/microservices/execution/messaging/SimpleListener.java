package com.microservices.execution.messaging;

import com.microservices.execution.ExecutionService;
import com.microservices.execution.dto.TestCase;
import com.microservices.execution.model.TestCaseExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleListener {
    private final ExecutionService executionService;
    
    @Autowired
    public SimpleListener(ExecutionService storeService) {
        this.executionService = storeService;
    }
    
    @JmsListener(destination = "simple.queue")
    public void receiveTestCase(TestCaseExecution testCaseExecution) throws InterruptedException {
        executionService.executeTestCase(testCaseExecution);
    }
}