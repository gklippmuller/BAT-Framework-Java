package com.baufest.bat.core.helpers.logging;

import com.baufest.bat.core.enums.LogType;
import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.helpers.logging.logging.ExtendedReport;
import com.baufest.bat.core.helpers.logging.logging.FileLogger;
import org.openqa.selenium.WebDriver;

/**
 Write a message to the console, the .log file, and the report
 * Created by Miguel D'Alessio
 * on 09/10/2017.
 */
public class LogManager {

    private static LogManager instance = null;
    private ExtendedReport extendedReport;
    private FileLogger fileLogger;

    public LogManager() {

        extendedReport = new ExtendedReport();
        fileLogger = new FileLogger();
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    /**
     Start Report Manager (Extented Report)(report.html) and log
     @param message
     @param author
     @param category
     @param description
     @param nameTest
     @throws Exception
     */
    public void startTest(String nameTest, String description, String category, String author, String message) {

        fileLogger.logger(message, LogType.INFO.element());
        extendedReport.startReport(message, LogType.START.element(), nameTest, description, category, author);

    }

    /**
     Write message in the report and .log file (Extented Report)(report.html)
     @param message
     */
    public void logInfo(String message) {
        fileLogger.logger(message, LogType.INFO.element());
        extendedReport.report(message,LogType.INFO.element());
    }

    /**
     Write only to the file and to the console
     @param message
     */
    public void fileInfo(String message) {
        fileLogger.logger(message, LogType.INFO.element());
    }

    /**
     Write in the report and in the console if the case happened successfully
     @param message
     */
    public void logPass(String message) {

        fileLogger.logger(message, LogType.PASS.element());
        extendedReport.report(message,LogType.PASS.element());
    }

    /**
     Write in the report and in the console if the case Warning
     @param message
     */
    public void logWarning(String message) {

        fileLogger.logger(message, LogType.WARNING.element());
        extendedReport.report(message,LogType.WARNING.element());
    }

    /**
     Write in the report and in the console if the case Error
     @param message
     */
    public void logError(String message) {
        fileLogger.logger(message, LogType.ERROR.element());
        extendedReport.report(message,LogType.ERROR.element());
    }

    /**
     Write in the report and in the console if the case Fatal
     @param message
     */
    public void logFatal(String message) {
        fileLogger.logger(message, LogType.FATAL.element());
        extendedReport.report(message,LogType.FATAL.element());
    }

    /**
     End current test
     */
    public void endTest() {
        extendedReport.endReport();
    }

}
