package com.baufest.bat.core.logging;

import com.baufest.bat.core.logging.LogManager;

public class LogManager {

    private static LogManager instance = null;

    //private ScreenLogger screenLogger;
    //private FileLogger fileLogger;

    private LogManager() {

        //screenLogger = new ScreenLogger();
        //fileLogger = new FileLogger();

    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    public void log(String message) {
        //screenLogger.log(message);
        //fileLogger.log(message);
    }

    public void logInfo(String message) {
        //screenLogger.logInfo(message);
        //fileLogger.logInfo(message);
    }

    public void logWarning(String message) {
        //screenLogger.logWarning(message);
        //fileLogger.logWarning(message);
    }

    public void logError(String message) {
        //screenLogger.logError(message);
        //fileLogger.logError(message);
    }


}
