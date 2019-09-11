package com.uncooleben.OOAD.lab01.character;

import com.uncooleben.OOAD.lab01.exception.GameNotSetException;
import com.uncooleben.OOAD.lab01.exception.GameOverException;

public interface ClimbingGame {

	public void startGame() throws GameNotSetException;

	public void timeElapse() throws GameOverException;

	public boolean isGameOver();

	public long getTime();

}
