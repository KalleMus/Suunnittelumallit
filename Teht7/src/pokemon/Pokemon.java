package pokemon;

import view.MainView;

public class Pokemon {

	private PokemonState_IF currentForm;
	private MainView mainView;

	public Pokemon(MainView mainView) {
		this.mainView = mainView;
		currentForm = Charmander.getInstance(mainView);
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
		currentForm.levelUp(this);
		currentForm.updatePokeImage();
	}

	public void reset() {
		currentForm.reset(this);
		currentForm.updatePokeImage();
	}

	public PokemonState_IF getCurrentForm() {
		return currentForm;
	}

	public MainView getMainView() {
		return mainView;
	}
}
