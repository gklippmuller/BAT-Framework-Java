package test;

import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.helpers.screenShot.ScreenShotManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class main {

    static LogManager logManager = new LogManager();
    static ScreenShotManager screenShotManager = new ScreenShotManager();

    private static WebDriver driver;




    public static void main (String [ ] args) throws Exception {

        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/conf/resources/FirefoxDriver/win/geckodriver.exe");
        driver = new FirefoxDriver();

        Thread.sleep(3000);

        logManager.startTest("Login Valido","descrip","category","miguel","Inicio del Caso de Prueba 'HOLA MUNDO'");
        logManager.logInfo("Click en Login");
        logManager.logInfo("Inserta el Usuario");
        logManager.logInfo("Inserta La Clave");
        logManager.logInfo("Click en el Boton Login");
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");
        screenShotManager.screenShot(driver);
        logManager.logPass("Validado Exitosamente");











        logManager.endTest();

    }
}
