package com.uncooleben.OOAD.lab01.character;

import java.util.List;

public interface Pole {

	public void moveByTime(long time);

	public void performCheck();

	public int getAliveNumber();

	public List<Ant> getAnts();

	public double getSize();

	public void setAntsDirection(int bits);

}
