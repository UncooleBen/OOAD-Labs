package com.uncooleben.OOAD.lab01.character.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;

public class ClimbingGameImpl implements ClimbingGame {

	private Pole pole;
	private long time;
	private long timeGap;

	public ClimbingGameImpl(Pole pole, long timeGap) {
		this.pole = pole;
		this.time = 0L;
		this.timeGap = timeGap;
	}

	@Override
	public void startGame() {
		System.out.println("Climbing Game Started");
		int safe = 0;
		while (!isGameOver()) {
			System.out.println("Current Time: " + this.time);
			printAnts();
			try {
				TimeUnit.MILLISECONDS.sleep(timeGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeElapse();
			if (safe++ > 100) {
				break;
			}
		}
		System.out.println("Climbing Ended At Time: " + this.time + "\n--------------------------");
	}

	@Override
	public void timeElapse() {
		this.pole.moveByTime(timeGap);
		this.pole.performCheck();
		time += timeGap;
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

	private void printAnts() {
		HashMap<Integer, Integer> locationToAnt = new HashMap<Integer, Integer>();
		for (Ant ant : this.pole.getAnts()) {
			locationToAnt.put(ant.getLocation(), Integer.parseInt(ant.getName()));
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

}
