package main;

import model.*;

public class Main {
	public static void main(String[] args) {

		/**
		 * Luo kaikki tarvittavat oliot.
		 * Kolme hyppääjää,
		 * Mittamies,
		 * Viisi arvostelijaa,
		 * Kisasihteeri,
		 * Tulostaulu
		 */
		Hyppaaja h1 = new Hyppaaja(1,"Kalle");
		Hyppaaja h2 = new Hyppaaja(2,"Aki");
		Hyppaaja h3 = new Hyppaaja(3,"Sami");
		Mittamies mittamies = new Mittamies("Matti");
		Arvostelutuomari a1 = new Arvostelutuomari("Seppo");
		Arvostelutuomari a2 = new Arvostelutuomari("Ulla");
		Arvostelutuomari a3 = new Arvostelutuomari("Jeesus");
		Arvostelutuomari a4 = new Arvostelutuomari("Marko");
		Arvostelutuomari a5 = new Arvostelutuomari("Mika");
		Arvostelutuomari[] tuomarit = {a1, a2, a3, a4, a5};
		Kisasihteeri kisasihteeri = new Kisasihteeri("Pirkko");
		Tulostaulu tulostaulu = new Tulostaulu();

		/**
		 * Luo mediaattori ja anna parametreina tarvittavat oliot.
		 */
		Mediator mediator = new Mediator(mittamies, tuomarit, kisasihteeri, tulostaulu);

		/**
		 * Suorita hypyt ja anna parametrina hyppääjä.
		 */
		mediator.suoritaHyppy(h1);
		mediator.suoritaHyppy(h1);
		mediator.suoritaHyppy(h2);
		mediator.suoritaHyppy(h2);
		mediator.suoritaHyppy(h3);
		mediator.suoritaHyppy(h3);

		/**
		 * Tulosta tulostaulu.
		 */
		mediator.tulostaKaikkiHypyt();
	}
}
