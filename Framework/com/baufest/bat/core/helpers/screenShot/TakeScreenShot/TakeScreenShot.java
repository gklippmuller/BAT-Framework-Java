package com.baufest.bat.core.helpers.screenShot.TakeScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Take ScreenShot
 * Created by Miguel D'Alessio
 * on 10/10/2017.
 */
public class TakeScreenShot {

    /**
     take a screen capture to save it in the path 'destination'
     @param driver
     @param screenshotName
     @return destination
     @throws Exception
     */
    public String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat("yyyy-MMdd-hh-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") +"/test-output/images/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
    }




}
