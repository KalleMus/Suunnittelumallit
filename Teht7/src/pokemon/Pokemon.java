package pokemon;

import view.MainView;

public class Pokemon {

	private PokemonState_IF charmander;
	private PokemonState_IF charmeleon;
	private PokemonState_IF charizard;

	private PokemonState_IF currentForm;

	public Pokemon(MainView mainView) {
		charmander = new Charmander(this, mainView);
		charmeleon = new Charmeleon(this, mainView);
		charizard = new Charizard(this, mainView);

		currentForm = charmander;
	}

	public void setCurrentForm(PokemonState_IF newForm) {
		currentForm = newForm;
	}

	public void attack() {
		currentForm.attack();
	}

	public void defend() {
		currentForm.defend();
	}

	public void move() {
		currentForm.move();
	}

	public void levelUp() {
		currentForm.levelUp();
		currentForm.updatePokeImage();
	}

	public void reset() {
		currentForm.reset();
		currentForm.updatePokeImage();
	}

	public PokemonState_IF getCurrentForm() {
		return currentForm;
	}
}
