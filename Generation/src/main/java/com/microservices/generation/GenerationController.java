package com.microservices.generation;

import com.microservices.generation.dto.GenerationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dionnys on 4/5/16.
 */
@Controller
public class GenerationController {
    @Autowired
    private GenerationService generationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getTestCases() {
        return new ResponseEntity(
                generationService.generateTestCases(),
                HttpStatus.CREATED);
    }
}
