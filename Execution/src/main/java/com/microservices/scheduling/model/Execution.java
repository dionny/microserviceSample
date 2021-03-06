package com.microservices.scheduling.model;

import com.microservices.scheduling.events.TestCaseExecutedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
public class Execution {
    private UUID uuid;
    private UUID modelId;
    private ExecutionStatus status;
    private List<TestCaseExecutedEvent> testCaseExecutedEvents;

    public Execution() {
        this.uuid = UUID.randomUUID();
        this.testCaseExecutedEvents = new ArrayList<>();
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getModelId() {
        return modelId;
    }

    public void setModelId(UUID modelId) {
        this.modelId = modelId;
    }

    public List<TestCaseExecutedEvent> getTestCaseExecutedEvents() {
        return testCaseExecutedEvents;
    }

    public void setTestCaseExecutedEvents(List<TestCaseExecutedEvent> testCaseExecutedEvents) {
        this.testCaseExecutedEvents = testCaseExecutedEvents;
    }
}
