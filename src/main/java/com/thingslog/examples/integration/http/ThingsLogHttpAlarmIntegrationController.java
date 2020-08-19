package com.thingslog.examples.integration.http;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThingsLogHttpAlarmIntegrationController {

    @RequestMapping(value = "/alarm", method = RequestMethod.POST)
    public void handleAlarm(@RequestBody Alarm alarm){
        System.out.println(alarm);
    }
}
