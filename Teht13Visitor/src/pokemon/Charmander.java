package pokemon;

import javafx.scene.image.Image;
import view.MainView;
import visitor.Visitor_IF;

public class Charmander implements PokemonState_IF {

	private String name = "Charmander";
	private static MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charmander.jpg");
	private static Charmander charmander;
	private int level = 1;

	public static PokemonState_IF getInstance(MainView mw) {
		mainView = mw;
		if (charmander == null) {
			charmander = new Charmander();
		}
		return charmander;
	}

	private Charmander() {
		mainView.updateCurrentLevelLabel(level);
	}

	@Override
	public void evolve(Pokemon pokemon) {
		updateEventText(name + " evolves!");
		updatePokeImage();
		pokemon.setCurrentForm(Charmeleon.getInstance(mainView));
	}

	@Override
	public void reset(Pokemon pokemon) {
		updateEventText("");
		pokemon.setCurrentForm(charmander);
		level = 1;
		mainView.updateCurrentLevelLabel(level);
		updatePokeImage();
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Scratch! It deals 5 damage.");
	}

	@Override
	public void defend() {
		updateEventText(name + " curls up into a ball and cowers in fear.");
	}

	@Override
	public void move() {
		updateEventText(name + " walks to a new spot.");
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

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void increaseLevel(Visitor_IF evolveCheckerVisitor) {
		level++;
		mainView.updateCurrentLevelLabel(level);
		evolveCheckerVisitor.visit(this);
	}
}
