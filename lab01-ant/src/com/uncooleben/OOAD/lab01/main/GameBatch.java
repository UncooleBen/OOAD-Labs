package com.uncooleben.OOAD.lab01.main;

import java.io.File;
import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.util.Direction;
import com.uncooleben.OOAD.lab01.util.GameConfigParser;

public class GameBatch {

	private List<Ant> ants;
	private ClimbingGame climbingGame;
	private File gameConfig;

	public GameBatch(File gameConfig) {
		try {
			this.gameConfig = gameConfig;
			this.climbingGame = GameConfigParser.parse(gameConfig);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this.ants = this.climbingGame.getPole().getAnts();
	}

	private void printAntsDirection() {
		for (Ant ant : this.climbingGame.getPole().getAnts()) {
			if (ant.getDirection().equals(Direction.LEFT)) {
				System.out.println("L");
			} else {
				System.out.println("R");
			}
		}
	}

	public void startGameBatch() {
		int total = 1 << this.ants.size();
		int bits = 0;
		while (total > 0) {
			initializeGame();
			this.climbingGame.getPole().setAntsDirection(bits);
			printAntsDirection();
			this.climbingGame.startGame();
			bits++;
			total--;
		}
	}

	private void initializeGame() {
		try {
			this.climbingGame = GameConfigParser.parse(gameConfig);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
