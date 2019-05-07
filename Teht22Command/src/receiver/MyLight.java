package receiver;

import javafx.scene.effect.Light;
import javafx.scene.paint.Color;

public class MyLight extends Light.Point {

	public MyLight() {
		super();
		setColor(Color.WHITE);
		turnOff();
	}

	public void turnOn() {
		setX(350);
		setY(50);
		setZ(400);
	}

	public void turnOff() {
		setX(350);
		setY(-300);
		setZ(400);
	}
}
