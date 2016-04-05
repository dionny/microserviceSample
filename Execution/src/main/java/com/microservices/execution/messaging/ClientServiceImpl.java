package com.microservices.execution.messaging;

import com.microservices.execution.model.TestCaseExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl {
    private static final String SIMPLE_QUEUE = "simple.queue";
    
    private final JmsTemplate jmsTemplate;
    
    @Autowired
    public ClientServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    
    public void addTestCaseExecutionRequest(TestCaseExecution order) {
        jmsTemplate.convertAndSend(SIMPLE_QUEUE, order);
    }
}