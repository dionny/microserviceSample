package com.microservices.scheduler.clients;

import com.microservices.scheduler.dto.ScheduledExecution;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class ExecutionServiceClient {
    private RestTemplate restTemplate;

    public ExecutionServiceClient() {
        this.restTemplate = new RestTemplate();
    }

    public ScheduledExecution beginExecution() {
        ResponseEntity<ScheduledExecution> response =
                restTemplate.postForEntity("http://localhost:9002/", null, ScheduledExecution.class);

        return response.getBody();
    }
}
