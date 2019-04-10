package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MainView houses the different log buttons and the LogBox logger widget.
 */
public class MainView {

	private LogBox logBox;
	private Stage visibleStage;
	private BorderPane borderPane;

	/**
	 * Create the MainView.
	 */
	public MainView() {
		Scene scene = new Scene(createBorderPane(), 800, 600);
		scene.getStylesheets().addAll("style.css");
		visibleStage = new Stage();
		visibleStage.setScene(scene);
		visibleStage.setOnCloseRequest(e -> onExit());
	}

	/**
	 * On exit handler. Called when the window's 'X' button is pressed.
	 */
	private void onExit() {
		System.out.println("Exiting");
		System.exit(0);
	}

	/**
	 * Create the main BorderPane. Called by the MainView's constructor.
	 * @return borderPane.
	 */
	private BorderPane createBorderPane() {
		borderPane = new BorderPane();
		borderPane.setId("mainBorderPane");
		borderPane.setTop(createTop());
		borderPane.setLeft(createLeft());
		borderPane.setCenter(createCenter());
		return borderPane;
	}

	/**
	 * Create top HBox for the borderPane.
	 * @return HBox
	 */
	private HBox createTop() {
		Label titleLabel = new Label("Singleton simulation");
		titleLabel.setId("titleLabel");
		HBox topHBox = new HBox(titleLabel);
		topHBox.setId("topHBox");
		return topHBox;
	}

	/**
	 * Create VBox for the left side of the borderPane.
	 * @return VBox
	 */
	private VBox createLeft() {
		Button createLoggerButton = new Button("Create a new logger");
		createLoggerButton.setId("createLoggerButton");
		createLoggerButton.setOnMouseClicked(e -> createLoggerButtonHandler());
		VBox leftVBox = new VBox(createLoggerButton);
		leftVBox.setId("leftVBox");
		leftVBox.setAlignment(Pos.TOP_CENTER);
		return leftVBox;
	}

	/**
	 * Create center VBox that houses 3 different log button for the borderPane.
	 * @return VBox
	 */
	private VBox createCenter() {
		VBox centerVBox = new VBox();
		centerVBox.setId("centerVBox");
		centerVBox.setAlignment(Pos.TOP_CENTER);

		// Log button
		Button logButton = new Button("Log");
		logButton.setId("logButton");
		logButton.setOnMouseClicked(e -> logButtonHandler());

		// Info button
		Button infoButton = new Button("Info");
		infoButton.setId("infoButton");
		infoButton.setOnMouseClicked(e -> infoButtonHandler());

		// Warning button
		Button warningButton = new Button("Warning");
		warningButton.setId("warningButton");
		warningButton.setOnMouseClicked(e -> warningButtonHandler());

		centerVBox.getChildren().addAll(logButton, infoButton, warningButton);

		return centerVBox;
	}

	private void logButtonHandler() {
		String message = "Log button clicked";
		if (logBox != null) {
			logBox.getLogger().log(message);
		}
	}

	private void infoButtonHandler() {
		String message = "Info button clicked";
		if (logBox != null) {
			logBox.getLogger().info(message);
		}
	}

	private void warningButtonHandler() {
		String message = "Warning button clicked";
		if (logBox != null) {
			logBox.getLogger().warning(message);
		}
	}

	/**
	 * Creates new logBox if it doesn't exists.
	 * Otherwise log that the box already exists.
	 */
	private void createLoggerButtonHandler() {
		if (logBox == null) {
			logBox = LogBox.getInstance();
			VBox currentLeft = createLeft();
			currentLeft.getChildren().addAll(logBox.createLoggerWidget());
			borderPane.setLeft(currentLeft);
		}
		else {
			logBox.getLogger().warning("Logger already exists");
		}
	}

	public Stage getVisibleStage() {
		return visibleStage;
	}
}
