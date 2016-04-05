package com.microservices;

import com.microservices.execution.ExecutionService;
import com.microservices.execution.model.TestCaseResult;
import com.microservices.generation.GenerationService;
import com.microservices.scheduler.SchedulerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
