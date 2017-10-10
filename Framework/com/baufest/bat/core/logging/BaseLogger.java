package com.baufest.bat.core.logging;

import com.baufest.bat.core.logging.logging.FileLogger;
import org.apache.log4j.Logger;

public class BaseLogger {

	private static BaseLogger instance = null;
	public static Logger logger = Logger.getLogger(FileLogger.class);

}
