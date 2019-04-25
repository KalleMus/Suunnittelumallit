package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Kello;
import model.Viisari;

public class ClockWidget implements Cloneable {

	private Kello kello;
	private Label typeLabel;
	private Canvas canvas;
	private HBox buttonsHbox;
	private MainView mainView;
	private double canvasSize = 200;
	private double center = canvasSize / 2;
	private double outerSize = canvasSize;
	private double innerSize = canvasSize - 10;
	private double dotSize = 5, dotPos = center - dotSize / 2;

	public ClockWidget(MainView mainView) {
		super();
		this.kello = new Kello();
		this.mainView = mainView;
		this.typeLabel = createTypeLabel("Original");
		draw();
		setButtonsHbox(createButtonsHbox(kello));
	}

	public ClockWidget shallowClone() {
		ClockWidget shallowCopy = null;
		try {
			// Copy clock
			shallowCopy = (ClockWidget) super.clone();
			shallowCopy.setKello(this.kello.shallowClone());

			// Copy gui elements
			shallowCopy.setButtonsHbox(createButtonsHbox(shallowCopy.getKello()));
			shallowCopy.setTypeLabel(createTypeLabel("Shallow Copy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shallowCopy;
	}

	public ClockWidget deepClone() {
		ClockWidget deepCopy = null;
		try {
			// Copy clock
			deepCopy = (ClockWidget) super.clone();

			// Copy clock's hands
			deepCopy.setKello(this.kello.deepClone());

			// Copy gui elements
			deepCopy.setButtonsHbox(createButtonsHbox(deepCopy.getKello()));
			deepCopy.setTypeLabel(createTypeLabel("Deep Copy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deepCopy;
	}

	private Label createTypeLabel(String type) {
		Label label = new Label(type);
		label.setStyle("-fx-font-size: 30px");
		return label;
	}

	private HBox createButtonsHbox(Kello tKello) {
		Button hourButton = new Button("Hours++");
		hourButton.setOnMouseClicked(e -> {
			tKello.incrementHours();
			mainView.updateGui();
		});
		Button minuteButton = new Button("Minutes++");
		minuteButton.setOnMouseClicked(e -> {
			tKello.incrementMinutes();
			mainView.updateGui();
		});
		Button secondButton = new Button("Seconds++");
		secondButton.setOnMouseClicked(e -> {
			tKello.incrementSeconds();
			mainView.updateGui();
		});
		return new HBox(hourButton, minuteButton, secondButton);
	}

	public void draw() {
		canvas = new Canvas(canvasSize, canvasSize);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.BLACK);
		gc.fillRoundRect(0, 0, outerSize, outerSize, outerSize, outerSize);
		gc.setFill(Color.WHITE);
		gc.fillRoundRect(5, 5, innerSize, innerSize, innerSize, innerSize);
		gc.setFill(Color.BLACK);
		gc.fillRoundRect(dotPos, dotPos, dotSize, dotSize, dotSize, dotSize);

		gc.setFill(Color.BLACK);
		gc.setLineWidth(10);
		gc.strokeLine(center, center, getHourHandXPos(), getHourHandYPos());

		gc.setLineWidth(5);
		gc.strokeLine(center, center, getMinutesHandXPos(kello.getMinuttiViisari()), getMinutesHandYPos(kello.getMinuttiViisari()));

		gc.setStroke(Color.RED);
		gc.setLineWidth(2);
		gc.strokeLine(center, center, getMinutesHandXPos(kello.getSekuntiViisari()), getMinutesHandYPos(kello.getSekuntiViisari()));
	}

	private double getHourHandXPos() {
		int time = kello.getTuntiViisari().getPointsTo();
		switch (time) {
			case 1: case 5:
				return center + center / 3;
			case 2: case 4:
				return canvasSize - center / 3;
			case 3:
				return canvasSize - center / 4;
			case 9:
				return center / 4;
			case 7: case 11:
				return center - center / 3;
			case 8: case 10:
				return center / 3;
			case 12: case 6:
				return canvasSize / 2;
		}
		return 0;
	}

	private double getHourHandYPos() {
		int time = kello.getTuntiViisari().getPointsTo();
		switch (time) {
			case 1: case 11:
				return center / 3;
			case 2: case 10:
				return center - center / 3;
			case 3: case 9:
				return center;
			case 6:
				return canvasSize - center / 4;
			case 5: case 7:
				return canvasSize - center / 3;
			case 8: case 4:
				return center + center / 3;
			case 12:
				return center / 4;
		}
		return 0;
	}

	private double getMinutesHandXPos(Viisari viisari) {
		int time = viisari.getPointsTo();
		double q = center / 15;
		switch (time) {
			case 1: case 29:
				return center + q;
			case 2: case 28:
				return center + q * 2;
			case 3: case 27:
				return center + q * 3;
			case 4: case 26:
				return center + q * 4;
			case 5: case 25:
				return center + q * 5;
			case 6: case 24:
				return center + q * 6;
			case 7: case 23:
				return center + q * 7;
			case 8: case 22:
				return center + q * 8;
			case 9: case 21:
				return center + q * 9;
			case 10: case 20:
				return center + q * 10;
			case 11: case 19:
				return center + q * 11;
			case 12: case 18:
				return center + q * 12;
			case 13: case 17:
				return center + q * 13;
			case 14: case 16:
				return center + q * 14;
			case 15:
				return canvasSize - q;

			case 30: case 60:
				return center;
			case 31: case 59:
				return center - q;
			case 32: case 58:
				return center - q * 2;
			case 33: case 57:
				return center - q * 3;
			case 34: case 56:
				return center - q * 4;
			case 35: case 55:
				return center - q * 5;
			case 36: case 54:
				return center - q * 6;
			case 37: case 53:
				return center - q * 7;
			case 38: case 52:
				return center - q * 8;
			case 39: case 51:
				return center - q * 9;
			case 40: case 50:
				return center - q * 10;
			case 41: case 49:
				return center - q * 11;
			case 42: case 48:
				return center - q * 12;
			case 43: case 47:
				return center - q * 13;
			case 44: case 46:
				return center - q * 14;
			case 45:
				return q;
		}
		return 0;
	}

	private double getMinutesHandYPos(Viisari viisari) {
		int time = viisari.getPointsTo();
		double q = center / 15;
		switch (time) {
			case 60:
				return 0;
			case 1: case 59:
				return q;
			case 2: case 58:
				return q * 2;
			case 3: case 57:
				return q * 3;
			case 4: case 56:
				return q * 4;
			case 5: case 55:
				return q * 5;
			case 6: case 54:
				return q * 6;
			case 7: case 53:
				return q * 7;
			case 8: case 52:
				return q * 8;
			case 9: case 51:
				return q * 9;
			case 10: case 50:
				return q * 10;
			case 11: case 49:
				return q * 11;
			case 12: case 48:
				return q * 12;
			case 13: case 47:
				return q * 13;
			case 14: case 46:
				return q * 14;
			case 15: case 45:
				return q * 15;

			case 16: case 44:
				return center + q;
			case 17: case 43:
				return center + q * 2;
			case 18: case 42:
				return center + q * 3;
			case 19: case 41:
				return center + q * 4;
			case 20: case 40:
				return center + q * 5;
			case 21: case 39:
				return center + q * 6;
			case 22: case 38:
				return center + q * 7;
			case 23: case 37:
				return center + q * 8;
			case 24: case 36:
				return center + q * 9;
			case 25: case 35:
				return center + q * 10;
			case 26: case 34:
				return center + q * 11;
			case 27: case 33:
				return center + q * 12;
			case 28: case 32:
				return center + q * 13;
			case 29: case 31:
				return center + q * 14;
			case 30:
				return canvasSize - q;
		}
		return 0;
	}

	public Kello getKello() {
		return kello;
	}

	public void setKello(Kello kello) {
		this.kello = kello;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public HBox getButtonsHbox() {
		return buttonsHbox;
	}

	public void setButtonsHbox(HBox buttonsHbox) {
		this.buttonsHbox = buttonsHbox;
	}

	public Label getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(Label typeLabel) {
		this.typeLabel = typeLabel;
	}
}
