package com.microservices.execution;

import com.microservices.execution.clients.GenerationServiceClient;
import com.microservices.execution.dto.GenerationCriteria;
import com.microservices.execution.dto.GenerationRequest;
import com.microservices.execution.dto.TestCase;
import com.microservices.execution.messaging.ClientServiceImpl;
import com.microservices.execution.model.Execution;
import com.microservices.execution.model.TestCaseExecution;
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

    @Autowired
    private ClientServiceImpl messageService;

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
        currentExecutions.add(execution);

        testCases.stream()
                .map(t -> {
                    TestCaseExecution testCaseExecution = new TestCaseExecution();
                    testCaseExecution.setExecutionId(execution.getUuid());
                    testCaseExecution.setTestCase(t);
                    return testCaseExecution;
                })
                .forEach(tce -> messageService.addTestCaseExecutionRequest(tce));

        return execution;
    }

    public void executeTestCase(TestCaseExecution testCaseExecution) throws InterruptedException {
        Thread.sleep(2000);
        getExecution(testCaseExecution.getExecutionId())
                .getTestCaseResults()
                .add(new TestCaseResult(testCaseExecution.getTestCase().getUuid(), true));
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
