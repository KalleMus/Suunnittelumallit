package model;

public class Kisasihteeri {

	private String nimi;

	public Kisasihteeri(String nimi) {
		this.nimi = nimi;
	}

	public Hyppy laskePisteet(double[] tuomareidenPisteet, Hyppy hyppy) {
		double summa = 0;
		for (double piste : tuomareidenPisteet) {
			summa += piste;
		}
		hyppy.setPoints(summa / tuomareidenPisteet.length);
		return hyppy;
	}
}
