package test;

import com.baufest.bat.core.helpers.browser.BrowserHelper;
import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.helpers.screenShot.ScreenShotManager;

public class main {

    static LogManager logManager = new LogManager();
    static ScreenShotManager screenShotManager = new ScreenShotManager();
    static BrowserHelper browserHelper = new BrowserHelper();


    public static void main (String [ ] args) throws Exception {


        Thread.sleep(3000);

        browserHelper.setupBrowser();
        browserHelper.navigateTo();
        logManager.startTest("Login Valido","descrip","category","miguel","Inicio del Caso de Prueba 'HOLA MUNDO'");

        logManager.logInfo("dssdsddsdsds");
        logManager.logInfo("dssdsddsdsds");
        logManager.logInfo("dssdsddsdsds");
        logManager.logInfo("dssdsddsdsds");
        logManager.logPass("paso perfecto");

        browserHelper.resetBrowser();
        browserHelper.closeBrowser();

        logManager.endTest();

    }
}
