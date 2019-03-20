package factorymethod;

public class Vartija extends AterioivaOtus {
	@Override
	public Juoma createJuoma() {
		return new Vesi();
	}
}
