package com.uncooleben.OOAD.lab01.character.impl;

import java.util.ArrayList;
import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.util.Direction;

public class PoleImpl implements Pole {

	private int size;
	private List<Ant> ants;
	private int aliveNumber;

	public PoleImpl(int size, List<Ant> ants) {
		this.size = size;
		this.ants = new ArrayList<Ant>(ants);
		this.aliveNumber = this.ants.size();
	}

	@Override
	public void moveByTime(long time) {
		for (Ant ant : this.ants) {
			if (ant.isAlive()) {
				if (ant.getDirection().equals(Direction.LEFT)) {
					ant.setLocation((int) (ant.getLocation() - ant.getSpeed() * time));
				} else {
					ant.setLocation((int) (ant.getLocation() + ant.getSpeed() * time));
				}
			}
		}
	}

	@Override
	public void performCheck() {
		for (int location = 0; location < this.size; ++location) {
			performCollisionCheck(location);
		}

		for (Ant ant : ants) {
			performAliveCheck(ant);
		}
	}

	private void performCollisionCheck(int location) {
		Ant firstAntAtLocation = null;
		boolean isCollided = false;
		for (Ant ant : this.ants) {
			if (ant.getLocation() == location) {
				if (firstAntAtLocation == null) {
					firstAntAtLocation = ant;
				} else {
					System.out.println(">>" + ant.getName() + " collides at location " + ant.getLocation());
					ant.changeDirection();
					isCollided = true;
				}
			}
		}
		if (isCollided) {
			System.out.println(
					">>" + firstAntAtLocation.getName() + " collides at location " + firstAntAtLocation.getLocation());
			firstAntAtLocation.changeDirection();
		}
	}

	private void performAliveCheck(Ant ant) {
		if (ant.isAlive()) {
			if (ant.getLocation() < 0 || ant.getLocation() >= size) {
				System.out.println(">>" + ant.getName() + " killed at location" + ant.getLocation());
				ant.kill();
				this.aliveNumber--;
			}
		}
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
	public int getSize() {
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
