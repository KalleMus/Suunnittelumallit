package controller;

import View.MainView;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import main.GameThread;

/**
 * Controller that talks between the MainView and TicTacToe game loop.
 */
public class MwController {

	private final int PLAYER_COUNT = 2;
	private MainView mw;
	private boolean gameOver = false;
	private boolean tie = false;
	private boolean clicked = false;
	private int currentPlayer = 1;
	private final Color p1Color = Color.RED, p2Color = Color.GREEN, tieColor = Color.BLACK;
	private int[][] winList = new int[3][3];

	public MwController(MainView mw) {
		this.mw = mw;
		gameLoop();
	}

	public void handleClick(int x, int y) {
		winList[x][y] = currentPlayer;
		System.out.println(x + ", " + y);
		clicked = true;
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
		this.currentPlayer = player;
		Platform.runLater(() -> {
			mw.getCurrentPlayerLabel().setText("Player" + currentPlayer + " turn");
			if (currentPlayer == 1) {
				mw.getCurrentPlayerLabel().setTextFill(p1Color);
			}
			else {
				mw.getCurrentPlayerLabel().setTextFill(p2Color);
			}
		});
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
		Platform.runLater(() -> {
			mw.getResetButton().setVisible(true);
			if (tie) {
				mw.getCurrentPlayerLabel().setTextFill(tieColor);
				mw.getCurrentPlayerLabel().setText("It's a tie");
				mw.getCurrentPlayerLabel().setId("winnerLabel");
			}
			else {
				mw.getCurrentPlayerLabel().setText("Player" + currentPlayer + " WINS!");
				mw.getCurrentPlayerLabel().setId("winnerLabel");
			}
		});
	}

	public void resetGame() {
		winList = new int[3][3];
		setGameOver(false);
		setTie(false);
		gameLoop();
	}

	private void gameLoop() {
		mw.getResetButton().setVisible(false);
		GameThread gt = new GameThread(this, PLAYER_COUNT);
		gt.start();
	}

	public void setTie(boolean tie) {
		this.tie = tie;
	}
}
