package com.uncooleben.OOAD.lab01.main;

import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.util.Direction;
import com.uncooleben.OOAD.lab01.util.GameConfigParser;

/**
 * The class is used to perform multiple cases of climbing game. Especially
 * different facing directions of ants at start.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 */
public class GameBatch {

	public static String CONFIG_VIA_GUI = "CONFIG_VIA_GUI";
	public static String CONFIG_VIA_FILE = "CONFIG_VIA_FILE";
	private List<Ant> ants;
	private ClimbingGame climbingGame;
	private boolean configured;

	/**
	 * Prints the ants' direction at the very beginning of the climbing game
	 */
	private void printAntsDirection() {
		for (Ant ant : this.climbingGame.getPole().getAnts()) {
			if (ant.getDirection().equals(Direction.LEFT)) {
				System.out.println("L");
			} else {
				System.out.println("R");
			}
		}
	}

	/**
	 * Starts the game batch with initial bits 0 to end bits 1<<sizeOfAntsList.
	 */
	public void startGameBatch() {
		int total = 1 << this.ants.size();
		int bits = 0;
		long shortest = Long.MAX_VALUE;
		long longest = Long.MIN_VALUE;
		while (total > 0) {
			initializeGame();
			this.climbingGame.setAntsDirection(bits);
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

	/**
	 * Starts a single case of climbing game according to the given bits.
	 */
	public void debugGame(int bits) {
		initializeGame();
		this.climbingGame.getPole().setAntsDirection(bits);
		printAntsDirection();
		this.climbingGame.startGame();
	}

	/**
	 * Initializes the game by setting the attribute values according to the
	 * gameConfig.xml.
	 */
	private void initializeGame(String CONFIG_METHOD) {
		if (CONFIG_METHOD.equals(GameBatch.CONFIG_VIA_FILE)) {
			try {
				this.climbingGame = GameConfigParser.parse(gameConfig);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (CONFIG_METHOD.equals(GameBatch.CONFIG_VIA_GUI)) {

		}

	}

}
