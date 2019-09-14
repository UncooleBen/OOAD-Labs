package com.uncooleben.OOAD.lab01.character;

import java.util.UUID;

import com.uncooleben.OOAD.lab01.util.Direction;

/**
 * The interface declares methods which an Ant class should implement.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public interface Ant {

	/**
	 * Gets the name of an ant object.
	 * 
	 * @return The name of an ant object
	 */
	public String getName();

	/**
	 * Gets the speed of an ant object.
	 * 
	 * @return The speed of an ant object
	 */
	public double getSpeed();

	/**
	 * Gets the location of an ant object.
	 * 
	 * @return The location of an ant object
	 */
	public double getLocation();

	/**
	 * Sets the location of an ant object.
	 * 
	 * @param location The location to set
	 */
	public void setLocation(double location);

	/**
	 * Sets the direction of an ant object.
	 * 
	 * @param direction The direction to set
	 */
	public void setDirection(Direction direction);

	/**
	 * Gets the direction of an ant object.
	 * 
	 * @return The direction of an ant object
	 */
	public Direction getDirection();

	/**
	 * Changes the direction of an ant object, which is often called when there is a
	 * collision between two ants.
	 */
	public void changeDirection();

	/**
	 * Gets the UUID of an ant object.
	 * 
	 * @return The UUID of an ant object
	 */
	public UUID getUUID();

	/**
	 * Gets the living status of an ant object.
	 * 
	 * @return A boolean indicating whether the an ant object is alive
	 */
	public boolean isAlive();

	/**
	 * Kills a living ant and change its living status to false.
	 */
	public void kill();

}
