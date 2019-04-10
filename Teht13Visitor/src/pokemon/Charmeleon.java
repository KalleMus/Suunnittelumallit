package pokemon;

import javafx.scene.image.Image;
import view.MainView;
import visitor.EvolveCheckerVisitor;
import visitor.Visitor_IF;

public class Charmeleon implements PokemonState_IF {

	private String name = "Charmeleon";
	private static MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charmeleon.jpg");
	private static Charmeleon charmeleon;
	private int level;


	public static PokemonState_IF getInstance(MainView mw) {
		mainView = mw;
		if (charmeleon == null) {
			charmeleon = new Charmeleon();
		}
		return charmeleon;
	}

	private Charmeleon() {
	}

	@Override
	public void evolve(Pokemon pokemon) {
		updateEventText(name + " evolves!");
		updatePokeImage();
		System.out.println(name + " evolves!");
		pokemon.setCurrentForm(Charizard.getInstance(mainView));
	}

	@Override
	public void reset(Pokemon pokemon) {
		updateEventText("");
		level = 1;
		mainView.updateCurrentLevelLabel(level);
		updatePokeImage();
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Fury Swipes! It deals 25 damage.");
	}

	@Override
	public void defend() {
		updateEventText(name + " blocks the incoming attack with it's claws.");
	}

	@Override
	public void move() {
		updateEventText(name + " runs to a new spot.");
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
