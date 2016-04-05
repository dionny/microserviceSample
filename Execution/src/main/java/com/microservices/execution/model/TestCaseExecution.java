package com.microservices.execution.model;

import com.microservices.execution.dto.TestCase;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
public class TestCaseExecution implements Serializable {
    private UUID executionId;
    private TestCase testCase;

    public UUID getExecutionId() {
        return executionId;
    }

    public void setExecutionId(UUID executionId) {
        this.executionId = executionId;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }
}
