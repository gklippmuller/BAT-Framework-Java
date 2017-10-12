package com.baufest.bat.core.helpers.logging.logging;

import com.baufest.bat.core.helpers.logging.BaseLogger;
import org.apache.log4j.PropertyConfigurator;

/**
 File Logger Implementation (logger.log)
 * Created by Miguel D'Alessio
 * on 08/10/2017.
 */
public class FileLogger extends BaseLogger {

	public FileLogger() {
		
		super();
	}
	/**
	 Write a message to the console and to the .log file
	 @param message
	 @param iType
	 @throws Exception
	 */
	public void logger(String message, String iType) {

        try
        {
	        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
	        switch (iType) {
		        case "INFO":
			        logger.info(message);
			        break;
		        case "PASS":
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
