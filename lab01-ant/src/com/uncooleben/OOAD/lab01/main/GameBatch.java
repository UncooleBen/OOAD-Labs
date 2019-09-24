package com.uncooleben.OOAD.lab01.main;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.gui.AntGameFrame;
import com.uncooleben.OOAD.lab01.util.Direction;
import com.uncooleben.OOAD.lab01.util.GameConfig;

/**
 * The class is used to perform multiple cases of climbing game. Especially
 * different facing directions of ants at start.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 */
public class GameBatch implements Runnable {

	private ClimbingGame climbingGame;
	private GameConfig gameConfig;
	private AntGameFrame frame;
	private long longest;
	private long shortest;

	public GameBatch(AntGameFrame frame) {
		this.frame = frame;
	}

	public GameBatch(GameConfig gameConfig, AntGameFrame frame) {
		this.gameConfig = gameConfig;
		this.frame = frame;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

	public ClimbingGame getGame() {
		return this.climbingGame;
	}

	/*
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
		int total = 1 << this.climbingGame.getPole().getAnts().size();
		int bits = 0;
		this.shortest = Long.MAX_VALUE;
		this.longest = Long.MIN_VALUE;
		long start = System.currentTimeMillis();
		while (total > 0) {
			this.climbingGame.setAntsDirection(bits);
			printAntsDirection();
			frame.getDrawComponent().setPole(this.climbingGame.getPole());
			this.climbingGame.startGame();
			if (this.climbingGame.getTime() > longest) {
				longest = this.climbingGame.getTime();
			}
			if (this.climbingGame.getTime() < shortest) {
				shortest = this.climbingGame.getTime();
			}
			bits++;
			total--;
			initializeGame();
		}
		frame.setDone(true);
		frame.repaint();
		frame.validate();
		System.out.println("time used : "+(System.currentTimeMillis()-start));
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
	public void initializeGame() {
		this.climbingGame = this.gameConfig.getGame();
	}

	@Override
	public void run() {
		this.startGameBatch();

	}

	public long getLongest() {
		return this.longest;
	}

	public long getShortest() {
		return this.shortest;
	}

}
