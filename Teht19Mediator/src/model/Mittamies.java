package model;

import java.util.Random;

public class Mittamies {

	private String name;

	public Mittamies(String name) {
		this.name = name;
	}

	public Hyppy mittaaHyppy(Hyppy hyppy) {
		hyppy.setLength(randomDistance());
		return hyppy;
	}

	private double randomDistance() {
		return 50 + new Random().nextDouble() * 60;
	}
}
