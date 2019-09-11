package com.uncooleben.OOAD.lab01.character.factory;

import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.character.impl.ClimbingGameImpl;

public class ClimbingGameFactory {

	public static ClimbingGame createClimbingGame(Pole pole, long timeGap) {
		return new ClimbingGameImpl(pole, timeGap);
	}
}
