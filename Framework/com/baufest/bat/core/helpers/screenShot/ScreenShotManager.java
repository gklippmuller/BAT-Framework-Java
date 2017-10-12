package com.baufest.bat.core.helpers.screenShot;

import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.helpers.logging.logging.ExtendedReport;
import com.baufest.bat.core.helpers.screenShot.TakeScreenShot.TakeScreenShot;
import com.baufest.bat.core.readFiles.GetXMLfile;
import org.openqa.selenium.WebDriver;

/**
 * Use the screenshots
 * Created by Miguel D'Alessio
 * on 10/10/2017.
 */
public class ScreenShotManager {

    TakeScreenShot takeScreenShot = new TakeScreenShot();
    LogManager logManager = new LogManager();
    ExtendedReport extendedReport = new ExtendedReport();
    GetXMLfile getXMLfile = new GetXMLfile();


    /**
     * Add image to report and get image path
     *
     * @param driver
     * @param screenShotName
     * @throws Exception
     */
    public void screenShot(WebDriver driver, String screenShotName) throws Exception {

        String capture = getXMLfile.GetConfigProperties("take.screenshot");
        String pathScreenShot = takeScreenShot.getScreenshot(driver, screenShotName);
        logManager.logInfo("Se Realizo una Captura de Pantalla Exitosamente");
        if (capture.equals("true")) {
            extendedReport.reportWithScreen(pathScreenShot);
        }
        logManager.logInfo("Se Almaceno la imagen en la ruta: " + pathScreenShot);
    }
}