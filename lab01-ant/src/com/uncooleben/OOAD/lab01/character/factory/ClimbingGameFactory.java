package com.uncooleben.OOAD.lab01.character.factory;

import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.character.impl.ClimbingGameImpl;

/**
 * A factory class which creates ClimbingGame objects.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class ClimbingGameFactory {

	/**
	 * Creates and returns a new ClimbingGame object.
	 * 
	 * @param pole    A Pole object owned by the game
	 * @param timeGap A long integer indicating the time gap (in milliseconds) to
	 *                refresh/update the game status
	 *
	 * @return A newly created ClimbingGame object according to the given parameters
	 */
	public static ClimbingGame createClimbingGame(Pole pole, long timeGap) {
		return new ClimbingGameImpl(pole, timeGap);
	}
}
