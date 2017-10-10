package com.baufest.bat.core.logging;

import com.baufest.bat.core.logging.logging.FileLogger;
import org.apache.log4j.Logger;
import com.baufest.bat.core.logging.logging.reportManager.ExtentTestManager;
import com.baufest.bat.core.logging.logging.reportManager.ExtentManager;

public class BaseLogger {

    private static BaseLogger instance = null;
    public static Logger logger = Logger.getLogger(FileLogger.class);
    public static ExtentTestManager extent;
    public static ExtentManager extentManager;
}
