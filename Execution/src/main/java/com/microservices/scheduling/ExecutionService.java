package com.microservices.scheduling;

import com.microservices.scheduling.clients.GenerationServiceClient;
import com.microservices.scheduling.dto.GenerationCriteria;
import com.microservices.scheduling.dto.GenerationRequest;
import com.microservices.scheduling.dto.TestCase;
import com.microservices.scheduling.configuration.AxonConfiguration;
import com.microservices.scheduling.commands.ExecuteTestCaseCommand;
import com.microservices.scheduling.events.TestCaseExecutedEvent;
import com.microservices.scheduling.model.Execution;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class ExecutionService {

    private GenerationServiceClient generationClient
            = new GenerationServiceClient();

    private List<Execution> currentExecutions;

    private ExecutionService() {
        this.currentExecutions =
                Collections.synchronizedList(new ArrayList<>());
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
                    ExecuteTestCaseCommand executeTestCaseCommand = new ExecuteTestCaseCommand();
                    executeTestCaseCommand.setExecutionId(execution.getUuid());
                    executeTestCaseCommand.setTestCase(t);
                    return executeTestCaseCommand;
                })
                .forEach(tce -> AxonConfiguration.getGateway().send(tce));

        return execution;
    }

    @EventHandler
    public void on(TestCaseExecutedEvent event) {
        getExecution(event.getExecutionId()).getTestCaseExecutedEvents()
                .add(event);
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

    private static ExecutionService instance = new ExecutionService();

    public static ExecutionService getInstance() {
        return instance;
    }

    public void addExecutionEvent(TestCaseExecutedEvent event) {
        getExecution(event.getExecutionId())
                .getTestCaseExecutedEvents()
                .add(event);
    }
}
