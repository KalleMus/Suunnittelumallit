package View;

import controller.MwController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.Main;


public class MainView {

	private final int mainPaneSize = 384;
	private int currentPlayer = 0;
	private Main main;
	private TileFactory tileFactory;
	private MwController controller;
	private Label currentPlayerLabel;
	private StackPane rootPane, mainPane;
	private VBox vBox;
	private Button resetButton;
	private Scene scene;
	private Stage mainStage;

	public MainView(Main main) {
		this.main = main;
		controller = new MwController(this);
		tileFactory = new TileFactory();
		createMainStage();
	}

	private void createMainStage() {
		createCurrentPlayerLabel();
		createMainPane();
		createResetButton();
		createVbox();
		createRootPane();
		createScene();
		mainStage = new Stage();
		mainStage.setScene(scene);
	}

	private void createCurrentPlayerLabel() {
		currentPlayerLabel = new Label("player: " + currentPlayer );
		currentPlayerLabel.setId("playerLabel");
	}

	private void createResetButton() {
		resetButton = new Button("Reset");
		resetButton.setId("resetButton");
		resetButton.setOnMouseClicked(e -> {
			System.out.println("Reset clicked");
		});
	}

	private void createMainPane() {
		mainPane = new StackPane(createGrid());
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

	public Stage getMainStage() {
		return mainStage;
	}

	private Pane createGrid() {
		tileFactory = new TileFactory();
		Pane pane = new Pane();
		int x = 0, y = 0;
		int increment = tileFactory.getTileSize();
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				Tile t = tileFactory.createTile(x, y, i, j);
				t.setOnMouseClicked(e -> {
					if (!controller.isGameOver() && !t.isChecked()) {
						t.check(currentPlayer);
						controller.handleClick(t.getGridX(), t.getGridY());
					}
				});
				pane.getChildren().add(t);
				x += increment;
			}
			x = 0;
			y += increment;
		}
		return pane;
	}

	public MwController getController() {
		return controller;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
		Platform.runLater(() -> {
			currentPlayerLabel.setText("Player: " + (currentPlayer));
		});
	}

	public void winner(int player) {
		Platform.runLater(() -> {
			if (player == 1) {
				currentPlayerLabel.setTextFill(Color.RED);
			}
			else {
				currentPlayerLabel.setTextFill(Color.GREEN);
			}
			currentPlayerLabel.setText("Player" + player + " WINS!");
			currentPlayerLabel.setId("winnerLabel");
		});
	}
}
