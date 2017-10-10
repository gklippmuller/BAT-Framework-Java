package com.baufest.bat.core.logging.logging;

import com.baufest.bat.core.logging.BaseLogger;
import org.apache.log4j.PropertyConfigurator;

public class FileLogger extends BaseLogger {

	public FileLogger() {
		
		super();
	}

	public void logger(String message, String iType) {

        try
        {
	        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
	        switch (iType) {
		        case "INFO":
			        logger.info(message);
			        break;
		        case "ERROR":
			        logger.error(message);
			        break;
		        case "WARNING":
			        logger.warn(message);
			        break;
		        case "FATAL":
			        logger.fatal(message);
			        break;
		        default:
			        logger.error("Tipo de mensaje no encontrado");
			        break;
	        }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
