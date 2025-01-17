package com.baufest.bat.core.helpers.logging.logging;

import com.baufest.bat.core.helpers.logging.BaseLogger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

/**
 Write in the report according to the type of message
 * Created by Miguel D'Alessio
 * on 11/10/2017.
 */
public class ExtendedReport extends BaseLogger {

    /**
     The Desciption of the method to explain what the method does
     @param message
     @param iType
     @throws Exception
     */
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

    /**
     Start Report Manager (Extented Report)(report.html)
     @param message
     @param iType
     @param author
     @param category
     @param description
     @param nameTest
     @throws Exception
     */
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
    /**
     End the report generated by the automated tests (Extented Report)(report.html)
     @throws Exception
     */
    public void endReport() {
        try
        {
            extentManager.getReporter().endTest(extent.getTest());
            extentManager.getReporter().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     Add an image to report (Extented Report)(report.html)
     @throws Exception
     @param pathScreen
     */
    public void reportWithScreen(String pathScreen) {
        try
        {
            extent.getTest().log(LogStatus.INFO, extent.getTest().addScreenCapture(pathScreen));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
