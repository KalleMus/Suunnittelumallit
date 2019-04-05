
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		/**
		 * Luo arvuuttaja.
		 */
		Arvuuttaja arvuuttaja = new Arvuuttaja();

		/**
		 * Luo asiakkaat (pelaajat)
		 */
		Asiakas kalle = new Asiakas("Kalle", arvuuttaja);
		Asiakas mihail = new Asiakas("Mihail", arvuuttaja);
		Asiakas juho = new Asiakas("juho", arvuuttaja);
		Asiakas aku = new Asiakas("aku", arvuuttaja);

		/**
		 * Asiakkaat liittyy arvuuttajan peliin.
		 */
		arvuuttaja.liityPeliin(kalle);
		arvuuttaja.liityPeliin(mihail);
		arvuuttaja.liityPeliin(juho);
		arvuuttaja.liityPeliin(aku);

		/**
		 * Asiakkaat arvaavat numeroaan kunnes kaikki on sen arvannut oikein.
		 */
		List<Asiakas> asiakkaat = arvuuttaja.getAsiakkaat();
		while (!kalle.isArvasiOikein() || !mihail.isArvasiOikein() || !juho.isArvasiOikein() || !aku.isArvasiOikein()) {
			kalle.arvaa(randomInt());
			mihail.arvaa(randomInt());
			juho.arvaa(randomInt());
			aku.arvaa(randomInt());
		}

		/**
		 * Tulosta kuinka monta arvausta kullakin asiakkaalla meni 1 - 10 väliltä,
		 * ennen kuin he arvasivat oman numeronsa oikein.
		 */
		asiakkaat.stream().forEach(a ->
			System.out.println(a.getName() + " arvasi " + a.getArvausKerrat() + " kertaa, ennen kuin arvasi oikein.")
		);
	}

	private static int randomInt() {
		Random random = new Random();
		return 1 + random.nextInt(10);
	}
}
