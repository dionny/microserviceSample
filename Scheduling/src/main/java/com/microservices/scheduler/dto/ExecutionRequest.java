package com.microservices.scheduler.dto;

import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
public class ExecutionRequest {
    private List<String> testCaseIds;

    public List<String> getTestCaseIds() {
        return testCaseIds;
    }

    public void setTestCaseIds(List<String> testCaseIds) {
        this.testCaseIds = testCaseIds;
    }
}
