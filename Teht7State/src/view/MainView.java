package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pokemon.Pokemon;

/**
 * Creates Pokemon instance and all the GUI components.
 */
public class MainView {

	private Label eventLabel;
	private ImageView pokeImageView;
	private Stage visibleStage;
	private Pokemon pokemon;
	private BorderPane mainPane;

	public MainView() {
		eventLabel = new Label("EVENTS");
		eventLabel.setId("eventLabel");
		pokemon = new Pokemon(this);
		updatePokeImage();
		visibleStage = new Stage();
		visibleStage.setScene(createScene());
		visibleStage.show();
		visibleStage.setOnCloseRequest(e -> System.exit(0));
	}

	private Scene createScene() {
		mainPane = new BorderPane();
		pokeImageView = new ImageView();
		mainPane.setCenter(pokeImageView);
		VBox bottomVBox = new VBox(eventLabel, createButtons());
		bottomVBox.setAlignment(Pos.CENTER);
		mainPane.setBottom(bottomVBox);
		Scene scene = new Scene(mainPane, 800, 600);
		scene.getStylesheets().add("styles.css");
		return scene;
	}

	private HBox createButtons() {
		Button attackButton = new Button("Attack");
		Button defendButton = new Button("Defend");
		Button moveButton = new Button("Move");
		Button levelUpButton = new Button("Level Up");
		Button resetButton = new Button("Reset");

		attackButton.setOnMouseClicked(e -> pokemon.attack());
		defendButton.setOnMouseClicked(e -> pokemon.defend());
		moveButton.setOnMouseClicked(e -> pokemon.move());
		levelUpButton.setOnMouseClicked(e -> pokemon.levelUp());
		resetButton.setOnMouseClicked(e -> pokemon.reset());

		HBox buttonsHBox = new HBox(attackButton, defendButton, moveButton, levelUpButton, resetButton);
		buttonsHBox.setAlignment(Pos.CENTER);
		buttonsHBox.setId("buttonsHBox");
		return buttonsHBox;
	}

	public void updateEventLabel(String text) {
		eventLabel.setText(text);
	}

	public void updatePokeImage() {
		Platform.runLater(() -> {
			pokeImageView = new ImageView(pokemon.getCurrentForm().getImage());
			mainPane.setCenter(pokeImageView);
		});
	}
}
