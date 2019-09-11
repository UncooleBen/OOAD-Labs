package com.uncooleben.OOAD.lab01.character;

import java.util.UUID;

import com.uncooleben.OOAD.lab01.util.Direction;

public interface Ant {

	public String getName();

	public int getSpeed();

	public int getLocation();

	public void setLocation(int location);

	public void setDirection(Direction direction);

	public Direction getDirection();

	public void changeDirection();

	public UUID getUUID();

	public boolean isAlive();

	public void kill();

}
