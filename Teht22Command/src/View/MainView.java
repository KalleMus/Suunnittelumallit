package View;

import command.Command;
import command.LightsOffCommand;
import command.LightsOnCommand;
import invoker.ToggleButton;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import receiver.MyLight;

public class MainView {

	private Stage stage;
	private MyLight lightSpot;
	private Lighting lighting;
	private Scene scene;
	private Group group;
	private Command lightsOffCommand, lightsOnCommand;
	private ToggleButton toggleButton;
	private ImageView imageView;
	private Text text;

	public MainView() {

		// Setup light
		lightSpot = new MyLight();

		// Setup commands
		lightsOffCommand = new LightsOffCommand(lightSpot);
		lightsOnCommand = new LightsOnCommand(lightSpot);

		// Setup toggle button
		toggleButton = new ToggleButton(lightsOnCommand, lightsOffCommand);
		toggleButton.setText("Light switch");
		toggleButton.setId("button");
		toggleButton.setLayoutX(500);
		toggleButton.setLayoutY(250);
		toggleButton.setOnMouseClicked(e -> toggleButton.press());

		// Setup background image
		imageView = new ImageView(new Image("/view/black.png"));

		// Setup text
		text = new Text("Command pattern");
		text.setId("text");
		text.setX(150);
		text.setY(150);

		// Setup lighting effects.
		lighting = new Lighting();
		lighting.setLight(lightSpot);
		text.setEffect(lighting);
		imageView.setEffect(lighting);

		// Setup group, scene and stage.
		group = new Group(imageView, text, toggleButton);
		scene = new Scene(group, 600, 300);
		scene.setFill(Color.BLACK);
		stage = new Stage();
		scene.getStylesheets().add("/view/style.css");
		stage.setTitle("Command pattern - Light switch");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(e -> System.exit(0));
	}
}
