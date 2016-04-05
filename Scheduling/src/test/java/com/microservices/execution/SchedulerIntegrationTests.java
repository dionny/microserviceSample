package com.microservices.execution;

import com.microservices.execution.dto.Execution;
import com.microservices.scheduler.SchedulerService;
import com.microservices.scheduler.clients.ExecutionServiceClient;
import com.microservices.scheduler.dto.ScheduledExecution;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class SchedulerIntegrationTests {

    private SchedulerService service;

    @Before
    public void before() {
        ExecutionServiceClient client = new ExecutionServiceClient();
        service = new SchedulerService(client);
    }

	@Test
	public void testExecutionFlow() {
        ScheduledExecution scheduled =
                service.scheduleExecution();

        Execution execution = new RestTemplate().getForEntity(
                scheduled.getHref(),
                Execution.class
        ).getBody();

        assertEquals(2, execution.getTestCaseResults().size());
	}

}
