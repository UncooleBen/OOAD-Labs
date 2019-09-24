package com.uncooleben.OOAD.lab01.character.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

/**
 * An implementation class which implements the ClimbingGame interface.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class ClimbingGameImpl implements ClimbingGame {

	private Pole pole;
	private long time;
	private long timeGap;
	private AntGameFrame frame;
	private static long gameGap = 20L;

	/**
	 * Constructs an ClimbingGameImpl object according to the given parameters.
	 * <p>
	 * This constructor should not be called explicitly. Use ClimbingGameFactory
	 * class's static method 'create' instead.
	 * 
	 * @param pole    A Pole object owned by the game
	 * @param timeGap A long integer indicating the time gap (in milliseconds) to
	 *                refresh/update the game status
	 */
	public ClimbingGameImpl(Pole pole, long timeGap, AntGameFrame frame) {
		this.pole = pole;
		this.time = 0L;
		this.timeGap = timeGap;
		this.frame = frame;
	}

	@Override
	public void startGame() {
		while (!isGameOver()) {
			if (time % timeGap==0) {
				frame.repaint();
				frame.validate();
			}
			System.out.println(time);
			try {
				TimeUnit.NANOSECONDS.sleep(gameGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeElapse();
		}
	}

	@Override
	public void timeElapse() {
		this.pole.moveByTime(gameGap);
		this.pole.performCheck(gameGap);
		time += gameGap;
	}

	@Override
	public boolean isGameOver() {
		return this.pole.getAliveNumber() == 0;
	}

	@Override
	public long getTime() {
		return this.time;
	}

	@Override
	public Pole getPole() {
		return this.pole;
	}

	/**
	 * Prints the current game status in command line. It will be unused once the
	 * GUI has finished.
	 */
	@SuppressWarnings("unused")
	private void printAnts() {
		HashMap<Integer, Integer> locationToAnt = new HashMap<Integer, Integer>();
		for (Ant ant : this.pole.getAnts()) {
			if (ant.isAlive()) {
				locationToAnt.put((int) Math.round(ant.getLocation()), Integer.parseInt(ant.getName()));
			}
		}
		StringBuffer sb = new StringBuffer("");
		for (int index = 0; index < this.pole.getSize(); ++index) {
			if (locationToAnt.containsKey(index)) {
				sb.append(locationToAnt.get(index).toString());
			} else {
				sb.append("=");
			}
		}
		System.out.println(sb.toString());
	}

	@Override
	public void setAntsDirection(int bits) {
		this.pole.setAntsDirection(bits);
	}

}
