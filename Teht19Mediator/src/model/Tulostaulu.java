package model;

import java.util.ArrayList;
import java.util.List;

public class Tulostaulu {

	private List<Tulosrivi> tulosrivit;

	public Tulostaulu() {
		tulosrivit = new ArrayList<>();
	}

	public void lisaaTulosrivi(Tulosrivi tulosrivi) {
		tulosrivit.add(tulosrivi);
	}

	public void tulosta() {
		tulosrivit.stream().forEach(e -> System.out.println(e.toString()));
	}
}
