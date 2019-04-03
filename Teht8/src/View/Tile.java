package View;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

	private boolean p1checked = false;
	private boolean p2checked = false;
	private int gridX, gridY;
	private Color stroke = Color.BLACK;
	private Color color = Color.WHITE;
	private Color p1checkedColor = Color.RED;
	private Color p2checkedColor = Color.GREEN;

	public Tile(int tileSize, int x, int y, int gridX, int gridY) {
		super(tileSize, tileSize);
		super.setX(x);
		super.setY(y);
		this.gridX = gridX;
		this.gridY = gridY;
		super.maxWidth(tileSize);
		super.minWidth(tileSize);
		super.maxHeight(tileSize);
		super.minHeight(tileSize);
		super.setFill(color);
		super.setStroke(stroke);
		super.setStrokeWidth(2);
	}

	public void check(int playerNum) {
		if (playerNum == 1) {
			super.setFill(p1checkedColor);
			p1checked = true;

		}
		else {
			super.setFill(p2checkedColor);
			p2checked = true;
		}
	}

	@Override
	public String toString() {
		return gridX + ", " + gridY;
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public boolean isChecked() {
		if (p1checked) return true;
		else if (p2checked) return true;
		else return false;
	}
}
