package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private Scene scene;
	private BorderPane borderPane;
	private HBox hBox, bottomHBox;
	private Button resetButton, shallowCloneButton, deepCloneButton;
	private VBox originalClockWidgetBox, shallowCopyClockWidgetBox, deepCopyClockWidgetBox;
	private ClockWidget originalClockWidget, shallowCopyClockWidget, deepCopyClockWidget;

	public MainView() {
		createBorderPane();
		createHBox();
		createOriginalClockWidgetBox();
		createBottomHBox();
		createScene();
		createStage();
	}

	public void updateGui() {
		GuiThread guiThread = new GuiThread();
		guiThread.start();
	}

	private void createBorderPane() {
		borderPane = new BorderPane();
	}

	private void createHBox() {
		hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(50);
		borderPane.setCenter(hBox);
	}

	private void createBottomHBox() {
		resetButton = new Button("Reset");
		resetButton.setOnMouseClicked(e -> {
			hBox.getChildren().clear();
			createOriginalClockWidgetBox();
			hBox.getChildren().add(originalClockWidgetBox);
			shallowCopyClockWidgetBox = null;
			deepCopyClockWidgetBox = null;
		});
		shallowCloneButton = new Button("Shallow clone");
		shallowCloneButton.setOnMouseClicked(e -> {
			if (shallowCopyClockWidgetBox == null) {
				createShallowCopyClockWidgetBox();
				hBox.getChildren().add(shallowCopyClockWidgetBox);
			}
		});
		deepCloneButton = new Button("Deep clone");
		deepCloneButton.setOnMouseClicked(e -> {
			if (deepCopyClockWidgetBox == null) {
				createDeepCopyClockWidgetBox();
				hBox.getChildren().add(deepCopyClockWidgetBox);
			}
		});
		bottomHBox = new HBox(resetButton, shallowCloneButton, deepCloneButton);
		borderPane.setBottom(bottomHBox);
	}

	private void createOriginalClockWidgetBox() {
		originalClockWidget = new ClockWidget(this);
		originalClockWidgetBox = new VBox();
		originalClockWidgetBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(originalClockWidgetBox);
		updateGui();
	}

	private void createShallowCopyClockWidgetBox() {
		shallowCopyClockWidget = originalClockWidget.shallowClone();
		shallowCopyClockWidgetBox = new VBox();
		shallowCopyClockWidgetBox.setAlignment(Pos.CENTER);
		updateGui();
	}

	private void createDeepCopyClockWidgetBox() {
		deepCopyClockWidget = originalClockWidget.deepClone();
		deepCopyClockWidgetBox = new VBox();
		deepCopyClockWidgetBox.setAlignment(Pos.CENTER);
		updateGui();
	}

	private class GuiThread extends Thread {
		@Override
		public void run() {
			Platform.runLater(() -> {
				updateElement(originalClockWidgetBox, originalClockWidget);
				updateElement(shallowCopyClockWidgetBox, shallowCopyClockWidget);
				updateElement(deepCopyClockWidgetBox, deepCopyClockWidget);
			});
		}

		private void updateElement(VBox clockBox, ClockWidget clockWidget) {
			if (clockBox != null) {
				clockWidget.draw();
				clockBox.getChildren().clear();
				clockBox.getChildren().addAll(clockWidget.getCanvas(), clockWidget.getButtonsHbox(), clockWidget.getTypeLabel());
			}
		}
	}

	private void createScene() {
		scene = new Scene(borderPane, 800, 600);
	}

	private void createStage() {
		stage = new Stage();
		stage.setScene(scene);
		stage.setOnCloseRequest(e -> System.exit(0));
		stage.show();
	}
}
