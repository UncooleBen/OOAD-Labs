package com.uncooleben.OOAD.lab01.character.factory;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.impl.AntImpl;
import com.uncooleben.OOAD.lab01.util.Direction;

/**
 * A factory class which creates Ant objects.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class AntFactory {

	/**
	 * Creates and returns a new Ant object.
	 * 
	 * @param name      A string indicating the ant's name
	 * @param speed     A double indicating the ant's speed
	 * @param direction A Direction Enum object indicating the ant's direction
	 * @param location  A double indicating the ant's location
	 * 
	 * @return A newly created Ant object according to the given parameters
	 */
	public static Ant createAnt(String name, double speed, Direction direction, double location) {
		return new AntImpl(name, speed, direction, location);
	}

}
