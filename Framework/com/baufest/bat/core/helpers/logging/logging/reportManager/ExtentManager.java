package com.baufest.bat.core.helpers.logging.logging.reportManager;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Create final report, directory and name to report
 * Created by Miguel D'Alessio
 * on 09/10/2017.
 */
public class ExtentManager{

    static ExtentReports extent;
    static String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
    static String destination = System.getProperty("user.dir") +"/test-output/report/"+dateName+".html";

    final static String filePath = destination;

    /**
     Validate path
     */
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }

        return extent;
    }
}
