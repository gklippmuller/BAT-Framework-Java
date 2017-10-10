package com.baufest.bat.core.helpers.logging;

import com.baufest.bat.core.helpers.logging.logging.FileLogger;
import com.baufest.bat.core.helpers.logging.logging.reportManager.ExtentManager;
import org.apache.log4j.Logger;
import com.baufest.bat.core.helpers.logging.logging.reportManager.ExtentTestManager;


public class BaseLogger {

    private static BaseLogger instance = null;
    public static Logger logger = Logger.getLogger(FileLogger.class);
    public static ExtentTestManager extent;
    public static ExtentManager extentManager;
}
