package com.microservices.execution.model;

import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
public class TestCaseResult {
    private UUID id;
    private UUID testCaseId;
    private boolean success;
    private String message;

    public TestCaseResult(UUID testCaseId, boolean success) {
        this.testCaseId = testCaseId;
        this.success = success;
        this.id = UUID.randomUUID();
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

    public UUID getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(UUID testCaseId) {
        this.testCaseId = testCaseId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
