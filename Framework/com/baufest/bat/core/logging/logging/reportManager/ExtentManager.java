package com.baufest.bat.core.logging.logging.reportManager;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager{

    static ExtentReports extent;
    static String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
    static String destination = System.getProperty("user.dir") +"/test-output/report/"+dateName+".html";

    final static String filePath = destination;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }

        return extent;
    }
}
