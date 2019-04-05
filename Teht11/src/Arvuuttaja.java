import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arvuuttaja {

	private List<Asiakas> asiakkaat = new ArrayList<>();

	public void liityPeliin(Asiakas asiakas) {
		asiakas.setObj(new Memento());
		asiakkaat.add(asiakas);
	}

	/**
	 * Avaa ja katso asiakkaan palauttaman mementon sisältö.
	 * Katso vastaako mementon sisällä oleva luku asiakkaan arvausta, jos luvut täsmäävät, niin asiakas arvasi oikein.
	 * Jos taas ei niin asiakas arvasi väärin.
	 * Kasvata asiakkaan arvauskertoja, joka arvauskerralla.
	 * @param asiakas
	 * @param luku
	 * @return
	 */
	public boolean arvaa(Asiakas asiakas, int luku) {
		Memento memento = (Memento) asiakas.getObj();
		asiakas.incArvauksia();
		System.out.println(asiakas.getName() + " arvaa, että hänelle arvottu luku olisi: " + luku);
		if (luku == memento.getLuku()) {
			System.out.println(asiakas.getName() + " arvasi oikein");
			asiakas.setArvasiOikein(true);
			return true;
		}
		else {
			System.out.println(asiakas.getName() + " arvasi väärin.");
			return false;
		}
	}

	/**
	 * Memento.
	 * Lappu johon talletetaan asiakkaalle arvottu luku 1 - 10 väliltä.
	 * Tämä lappu sitten annetaan asiakkaalle, mutta hän ei pääse siihen käsiksi.
	 */
	private class Memento {

		private int luku;

		private Memento() {
			Random random = new Random();
			this.luku = 1 + random.nextInt(10);
		}

		public int getLuku() {
			return luku;
		}
	}

	public List<Asiakas> getAsiakkaat() {
		return asiakkaat;
	}
}
