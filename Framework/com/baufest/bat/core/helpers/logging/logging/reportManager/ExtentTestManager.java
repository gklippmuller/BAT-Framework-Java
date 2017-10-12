package com.baufest.bat.core.helpers.logging.logging.reportManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

/**
 Map the arguments to add them to the report
 * Created by Miguel D'Alessio
 * on 08/10/2017.
 */
public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();

    /**
     Get Test using id
     @return ExtentTest
     */
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    /**
     End current test
     */
    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    /**
     Start Test
     @param testName
     */
    public static ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    /**
     Start Test
     @param testName
     @param desc
     @return test
     */
    public static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
}