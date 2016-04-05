package com.microservices.scheduling;

import com.microservices.scheduling.dto.GenerationCriteria;
import com.microservices.scheduling.dto.GenerationRequest;
import com.microservices.scheduling.model.TestCaseResult;
import com.microservices.generation.GenerationService;
import com.microservices.generation.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class ExecutionService {

    @Autowired
    private GenerationService generationService;

    private List<TestCaseResult> completedTestCases;

    public ExecutionService(GenerationService generationService) {
        this.completedTestCases = new ArrayList<>();
        this.generationService = generationService;
    }

    public void beginTestExecution() {
        GenerationRequest request = new GenerationRequest();
        request.setModelId("1");
        request.setCriteria(GenerationCriteria.NodeCoverage);
        generationService.generateTestCases(request);
    }

    public void executeTestCase(TestCase testCase) {
        completedTestCases.add(new TestCaseResult(testCase.getId(), true));
    }

    public List<TestCaseResult> getCompletedTestCases() {
        return completedTestCases;
    }
}
