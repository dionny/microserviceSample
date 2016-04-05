package com.microservices.scheduling.clients;

import com.microservices.scheduling.dto.GenerationRequest;
import com.microservices.scheduling.dto.TestCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
@Service
public class GenerationServiceClient {

    private RestTemplate restTemplate;

    public GenerationServiceClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<TestCase> getTestCases(GenerationRequest request) {
        ResponseEntity<TestCase[]> response =
                restTemplate.getForEntity("http://localhost:9001/", TestCase[].class);

        return Arrays.asList(response.getBody());
    }
}
