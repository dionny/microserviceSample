package com.microservices.scheduling;

import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
@Controller
public class ExecutionController {

    private ExecutionService executionService = ExecutionService.getInstance();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity beginTestExecution() {
        return new ResponseEntity(
                executionService.beginTestExecution(),
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "/executions", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getExecutions() {
        return new ResponseEntity(
                executionService.getExecutions(),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/executions/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getExecution(@PathVariable String id) {
        return new ResponseEntity(
                executionService.getExecution(UUID.fromString(id)),
                HttpStatus.OK);
    }

}
