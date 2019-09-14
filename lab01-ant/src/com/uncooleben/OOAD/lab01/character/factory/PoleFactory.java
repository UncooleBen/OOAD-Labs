package com.uncooleben.OOAD.lab01.character.factory;

import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.character.impl.PoleImpl;

/**
 * A factory class which creates Pole objects.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class PoleFactory {

	/**
	 * Creates and returns a new Pole object.
	 * 
	 * @param size A double variable indicating the size of the pole
	 * @param ants A java.util.List object containing the ants on the pole
	 *
	 * @return A newly created Pole object according to the given parameters
	 */
	public static Pole createPole(double size, List<Ant> ants) {
		return new PoleImpl(size, ants);
	}
}
