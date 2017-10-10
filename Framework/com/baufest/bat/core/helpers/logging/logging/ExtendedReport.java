package com.baufest.bat.core.helpers.logging.logging;

import com.baufest.bat.core.helpers.logging.BaseLogger;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendedReport extends BaseLogger {

    public void report(String message, String iType) {
        try
        {
            switch (iType) {
                case "PASS":
                    extent.getTest().log(LogStatus.PASS, message);
                    break;
                case "INFO":
                    extent.getTest().log(LogStatus.INFO, message);
                    break;
                case "WARNING":
                    extent.getTest().log(LogStatus.WARNING, message);
                    break;
                case "ERROR":
                    extent.getTest().log(LogStatus.ERROR, message);
                    break;
                case "FATAL":
                    extent.getTest().log(LogStatus.FATAL, message);
                    break;
                case "SKIP":
                    extent.getTest().log(LogStatus.SKIP, message);
                    break;
                default:

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void startReport(String message, String iType, String nameTest, String description, String category, String author) {
        try
        {
            switch (iType) {
                case "START":
                    extent.startTest(nameTest, description);
                    extent.getTest().assignCategory(category);
                    extent.getTest().assignAuthor(author);
                    break;
                default:

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void endReport() {
        try
        {
            extentManager.getReporter().endTest(extent.getTest());
            extentManager.getReporter().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
