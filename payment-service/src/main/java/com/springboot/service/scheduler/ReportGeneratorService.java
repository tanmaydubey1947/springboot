package com.springboot.service.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Service
public class ReportGeneratorService {

    @Autowired
    private ReportService reportService;

    Logger logger = LoggerFactory.getLogger(ReportGeneratorService.class);

    @Value("${springboot.excel.report.file.path}")
    String FILEPATH;

    public void saveReport() throws IOException {
        byte[] report = reportService.generateReport();
        File file = new File(FILEPATH + "\\" + new Random().nextInt() + ".xlsx");
        OutputStream os = new FileOutputStream(file);
        os.write(report);
        logger.info("Report generated successfully...");
    }
}
