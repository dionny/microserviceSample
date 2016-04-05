package com.microservices.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dionnys on 4/5/16.
 */
@Controller
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity beginTestExecution() {
        return new ResponseEntity(
                schedulerService.scheduleExecution(),
                HttpStatus.CREATED);
    }
}
