package model;

import View.LogBox;
import javafx.scene.control.Label;

/**
 * LoggerSingleton model creates log messages and send them to LobBox GUI widget.
 */
public class LoggerSingleton {

	private static LoggerSingleton instance = null;
	private static LogBox logBox;
	private int logCount = 0;
	private final int LOGMAX = 10;

	/**
	 * Private constructor to follow the singleton pattern.
	 */
	private LoggerSingleton(){
		System.out.println("LoggerSingleton created.");
	}

	/**
	 * Creates an instance of the LoggerSingleton if it doesn't exist.
	 * @return an instance of the LoggerSingleton class.
	 */
	public static LoggerSingleton getInstance() {
		if (instance == null) {
			instance = new LoggerSingleton();
		}
		return instance;
	}

	/**
	 * Make necessary connection with the LogBox GUI widget.
	 * @param logBox GUI widget.
	 */
	public void setLogBox(LogBox logBox) {
		LoggerSingleton.logBox = logBox;
	}

	/**
	 * Creates basic blue colored log message and passes it into the logBox GUI widget.
	 * @param message to be logged.
	 */
	public void log(String message) {
		if (instance != null) {
			ensureLogCapacity();
			Label logLabel = new Label(message);
			logLabel.setId("logLabel");
			logBox.getLogVBox().getChildren().add(logLabel);
		}
	}

	/**
	 * Creates info green colored log message and passes it into the logBox GUI widget.
	 * @param message to be logged.
	 */
	public void info(String message) {
		if (instance != null) {
			ensureLogCapacity();
			Label infoLabel = new Label(message);
			infoLabel.setId("infoLabel");
			logBox.getLogVBox().getChildren().add(infoLabel);
		}
	}

	/**
	 * Creates warning yellow colored log message and passes it into the logBox GUI widget.
	 * @param message to be logged.
	 */
	public void warning(String message) {
		if (instance != null) {
			ensureLogCapacity();
			Label warningLabel = new Label(message);
			warningLabel.setId("warningLabel");
			logBox.getLogVBox().getChildren().add(warningLabel);
		}
	}

	/**
	 * Clears the logBox if it's about to fill with to much messages.
	 */
	private void ensureLogCapacity() {
		if (logCount == LOGMAX) {
			logBox.getLogVBox().getChildren().clear();
			logCount = 0;
		}
		else {
			logCount++;
		}
	}
}
