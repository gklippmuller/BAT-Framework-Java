package baufest.bat.core.helpers.logging.logging;

import baufest.bat.core.helpers.logging.BaseLogger;

import java.io.*;
import java.text.SimpleDateFormat;

public class FileLogger extends BaseLogger {
	
	private String logFilePath;
	private String logFileName;
	
	public FileLogger() {
		
		super();
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date());
		
		logFilePath = "logs/";
		logFileName = "log_"+timeStamp+".log";
		
		File miDir = new File (logFilePath);

		if(!miDir.exists()) {
			miDir.mkdirs();
		}
	}
	
	public void log(String message) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
        try
        {
            fichero = new FileWriter(this.logFilePath+this.logFileName,true);
            pw = new PrintWriter(fichero);
            pw.println(message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

		
	}


}
