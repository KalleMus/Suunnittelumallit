package model;

public class Kello implements Cloneable {

	private Viisari tuntiViisari, minuttiViisari, sekuntiViisari;

	public Kello() {
		tuntiViisari = new Viisari("Tuntiviisari", 10, 50);
		minuttiViisari = new Viisari("Minuuttiviisari", 2, 10);
		sekuntiViisari = new Viisari("Sekuntiviisari", 1, 12);
	}

	public Kello deepClone() {
		Kello deepCopyKello = null;
		try {
			deepCopyKello = (Kello) super.clone();
			deepCopyKello.setTuntiViisari(tuntiViisari.deepClone());
			deepCopyKello.setMinuttiViisari(minuttiViisari.deepClone());
			deepCopyKello.setSekuntiViisari(sekuntiViisari.deepClone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return deepCopyKello;
	}

	public Kello shallowClone() {
		Kello returnKello = null;
		try {
			returnKello = (Kello) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return returnKello;
	}

	public void incrementHours() {
		if (tuntiViisari.getPointsTo() >= 12) {
			tuntiViisari.setPointsTo(1);
		}
		else {
			tuntiViisari.setPointsTo(tuntiViisari.getPointsTo() + 1);
		}
		System.out.println(getTime());
	}

	public void incrementMinutes() {
		if (minuttiViisari.getPointsTo() >= 60) {
			minuttiViisari.setPointsTo(1);
			incrementHours();
		}
		else {
			minuttiViisari.setPointsTo(minuttiViisari.getPointsTo() + 1);
		}
		System.out.println(getTime());
	}

	public void incrementSeconds() {
		if (sekuntiViisari.getPointsTo() >= 60) {
			sekuntiViisari.setPointsTo(1);
			incrementMinutes();
		}
		else {
			sekuntiViisari.setPointsTo(sekuntiViisari.getPointsTo() + 1);
		}
		System.out.println(getTime());
	}

	public String getTime() {
		return tuntiViisari.getPointsTo() + ":" + minuttiViisari.getPointsTo() + ":" + sekuntiViisari.getPointsTo();
	}

	public Viisari getTuntiViisari() {
		return tuntiViisari;
	}

	public void setTuntiViisari(Viisari tuntiViisari) {
		this.tuntiViisari = tuntiViisari;
	}

	public Viisari getMinuttiViisari() {
		return minuttiViisari;
	}

	public void setMinuttiViisari(Viisari minuttiViisari) {
		this.minuttiViisari = minuttiViisari;
	}

	public Viisari getSekuntiViisari() {
		return sekuntiViisari;
	}

	public void setSekuntiViisari(Viisari sekuntiViisari) {
		this.sekuntiViisari = sekuntiViisari;
	}
}
