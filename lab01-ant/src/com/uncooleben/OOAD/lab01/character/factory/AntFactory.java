package com.uncooleben.OOAD.lab01.character.factory;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.impl.AntImpl;
import com.uncooleben.OOAD.lab01.util.Direction;

public class AntFactory {

	public static Ant createAnt(String name, int speed, Direction direction, int location) {
		return new AntImpl(name, speed, direction, location);
	}

}
