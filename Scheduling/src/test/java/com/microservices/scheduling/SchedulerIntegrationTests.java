package com.microservices.scheduling;

import com.microservices.scheduler.SchedulerService;
import com.microservices.scheduling.model.TestCaseResult;
import com.microservices.generation.GenerationService;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class SchedulerIntegrationTests {

	@Test
	public void testExecutionFlow() {
        GenerationService generationService = new GenerationService();

        ExecutionService executionService =
                new ExecutionService(generationService);

        generationService.setExecutionService(executionService);

        SchedulerService schedulerService
                = new SchedulerService(executionService);

        schedulerService.scheduleTestCases();

        List<TestCaseResult> results =
                executionService.getCompletedTestCases();

        assertEquals(2, results.size());
	}

}
