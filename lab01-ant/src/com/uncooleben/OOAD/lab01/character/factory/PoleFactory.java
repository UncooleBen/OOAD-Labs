package com.uncooleben.OOAD.lab01.character.factory;

import java.util.List;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.character.impl.PoleImpl;

public class PoleFactory {

	public static Pole createPole(double size, List<Ant> ants) {
		return new PoleImpl(size, ants);
	}
}
