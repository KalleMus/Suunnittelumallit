package model;

import java.util.Random;

public class Arvostelutuomari {

	private String nimi;

	public Arvostelutuomari(String nimi) {
		this.nimi = nimi;
	}

	public double arvosteleHyppy(Hyppy hyppy) {
		return ( new Random().nextDouble() * 10 + hyppy.getLength() ) / 10;

	}
}
