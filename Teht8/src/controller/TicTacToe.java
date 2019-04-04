package controller;

import main.GameThread;

/**
 * The game loop
 */
public class TicTacToe extends Game {

	private GameThread gt;

	public TicTacToe(GameThread gt) {
		this.gt = gt;
	}

	@Override
	public void initializeGame() {
	}

	@Override
	public void makePlay(int player) {
		gt.getCon().setCurrentPlayer(player);
		while (!gt.getCon().isClicked()) {
			System.out.print("");
		}
		gt.getCon().setClicked(false);
	}

	@Override
	public boolean endOfGame() {
		int[][] winList = gt.getCon().getWinList();
		int player = gt.getCon().getCurrentPlayer();
		if (horizontalCheck(winList, player)) {
			gt.getCon().setGameOver(true);
			return true;
		}
		else if (verticalCheck(winList,player)) {
			gt.getCon().setGameOver(true);
			return true;
		}
		else if (diagonalCheck(winList, player)) {
			gt.getCon().setGameOver(true);
			return true;
		}
		else if (tieCheck(winList)) {
			gt.getCon().setTie(true);
			return true;
		}
		else {
			return false;
		}
	}

	private boolean tieCheck(int[][] winList) {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				if (winList[i][j] != 1 && winList[i][j] != 2) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean horizontalCheck(int[][] winList, int player) {
		for (int j = 0; j < 3; j++) {
			if (winList[0][j] == player && winList[1][j] == player && winList[2][j] == player ) {
				return true;
			}
		}
		return false;
	}

	private boolean verticalCheck(int[][] winList, int player) {
		for (int i = 0; i < 3; i++) {
			if (winList[i][0] == player && winList[i][1] == player && winList[i][2] == player ) {
				return true;
			}
		}
		return false;
	}

	private boolean diagonalCheck(int[][] winList, int player) {
		if (winList[0][0] == player && winList[1][1] == player && winList[2][2] == player ) {
			return true;
		}
		else if (winList[0][2] == player && winList[1][1] == player && winList[2][0] == player ) {
			return true;
		}
		return false;
	}

	@Override
	public void printWinner() {
		gt.getCon().printWinner();
	}
}