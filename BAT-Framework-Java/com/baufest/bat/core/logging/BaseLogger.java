package com.baufest.bat.core.logging;

import java.text.SimpleDateFormat;

public class BaseLogger {

	private static BaseLogger instance = null;
	static final String PREFIX = ">>";
	static final String INFO = "INFO";
	static final String WARNING = "WARNING";
	static final String ERROR = "ERROR";

	protected BaseLogger() {
		// Exists only to defeat instantiation.

	}

	public static BaseLogger getInstance() {
		if (instance == null) {
			instance = new BaseLogger();
		}
		return instance;
	}
	
	public void logInfo(String message) {
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		
		this.log(this.PREFIX+" " + timeStamp+ " "+this.INFO+": "+message );
	
	}
	
	public void logWarning(String message) {
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		
		this.log(this.PREFIX+" " + timeStamp+ " "+this.WARNING+": "+message );
	}
	
	public void logError(String message) {
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		
		this.log(this.PREFIX+" " + timeStamp+ " "+this.ERROR+": "+message );
	}

	

	public void log(String message) {
		// TODO Auto-generated method stub
		
	}
	


}
