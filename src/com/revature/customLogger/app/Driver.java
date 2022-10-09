package com.revature.customLogger.app;

import com.revature.customLogger.models.Logger;
import com.revature.customLogger.models.Logger.LogLevel;

public class Driver {

	//singleton
	private static Logger logger = Logger.getlogger();
	
	public static void main(String[] args) {
		//regular logger
		logger.log(LogLevel.warning, "test logger");
		
		//logger with exception
		try {
			int number = 4/0;//arithmetic exception will be thrown
		}catch(ArithmeticException aE) {
		  logger.log(LogLevel.error, aE);
		}
	}
}
