package com.microservices.execution;

import com.microservices.execution.clients.GenerationServiceClient;
import com.microservices.execution.dto.GenerationCriteria;
import com.microservices.execution.dto.GenerationRequest;
import com.microservices.execution.dto.TestCase;
import com.microservices.execution.model.Execution;
import com.microservices.execution.model.TestCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class ExecutionService {

    @Autowired
    private GenerationServiceClient generationClient;

    private List<Execution> currentExecutions;

    public ExecutionService() {
        this.currentExecutions = new ArrayList<>();
    }

    public Execution beginTestExecution() {
        // Generate.
        GenerationRequest request = new GenerationRequest();
        request.setModelId("1");
        request.setCriteria(GenerationCriteria.NodeCoverage);
        List<TestCase> testCases = generationClient.getTestCases(request);

        // Execute.
        Execution execution = new Execution();
        testCases.forEach(t -> executeTestCase(execution, t));
        currentExecutions.add(execution);

        return execution;
    }

    public void executeTestCase(Execution execution, TestCase testCase) {
        execution.getTestCaseResults().add(new TestCaseResult(testCase.getUuid(), true));
    }

    public List<Execution> getExecutions() {
        return currentExecutions;
    }

    public Execution getExecution(UUID uuid) {
        return currentExecutions
                .stream()
                .filter(e -> e.getUuid().equals(uuid))
                .findFirst()
                .get();
    }
}
