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
		long shortest = Long.MAX_VALUE;
		long longest = Long.MIN_VALUE;
		while (total > 0) {
			initializeGame();
			this.climbingGame.getPole().setAntsDirection(bits);
			printAntsDirection();
			this.climbingGame.startGame();
			if (this.climbingGame.getTime() > longest) {
				longest = this.climbingGame.getTime();
			}
			if (this.climbingGame.getTime() < shortest) {
				shortest = this.climbingGame.getTime();
			}
			bits++;
			total--;
		}
		System.out.println("Shortest time " + shortest);
		System.out.println("Longest time " + longest);
	}

	public void debugGame(int bits) {
		initializeGame();
		this.climbingGame.getPole().setAntsDirection(bits);
		printAntsDirection();
		this.climbingGame.startGame();
	}

	private void initializeGame() {
		try {
			this.climbingGame = GameConfigParser.parse(gameConfig);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
