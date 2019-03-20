package factorymethod;

public class Oppilas extends AterioivaOtus {
	@Override
	public Juoma createJuoma() {
		return new Vesi();
	}
}
