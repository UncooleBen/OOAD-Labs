package com.uncooleben.OOAD.lab01.character.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.util.Direction;

public class PoleImpl implements Pole {

	private double size;
	private List<Ant> ants;
	private int aliveNumber;

	public PoleImpl(double size, List<Ant> ants) {
		this.size = size;
		this.ants = new ArrayList<Ant>(ants);
		this.aliveNumber = this.ants.size();
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

	private boolean isCollided(Ant ant1, Ant ant2) {
		return Math.abs(ant1.getLocation() - ant2.getLocation()) < 0.2;
	}

	private void performAliveCheck(Ant ant) {
		if (ant.isAlive()) {
			if (isOutOfBound(ant)) {
				System.out.println(">>" + ant.getName() + " killed at location " + ant.getLocation());
				ant.kill();
				this.aliveNumber--;
			}
		}
	}

	private boolean isOutOfBound(Ant ant) {
		return Math.abs(ant.getLocation()) < 0.1 || Math.abs(ant.getLocation() - this.size) < 0.1;
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
