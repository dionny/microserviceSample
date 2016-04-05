package com.microservices.generation;

import com.microservices.scheduling.dto.GenerationRequest;
import com.microservices.scheduling.ExecutionService;
import com.microservices.generation.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class GenerationService {

    @Autowired
    private ExecutionService executionService;

    public void setExecutionService(ExecutionService executionService) {
        this.executionService = executionService;
    }

    public void generateTestCases(GenerationRequest request) {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase());
        testCases.add(new TestCase());
        testCases.forEach(t -> executionService.executeTestCase(t));
    }
}
