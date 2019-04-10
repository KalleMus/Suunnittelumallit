package View;

import controller.MwController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main GUI
 */
public class MainView {

	private final int mainPaneSize = 384;
	private TileFactory tileFactory;
	private MwController controller;
	private Label currentPlayerLabel;
	private StackPane rootPane, mainPane;
	private VBox vBox;
	private Button resetButton, createButton;
	private Scene scene;
	private Stage mainStage;

	public MainView() {
		tileFactory = new TileFactory();
		createCurrentPlayerLabel();
		createMainPane();
		createGrid();
		createResetButton();
		createVbox();
		createRootPane();
		createScene();
		createMainStage();
		controller = new MwController(this);
	}

	private void createCurrentPlayerLabel() {
		currentPlayerLabel = new Label("");
		currentPlayerLabel.setId("playerLabel");
	}

	private void createResetButton() {
		resetButton = new Button("Reset");
		resetButton.setId("resetButton");
		resetButton.setOnMouseClicked(e -> {
			System.out.println("Reset clicked");
			resetButton.setVisible(false);
			createGrid();
			controller.resetGame();
		});
		createButton = new Button("Create");
		createButton.setId("createButton");
		createButton.setOnMouseClicked(e -> {
		});
	}

	private void createMainPane() {
		mainPane = new StackPane();
		mainPane.setMaxSize(mainPaneSize, mainPaneSize);
		mainPane.setId("mainPane");
	}

	private void createVbox() {
		vBox = new VBox(currentPlayerLabel, mainPane, resetButton);
		vBox.setId("vBox");
	}

	private void createRootPane() {
		rootPane = new StackPane();
		rootPane.setId("rootPane");
		rootPane.getChildren().clear();
		rootPane.getChildren().addAll(vBox);
	}

	private void createScene() {
		scene = new Scene(rootPane, 800, 600);
		scene.getStylesheets().addAll("/View/MainView.css");
	}

	private void createMainStage() {
		mainStage = new Stage();
		mainStage.setScene(scene);
		mainStage.show();
		mainStage.setOnCloseRequest(e -> System.exit(0));
	}

	private void createGrid() {
		System.out.println("createGrid() called");
		Pane pane = new Pane();
		tileFactory = new TileFactory();
		int x = 0, y = 0;
		int increment = tileFactory.getTileSize();
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				Tile t = tileFactory.createTile(x, y, i, j);
				t.setCheckedFalse();
				t.setOnMouseClicked(e -> {
					if (!controller.isGameOver() && !t.isChecked()) {
						t.check(controller.getCurrentPlayer());
						controller.handleClick(t.getGridX(), t.getGridY());
					}
				});
				pane.getChildren().add(t);
				x += increment;
			}
			x = 0;
			y += increment;
		}
		mainPane.getChildren().add(pane);
	}

	public Label getCurrentPlayerLabel() {
		return currentPlayerLabel;
	}

	public Button getResetButton() {
		return resetButton;
	}
}
