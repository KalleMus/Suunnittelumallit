package model;

public class Tulosrivi {

	private String hyppaajanNimi;
	private int hyppaajanNumero;
	private double hypynPisteet;
	private double hypynPituus;

	public Tulosrivi(Hyppaaja hyppaaja, Hyppy hyppy) {
		this.hyppaajanNimi = hyppaaja.getName();
		this.hyppaajanNumero = hyppaaja.getNumber();
		this.hypynPisteet = hyppy.getPoints();
		this.hypynPituus = hyppy.getLength();
	}

	public String toString() {
		return "Hyppaaja: Nimi: " + hyppaajanNimi + ", Nro: " + hyppaajanNumero + "\n" +
				"Hyppy: Pituus: " + round(hypynPituus) + ", Pisteet: " + round(hypynPisteet	) + "\n";
	}

	private double round(double value) {
		return (double) Math.round(value * 100) / 100;
	}
}
