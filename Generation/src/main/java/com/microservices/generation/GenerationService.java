package com.microservices.generation;

import com.microservices.generation.dto.GenerationRequest;
import com.microservices.generation.model.TestCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class GenerationService {
    public List<TestCase> generateTestCases() {
        List<TestCase> testCases = new ArrayList<>();
        testCases.add(new TestCase());
        testCases.add(new TestCase());
        return testCases;
    }
}
