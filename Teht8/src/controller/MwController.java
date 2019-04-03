package controller;

import View.MainView;

public class MwController {

	private MainView mw;

	private boolean gameOver = false;
	private boolean clicked = false;
	private int currentPlayer = 1;

	private int[][] winList = new int[3][3];

	public MwController(MainView mw) {
		this.mw = mw;
	}

	public void handleClick(int x, int y) {
		winList[x][y] = currentPlayer;
		System.out.println(x + ", " + y);
		clicked = true;
		System.out.println("handleClick clicked: " + clicked);
	}

	public int[][] getWinList() {
		return winList;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void setCurrentPlayer(int player) {
		System.out.println("Current player: " + player);
		this.currentPlayer = player;
		mw.setCurrentPlayer(player);
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void printWinner() {
		mw.winner(currentPlayer);
	}

	public void resetGame() {

	}
}
