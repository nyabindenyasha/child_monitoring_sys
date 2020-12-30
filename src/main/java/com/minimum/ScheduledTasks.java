package com.minimum;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        System.out.println();
        final String uri = "http://www.glendoretracking.co.za/functions/hardwarecommunicator.php?regNumber=AAA-4579&long=28.540582&lat=-20.173766&fuelLevel=95&ignition=1&weight=300.34&hardware=true";
        System.out.println("uri: " + uri);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("result: " + result);
    }
}

