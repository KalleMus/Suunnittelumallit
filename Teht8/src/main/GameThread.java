package main;

import View.MainView;
import controller.MwController;
import controller.TicTacToe;

public class GameThread extends Thread{

	private MainView mw;
	private MwController con;
	private int playerCount;

	public GameThread(MainView mw, MwController con, int playerCount) {
		this.mw = mw;
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