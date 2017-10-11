package com.baufest.bat.core.helpers.logging;

import com.baufest.bat.core.enums.LogType;
import com.baufest.bat.core.helpers.logging.LogManager;
import com.baufest.bat.core.helpers.logging.logging.ExtendedReport;
import com.baufest.bat.core.helpers.logging.logging.FileLogger;
import org.openqa.selenium.WebDriver;

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

    public void startTest(String nameTest, String description, String category, String author, String message) {

        fileLogger.logger(message, LogType.INFO.element());
        extendedReport.startReport(message, LogType.START.element(), nameTest, description, category, author);

    }
    public void logInfo(String message) {
        fileLogger.logger(message, LogType.INFO.element());
        extendedReport.report(message,LogType.INFO.element());
    }
    public void logPass(String message) {

        fileLogger.logger(message, LogType.PASS.element());
        extendedReport.report(message,LogType.PASS.element());
    }
    public void logWarning(String message) {

        fileLogger.logger(message, LogType.WARNING.element());
        extendedReport.report(message,LogType.WARNING.element());
    }

    public void logError(String message) {
        fileLogger.logger(message, LogType.ERROR.element());
        extendedReport.report(message,LogType.ERROR.element());
    }

    public void logFatal(String message) {
        fileLogger.logger(message, LogType.FATAL.element());
        extendedReport.report(message,LogType.FATAL.element());
    }
    public void endTest() {
        extendedReport.endReport();
    }

}
