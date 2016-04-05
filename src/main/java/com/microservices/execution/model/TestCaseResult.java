package com.microservices.execution.model;

import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
public class TestCaseResult {
    private String id;
    private String testCaseId;
    private boolean success;
    private String message;

    public TestCaseResult(String testCaseId, boolean success) {
        this.testCaseId = testCaseId;
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
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
