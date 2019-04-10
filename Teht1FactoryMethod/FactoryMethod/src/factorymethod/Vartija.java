package factorymethod;

public class Vartija extends AterioivaOtus {

	public Juoma createJuoma() {
		return new Maito();
	}

	public Ruoka createRuoka() {
		return new Kebab();
	}
}
