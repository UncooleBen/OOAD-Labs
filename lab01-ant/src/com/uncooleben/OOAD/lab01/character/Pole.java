package com.uncooleben.OOAD.lab01.character;

import java.util.List;

/**
 * The interface declares methods which an Pole class should implement.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public interface Pole {

	/**
	 * Makes all Ant object owned by the Pole move towards their own direction for a
	 * period of time.
	 * 
	 * @param time A long integer variable indicating the forward time
	 */
	public void moveByTime(long time);

	/**
	 * Performs a check according to the game rule.
	 */
	public void performCheck(long timeGap);

	/**
	 * Gets the number of alive ants.
	 * 
	 * @return An integer variable indicating the alive number of ants in the Pole
	 */
	public int getAliveNumber();

	/**
	 * Gets a java.util.List object containing all ants owned by the Pole.
	 * 
	 * @return A java.util.List object containing all ants owned by the Pole
	 */
	public List<Ant> getAnts();

	/**
	 * Gets the size of a Pole.
	 * 
	 * @return A double variable indicating the pole size.
	 */
	public double getSize();

	/**
	 * Configures the start direction of all ants according to a bit string.
	 * <p>
	 * Example
	 * <p>
	 * If there are 5 ants in the pole, bits = 20(Dec) = 10100(Bin) will set the
	 * ants' direction as 'Right, Left, Right, Left, Left'.
	 * 
	 * @param bits An integer that can be converted to direction configuration. (0
	 *             <= bits <= ((1<<numOfAnts)-1))
	 */
	public void setAntsDirection(int bits);

}
