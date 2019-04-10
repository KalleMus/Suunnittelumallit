package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.LoggerSingleton;

/**
 * LogBox is a singleton pattern GUI widget that displays the different log messages.
 */
public class LogBox {

	private VBox logVBox;
	private LoggerSingleton logger = null;
	private static LogBox instance = null;


	/**
	 * Private constructor for following the singleton pattern.
	 */
	private LogBox() {
		logger = LoggerSingleton.getInstance();
		logger.setLogBox(this);
	}

	/**
	 * Creates an instance of the LogBox if it doesn't exist.
	 * @return instance of the LogBox
	 */
	public static LogBox getInstance() {
		if (instance == null) {
			instance = new LogBox();
		}
		return instance;
	}

	/**
	 * Create the logger GUI widget. Called by the main view.
	 * @return HBox node containing the whole widget.
	 */
	public HBox createLoggerWidget() {
		Label loggerTitleLabel = new Label("Logger");
		loggerTitleLabel.setId("loggerTitleLabel");
		logVBox = new VBox(loggerTitleLabel);
		logVBox.setId("logVBox");
		logVBox.setAlignment(Pos.TOP_CENTER);
		HBox logHBox = new HBox(logVBox);
		logHBox.setId("logHBox");
		logHBox.getStylesheets().add("logBox.css");
		return logHBox;
	}

	public VBox getLogVBox() {
		return logVBox;
	}

	public LoggerSingleton getLogger() {
		return logger;
	}
}
