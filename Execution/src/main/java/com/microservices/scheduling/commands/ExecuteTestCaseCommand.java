package com.microservices.scheduling.commands;

import com.microservices.scheduling.dto.TestCase;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
public class ExecuteTestCaseCommand {
    @TargetAggregateIdentifier
    private UUID id;
    private UUID executionId;
    private TestCase testCase;

    public ExecuteTestCaseCommand() {
        id = UUID.randomUUID();
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
