package com.springboot.service.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.ZonedDateTime;

@Service
public class JobService {

    @Autowired
    private ReportGeneratorService reportGeneratorService;

    @Scheduled(cron ="${cron_val}")
    public void process() throws IOException {
        System.out.println("Current Date Time is " + ZonedDateTime.now());
        reportGeneratorService.saveReport();
    }


}
