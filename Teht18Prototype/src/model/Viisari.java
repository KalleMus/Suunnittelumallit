package model;

public class Viisari implements Cloneable {
	private int pointsTo;
	private int width;
	private int length;
	private String type;

	public Viisari(String type, int width, int length) {
		this.pointsTo = 1;
		this.type = type;
		this.width = width;
		this.length = length;
	}

	public Viisari deepClone() {
		Viisari rViisari = null;
		try {
			rViisari = (Viisari) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return rViisari;
	}

	public String toString() {
		return type + " osoittaa: " + pointsTo + " pituus: " + length + " leveys: " + width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getPointsTo() {
		return pointsTo;
	}

	public void setPointsTo(int pointsTo) {
		this.pointsTo = pointsTo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
