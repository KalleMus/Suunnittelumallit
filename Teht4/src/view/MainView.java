package view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * MainView creates the GUI.
 */
public class MainView {

	private Stage currentStage;
	private ClockObserver clockObserver;

	/**
	 * Create connection to observer, create the currentStage and setup onCloseRequest.
	 * @param clockObserver
	 */
	public MainView(ClockObserver clockObserver) {
		this.clockObserver = clockObserver;
		currentStage = new Stage();
		currentStage.setScene(createMainScene());
		currentStage.setOnCloseRequest(e -> System.exit(0));
	}

	/**
	 * Called by Main.
	 * @return the currentStage to be rendered.
	 */
	public Stage getCurrentStage() {
		return currentStage;
	}

	/**
	 * Create the main GUI.
	 * Called by the MainView constructor.
	 * @return the created scene.
	 */
	private Scene createMainScene() {
		StackPane stackPane = new StackPane(clockObserver.getDigitalClockWidget());
		stackPane.setId("stackPane");
		Scene scene = new Scene(stackPane,800, 600);
		scene.getStylesheets().addAll("ClockObserver.css", "MainView.css");
		return scene;
	}
}
