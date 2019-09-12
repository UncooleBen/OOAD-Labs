package com.uncooleben.OOAD.lab01.character;

import java.util.UUID;

import com.uncooleben.OOAD.lab01.util.Direction;

public interface Ant {

	public String getName();

	public double getSpeed();

	public double getLocation();

	public void setLocation(double location);

	public void setDirection(Direction direction);

	public Direction getDirection();

	public void changeDirection();

	public UUID getUUID();

	public boolean isAlive();

	public void kill();

}
