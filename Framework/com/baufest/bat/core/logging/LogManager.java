package com.baufest.bat.core.logging;

import com.baufest.bat.core.enums.LogType;
import com.baufest.bat.core.logging.LogManager;
import com.baufest.bat.core.logging.logging.FileLogger;

public class LogManager {

    private static LogManager instance = null;

    //private ScreenLogger screenLogger;
    private FileLogger fileLogger;

    public LogManager() {

        //screenLogger = new ScreenLogger();
        fileLogger = new FileLogger();

    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    public void logInfo(String message) {
        fileLogger.logger(message, LogType.INFO.element());
    }

    public void logWarning(String message) {
        fileLogger.logger(message, LogType.WARNING.element());
    }

    public void logError(String message) {
        fileLogger.logger(message, LogType.ERROR.element());
    }

    public void logFatal(String message) {
        fileLogger.logger(message, LogType.FATAL.element());
    }


}
