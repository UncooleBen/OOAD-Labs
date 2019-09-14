package com.uncooleben.OOAD.lab01.character.impl;

import java.util.UUID;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.util.Direction;

/**
 * An implementation class which implements the Ant interface.
 * <p>
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 * 
 */
public class AntImpl implements Ant {

	private UUID uuid;
	private String name;
	private double speed;
	private double location;
	private Direction direction;
	private boolean isAlive;

	/**
	 * Constructs an AntImpl object according to the given parameters.
	 * <p>
	 * This constructor should not be called explicitly. Use AntFactory class's
	 * static method 'create' instead.
	 * 
	 * @param name      A string indicating the ant's name
	 * @param speed     A double indicating the ant's speed
	 * @param direction A Direction Enum object indicating the ant's direction
	 * @param location  A double indicating the ant's location
	 */
	public AntImpl(String name, double speed, Direction direction, double location) {
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.speed = speed;
		this.direction = direction;
		this.location = location;
		this.isAlive = true;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public UUID getUUID() {
		return this.uuid;
	}

	@Override
	public double getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(double location) {
		this.location = location;
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void changeDirection() {
		if (this.direction.equals(Direction.LEFT)) {
			this.direction = Direction.RIGHT;
		} else {
			this.direction = Direction.LEFT;
		}
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void kill() {
		this.isAlive = false;
	}

}
