package com.uncooleben.OOAD.lab01.character;

/**
 * The interface declares methods which an ClimbingGame class should implement.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public interface ClimbingGame {

	/**
	 * Starts the climbing game.
	 */
	public void startGame();

	/**
	 * A refresh/update method called when the clock signal ticks
	 */
	public void timeElapse();

	/**
	 * Gets whether the game is over.
	 * 
	 * @return A boolean variable indicating whether the game is over
	 */
	public boolean isGameOver();

	/**
	 * Gets the current time of the game.
	 * 
	 * @return A long integer variable indicating the current time.
	 */
	public long getTime();

	/**
	 * Gets the pole object own by the climbing game.
	 * 
	 * @return A Pole object
	 */
	public Pole getPole();

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
