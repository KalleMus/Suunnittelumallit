package pokemon;

import javafx.scene.image.Image;
import view.MainView;

public class Charizard implements PokemonState_IF {

	private String name = "Charizard";
	private MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charizard.jpg");
	private Pokemon pokemon;

	public Charizard(Pokemon pokemon, MainView mainView) {
		this.pokemon = pokemon;
		this.mainView = mainView;
	}

	@Override
	public void levelUp() {
		updateEventText("This pokemon can't level up anymore.");
		System.out.println("This pokemon can't level up anymore.");
	}

	@Override
	public void reset() {
		updateEventText("");
		pokemon.setCurrentForm(new Charmander(pokemon, mainView));
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Flamethrower! It's super effective");
		System.out.println(name + " uses Flamethrower! It's super effective");
	}

	@Override
	public void defend() {
		updateEventText(name + " roars at their foes and their run away.");
		System.out.println(name + " roars at their foes and their run away.");
	}

	@Override
	public void move() {
		updateEventText(name + " flies to a new spot.");
		System.out.println(name + " flies to a new spot.");
	}

	@Override
	public void updateEventText(String text) {
		mainView.updateEventLabel(text);
	}

	@Override
	public void updatePokeImage() {
		mainView.updatePokeImage();
	}

	@Override
	public Image getImage() {
		return pokeImage;
	}
}
