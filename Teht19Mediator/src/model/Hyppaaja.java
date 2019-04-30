package model;

public class Hyppaaja {

	private int number;
	private String name;
	private Hyppy[] hypyt = new Hyppy[2];

	public Hyppaaja(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public Hyppy hyppaa() {
		return new Hyppy();
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void lisääHyppy(Hyppy hyppy) {
		if (hypyt[0] == null) {
			hypyt[0] = hyppy;
		}
		else if (hypyt[1] == null) {
			hypyt[1] = hyppy;
		}
	}
}
