package com.microservices.scheduling;

import com.microservices.scheduling.dto.Execution;
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
	public void testExecutionFlow() throws InterruptedException {
        ScheduledExecution scheduled =
                service.scheduleExecution();

        // TODO: Given what we know so far, have a few alternatives here.
        // 1) Rather than an explicit delay, introduce an implicit delay.
        // 2) Listen for test case scheduling completed events within a specified buffer time.
        Thread.sleep(5000);

        Execution execution = new RestTemplate().getForEntity(
                scheduled.getHref(),
                Execution.class
        ).getBody();

        assertEquals(2, execution.getTestCaseExecutedEvents().size());
	}

}
