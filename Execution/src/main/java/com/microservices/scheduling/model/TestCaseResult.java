package com.microservices.scheduling.model;

import com.microservices.scheduling.ExecutionService;
import com.microservices.scheduling.commands.ExecuteTestCaseCommand;
import com.microservices.scheduling.events.TestCaseExecutedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class TestCaseResult extends AbstractAnnotatedAggregateRoot {
 
    @AggregateIdentifier
    private UUID id;

    @Autowired
    private ExecutionService executionService;

    private UUID executionId;
    private UUID testCaseId;
    private boolean success;
    private String message;
 
    public TestCaseResult() {
    }
 
    @CommandHandler
    public TestCaseResult(ExecuteTestCaseCommand command) throws InterruptedException {
        Thread.sleep(2000);
        TestCaseExecutedEvent event = new TestCaseExecutedEvent();
        event.setId(command.getId());
        event.setExecutionId(command.getExecutionId());
        event.setMessage("Test case executed successfully.");
        event.setSuccess(true);
        event.setTestCaseId(command.getTestCase().getUuid());

        System.out.println("Servicing event");
        ExecutionService.getInstance().addExecutionEvent(event);

        apply(event);
    }
 
    @EventHandler
    public void on(TestCaseExecutedEvent event) {
        this.id = event.getId();
        this.executionId = event.getExecutionId();
        this.testCaseId = event.getTestCaseId();
        this.success = event.isSuccess();
        this.message = event.getMessage();
    }

    public UUID getExecutionId() {
        return executionId;
    }

    public void setExecutionId(UUID executionId) {
        this.executionId = executionId;
    }

    public UUID getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(UUID testCaseId) {
        this.testCaseId = testCaseId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}