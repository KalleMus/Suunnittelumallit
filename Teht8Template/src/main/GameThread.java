package main;

import View.MainView;
import controller.MwController;
import controller.TicTacToe;


/**
 * Thread that starts the game loop to run on a different thread.
 */
public class GameThread extends Thread{

	private MwController con;
	private int playerCount;

	public GameThread(MwController con, int playerCount) {
		this.con = con;
		this.playerCount = playerCount;
	}

	@Override
	public void run() {
		super.run();
		TicTacToe ttt = new TicTacToe(this);
		ttt.playOneGame(playerCount);
	}

	public MwController getCon() {
		return con;
	}
}