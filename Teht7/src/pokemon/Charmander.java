package pokemon;

import javafx.scene.image.Image;
import view.MainView;


public class Charmander implements PokemonState_IF {

	private String name = "Charmander";
	private MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charmander.jpg");
	private Pokemon pokemon;

	public Charmander(Pokemon pokemon, MainView mainView) {
		this.pokemon = pokemon;
		this.mainView = mainView;
	}

	@Override
	public void levelUp() {
		updateEventText(name + " levels up!");
		System.out.println(name + " levels up!");
		pokemon.setCurrentForm(new Charmeleon(pokemon, mainView));
	}

	@Override
	public void reset() {
		updateEventText("");
		pokemon.setCurrentForm(new Charmander(pokemon, mainView));
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Scratch! It deals 5 damage.");
		System.out.println(name + " uses Scratch! It deals 5 damage.");
	}

	@Override
	public void defend() {
		updateEventText(name + " curls up into a ball and cowers in fear.");
		System.out.println(name + " curls up into a ball and cowers in fear.");
	}

	@Override
	public void move() {
		updateEventText(name + " walks to a new spot.");
		System.out.println(name + " walks to a new spot.");
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
