public class Asiakas {

	private String name;
	private Object obj;
	private Arvuuttaja arvuuttaja;
	private boolean arvasiOikein;
	private int arvausKerrat;

	public Asiakas(String name, Arvuuttaja arvuuttaja) {
		this.name = name;
		this.arvuuttaja = arvuuttaja;
	}

	/**
	 * Arvaa arvuuttajan antamaa lukua arvuuttajalta.
	 * @param luku random luku.
	 * @return
	 */
	public boolean arvaa(int luku) {
		if (arvasiOikein) {
			return true;
		}
		return arvuuttaja.arvaa(this, luku);
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getName() {
		return name;
	}

	public boolean isArvasiOikein() {
		return arvasiOikein;
	}

	public void setArvasiOikein(boolean arvasiOikein) {
		this.arvasiOikein = arvasiOikein;
	}

	public int getArvausKerrat() {
		return arvausKerrat;
	}

	public void incArvauksia() {
		this.arvausKerrat++;
	}
}
