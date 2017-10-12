package com.baufest.bat.core.helpers.browser;

import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.readFiles.GetXMLfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 browser implementations
 * Created by Miguel D'Alessio
 * on 12/10/2017.
 */
public class BrowserHelper {

    private static BrowserHelper instance = null;
    private LogManager logManager = new LogManager();
    private GetXMLfile getXMLfile = new GetXMLfile();

    public WebDriver driver = null;
    private final String ABOUT_BLANK = "about:blank";

    /**
     Instance of the Browser
     @throws Exception
     */
    public static BrowserHelper getInstance() throws Exception {
        if (instance == null) {
            instance = new BrowserHelper();
        }
        return instance;
    }

    /**
     Browser settings, implicit timeout and maximize driver
     @throws IOException
     */
    public void setupBrowser() throws IOException {

        String browser = getXMLfile.GetConfigProperties("browser");
        String os = getXMLfile.GetConfigProperties("os");

        logManager.fileInfo("Iniciando Configuración del Navegador...");

        if (browser.equals("firefox")) {
            switch (os) {
                case "win":
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + getXMLfile.GetConfigProperties("firefox.win"));
                    driver = new FirefoxDriver();
                    logManager.fileInfo("Se inicio el Navegador utilizando: Firefox, Sistema Operativo: Windows");
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + getXMLfile.GetConfigProperties("firefox.mac"));
                    driver = new FirefoxDriver();
                    logManager.fileInfo("Se inicio el Navegador utilizando: Firefox, Sistema Operativo: Mac");
                    break;
            }
        } else {
            switch (os) {
                case "win":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getXMLfile.GetConfigProperties("chrome.win"));
                    driver = new ChromeDriver();
                    logManager.fileInfo("Se inicio el Navegador utilizando: Chrome, Sistema Operativo: Windows");
                    break;
                default:

                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getXMLfile.GetConfigProperties("chrome.mac"));
                    driver = new ChromeDriver();
                    logManager.fileInfo("Se inicio el Navegador utilizando: Chrome, Sistema Operativo: Mac");
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        logManager.fileInfo("El Navegador se Configuro Exitosamente");
        setDriver(driver);
    }
    /**
     Restart WebDriver Browser
     @throws InterruptedException
     */
    public void resetBrowser() throws InterruptedException {
        if (driver != null) {

            logManager.fileInfo("Reciclando el Navegador");
            driver.manage().deleteAllCookies();
            driver.get(ABOUT_BLANK);
            Thread.sleep(2000);

        } else {
            logManager.fileInfo("Reseteando el Navegador");
            driver.quit();
            driver = null;
            setDriver(driver);
        }
    }
    /**
     Navigate to URL, url comes from 'config-properties'
     @throws Exception
     */
    public void navigateTo() throws Exception {

        String url = getXMLfile.GetConfigProperties("url");
        try {
            logManager.fileInfo("Navigating to URL '" + url + "'");
            driver.get(url);

        } catch (Exception e) {
            logManager.fileInfo("Failed to navigate to URL '" + url + "' - " + e.getMessage() + "");
            throw new Exception();
        }
    }
    /**
     Close WebDriver browser
     @throws Exception
     */
    public void closeBrowser() throws Exception {

        logManager.fileInfo("Closing the Web Browser");
        try {
            if (driver!=null) {
                driver.quit();
                driver = null;
                setDriver(driver);
            }
        }catch (Exception e) {
            logManager.fileInfo("Failed to close the Browser - "+e.getMessage());
            throw new Exception();
        }
    }

    /**
     get Driver
     @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     set Driver
     @param driver
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
