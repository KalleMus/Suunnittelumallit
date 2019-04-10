package factorymethod;

public class Oppilas extends AterioivaOtus {
	public Juoma createJuoma() {
		return new Maito();
	}

	public Ruoka createRuoka() {
		return new Pizza();
	}
}
