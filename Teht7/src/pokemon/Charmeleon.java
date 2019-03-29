package pokemon;

import javafx.scene.image.Image;
import view.MainView;

public class Charmeleon implements PokemonState_IF {

	private String name = "Charmeleon";
	private MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charmeleon.jpg");
	private Pokemon pokemon;

	public Charmeleon(Pokemon pokemon, MainView mainView) {
		this.pokemon = pokemon;
		this.mainView = mainView;
	}

	@Override
	public void levelUp() {
		updateEventText(name + " levels up!");
		System.out.println(name + " levels up!");
		pokemon.setCurrentForm(new Charizard(pokemon, mainView));
	}

	@Override
	public void reset() {
		updateEventText("");
		pokemon.setCurrentForm(new Charmander(pokemon, mainView));
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Fury Swipes! It deals 25 damage.");
		System.out.println(name + " uses Fury Swipes! It deals 25 damage.");
	}

	@Override
	public void defend() {
		updateEventText(name + " blocks the incoming attack with it's claws.");
		System.out.println(name + " blocks the incoming attack with it's claws.");
	}

	@Override
	public void move() {
		updateEventText(name + " runs to a new spot.");
		System.out.println(name + " runs to a new spot.");
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
