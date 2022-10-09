package com.revature.customLogger.models;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that takes in any events and writes them to a file
 * 
 * @author Donato Manzione
 *
 */
public class Logger {

	// A singleton design pattern requires: (1) a static member; (2) a private
	// constructor; (3) a static factory method

	// (1) => static member
	private static Logger logger = new Logger();

	// (2) => private constructor

	private Logger() {
	}

	// (3) => static factory method
	public static Logger getlogger() {
		return logger;
	}

	private void writeToFile(String message) {
		try (FileWriter writer = new FileWriter(LocalDate.now().toString()+".log",true)) {

			writer.append(message+"\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void log(LogLevel logLevel, String message) {
		Log newLog = new Log(logLevel, LocalDateTime.now(), message);
		writeToFile(newLog.toString());
	}

	public void log(LogLevel logLevel, Exception e) {
		String message = e.getClass().toString();
		this.writeToFile(new Log(logLevel, LocalDateTime.now(), message).toString());
	}

	// enum for log levels
	public enum LogLevel {
		info, debug, verbose, warning, fatal, error
	}

	// nested Log class
	private class Log {
		LogLevel logLevel;
		LocalDateTime timestamp;
		String message;

		// parameterized constructor
		public Log(LogLevel logLevel, LocalDateTime timestamp, String message) {
			super();
			this.logLevel = logLevel;
			this.timestamp = timestamp;
			this.message = message;
		}

		@Override
		public String toString() {
			return "Log [logLevel=" + logLevel + ", timestamp=" + timestamp + ", message=" + message + "]";
		}

	}
}
