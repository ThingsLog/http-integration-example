package com.thingslog.examples.integration.http;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThingsLogHttpIntegrationController {

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public void handleData(@RequestBody List<Measurement> measurements){
        System.out.println(measurements);
    }
}
