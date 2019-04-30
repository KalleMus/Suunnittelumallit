package main;

import model.*;

public class Mediator {

	private Mittamies mittamies;
	private Arvostelutuomari[] tuomarit;
	private Kisasihteeri kisasihteeri;
	private Tulostaulu tulostaulu;

	public Mediator(Mittamies mittamies, Arvostelutuomari[] tuomarit, Kisasihteeri kisasihteeri, Tulostaulu tulostaulu) {
		this.mittamies = mittamies;
		this.tuomarit = tuomarit;
		this.kisasihteeri = kisasihteeri;
		this.tulostaulu = tulostaulu;
	}

	public void suoritaHyppy(Hyppaaja hyppaaja) {

		// Hyppääjä hyppää.
		Hyppy hyppy = hyppaaja.hyppaa();

		// Mittamies mittaa hypyn.
		hyppy = mittamies.mittaaHyppy(hyppy);

		// Jokainen tuomari arvostelee hypyn.
		double[] pisteet = new double[5];
		for (int i = 0; i < tuomarit.length; i++) {
			pisteet[i] = tuomarit[i].arvosteleHyppy(hyppy);
		}

		// Kisasihteeri laskee pisteet
		hyppy = kisasihteeri.laskePisteet(pisteet, hyppy);

		// Päivitä hyppääjän hyppy.
		hyppaaja.lisääHyppy(hyppy);

		// Lisää tulostauluun uusi tulosrivi.
		tulostaulu.lisaaTulosrivi(new Tulosrivi(hyppaaja, hyppy));
	}

	public void tulostaKaikkiHypyt() {
		tulostaulu.tulosta();
	}
}
