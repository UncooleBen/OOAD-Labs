package com.uncooleben.OOAD.lab01.character.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.util.Direction;

/**
 * An implementation class which implements the Pole interface.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class PoleImpl implements Pole {

	private double size;
	private List<Ant> ants;
	private int aliveNumber;
	private double maxAntSpeed;

	public PoleImpl() {

	}

	/**
	 * Constructs an PoleImpl object according to the given parameters.
	 * <p>
	 * This constructor should not be called explicitly. Use PoleFactory class's
	 * static method 'create' instead.
	 * 
	 * @param size A double variable indicating the size of the pole
	 * @param ants A java.util.List object containing the ants on the pole
	 */
	public PoleImpl(double size, List<Ant> ants) {
		this.size = size;
		this.ants = new ArrayList<Ant>(ants);
		this.aliveNumber = this.ants.size();
		this.maxAntSpeed = getMaxAntSpeed();
	}

	@Override
	public void moveByTime(long time) {
		for (Ant ant : this.ants) {
			if (ant.isAlive()) {
				if (ant.getDirection().equals(Direction.LEFT)) {
					ant.setLocation(ant.getLocation() - ant.getSpeed() * time / 1000);
//					System.out.println(
//							"Ant " + ant.getName() + " moving " + ant.getDirection() + " to " + ant.getLocation());
				} else {
					ant.setLocation(ant.getLocation() + ant.getSpeed() * time / 1000);
//					System.out.println(
//							"Ant " + ant.getName() + " moving " + ant.getDirection() + " to " + ant.getLocation());
				}
			}
		}
	}

	@Override
	public void performCheck() {

		for (Ant ant : ants) {
			performAliveCheck(ant);
		}

		Map<Ant, Boolean> needCheck = new HashMap<Ant, Boolean>();
		for (Ant ant : ants) {
			if (ant.isAlive()) {
				needCheck.put(ant, true);
			}
		}

		for (Ant ant : needCheck.keySet()) {
			if (needCheck.get(ant) == true) {
				performCollisionCheck(ant, needCheck);
			}
		}

	}

	/**
	 * Performs a collision check for a chosen ant and all the other ants alive.
	 * 
	 * @param ant       An Ant object of the chosen ant
	 * @param needCheck A java.util.Map object from Ant to Boolean. The boolean
	 *                  indicates whether the key (ant) needs to be checked. Only
	 *                  when the ant is alive is the ant needed to be checked
	 */
	private void performCollisionCheck(Ant ant, Map<Ant, Boolean> needCheck) {
		boolean targetAntCollided = false;
		for (Ant otherAnt : needCheck.keySet()) {
			if (!ant.equals(otherAnt) && needCheck.get(otherAnt) == true) {
				if (isCollided(ant, otherAnt)) {
					System.out.println(">>" + otherAnt.getName() + " collides at location " + otherAnt.getLocation());
					otherAnt.changeDirection();
					needCheck.put(otherAnt, false);
					targetAntCollided = true;
				}
			}
		}
		if (targetAntCollided) {
			System.out.println(">>" + ant.getName() + " collides at location " + ant.getLocation());
			ant.changeDirection();
		}
	}

	/**
	 * Indicates whether the two given ants in the parameter is collided.
	 * 
	 * @param ant1 The 1st Ant object needs to be checked
	 * @param ant2 The 2nd Ant object needs to be checked
	 * 
	 * @return A boolean variable indicating whether the two given ants are collided
	 */
	private boolean isCollided(Ant ant1, Ant ant2) {
		// TODO Change the 0.2 below to a value related to the given ant's speed and the
		// game's timeGap.
		return Math.abs(ant1.getLocation() - ant2.getLocation()) < this.maxAntSpeed * 2 * 1 / 1000;
	}

	/**
	 * Performs a alive check for a chosen ant. If it is out of the pole bound, it
	 * should be killed.
	 * 
	 * @param ant An Ant object of the chosen ant
	 */
	private void performAliveCheck(Ant ant) {
		if (ant.isAlive()) {
			if (isOutOfBound(ant)) {
				System.out.println(">>" + ant.getName() + " killed at location " + ant.getLocation());
				ant.kill();
				this.aliveNumber--;
			}
		}
	}

	/**
	 * Indicates whether the two given ants in the parameter is collided.
	 * 
	 * @param ant The 1st Ant object needs to be checked
	 * 
	 * @return A boolean variable indicating whether the ant is out of the bound
	 */
	private boolean isOutOfBound(Ant ant) {
		return Math.abs(ant.getLocation()) < this.maxAntSpeed * 1 / 1000 || Math.abs(ant.getLocation() - this.size) < this.maxAntSpeed * 1 / 1000;
	}
	
	private double getMaxAntSpeed() {
		double result = Double.MIN_VALUE;
		for (Ant ant : this.ants) {
			result = ant.getSpeed()>result?ant.getSpeed():result;
		}
		return result;
	}

	@Override
	public int getAliveNumber() {
		return this.aliveNumber;
	}

	@Override
	public List<Ant> getAnts() {
		return this.ants;
	}

	@Override
	public double getSize() {
		return this.size;
	}

	@Override
	public void setAntsDirection(int bits) {
		for (int antIndex = 0; antIndex < this.ants.size(); ++antIndex) {
			Ant ant = ants.get(antIndex);
			int lastBit = (bits >> antIndex) % 2;
			if (lastBit == 0) {
				ant.setDirection(Direction.LEFT);
			} else {
				ant.setDirection(Direction.RIGHT);
			}
		}
	}

}
