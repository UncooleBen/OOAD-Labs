package com.uncooleben.OOAD.lab01.character.impl;

import java.util.ArrayList;
import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;

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
					ant.changeDirection();
					isCollided = true;
				}
			}
		}
		if (isCollided) {
			firstAntAtLocation.changeDirection();
		}
	}

	private void performAliveCheck(Ant ant) {
		if (ant.isAlive()) {
			if (ant.getLocation() < 0 || ant.getLocation() >= size) {
				ant.kill();
				this.aliveNumber--;
			}
		}
	}

	@Override
	public int getAliveNumber() {
		return this.aliveNumber;
	}

}
