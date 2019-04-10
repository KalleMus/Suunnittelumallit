package pokemon;

import javafx.scene.image.Image;
import view.MainView;

public class Charmander implements PokemonState_IF {

	private String name = "Charmander";
	private static MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charmander.jpg");
	private static Charmander charmander;

	public static PokemonState_IF getInstance(MainView mw) {
		mainView = mw;
		if (charmander == null) {
			charmander = new Charmander();
		}
		return charmander;
	}

	private Charmander() {
	}

	@Override
	public void levelUp(Pokemon pokemon) {
		updateEventText(name + " levels up!");
		System.out.println(name + " levels up!");
		pokemon.setCurrentForm(Charmeleon.getInstance(mainView));
	}

	@Override
	public void reset(Pokemon pokemon) {
		updateEventText("");
		pokemon.setCurrentForm(charmander);
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
