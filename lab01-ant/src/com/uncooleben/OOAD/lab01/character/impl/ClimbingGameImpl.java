package com.uncooleben.OOAD.lab01.character.impl;

import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.exception.GameNotSetException;
import com.uncooleben.OOAD.lab01.exception.GameOverException;

public class ClimbingGameImpl implements ClimbingGame {

	private Pole pole;
	private long time;
	private long timeGap;
	private boolean isGameSet;

	public ClimbingGameImpl(Pole pole, long timeGap) {
		this.pole = null;
		this.time = 0L;
		this.timeGap = 0L;
		this.isGameSet = false;
	}

	@Override
	public void startGame() throws GameNotSetException {
		if (!this.isGameSet) {
			throw new GameNotSetException();
		}
	}

	@Override
	public void timeElapse() throws GameOverException {
		if (isGameOver()) {
			throw new GameOverException();
		}
		pole.performCheck();
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

}
