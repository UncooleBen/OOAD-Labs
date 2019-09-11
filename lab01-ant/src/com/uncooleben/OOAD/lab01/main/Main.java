package com.uncooleben.OOAD.lab01.main;

import java.io.File;

import javax.swing.JFrame;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780756319003467280L;

	public static void main(String[] args) {
		File file = new File(
				"C:\\Users\\Juntao Peng\\Desktop\\Object-Oriented Design\\Labs\\lab01-ant\\document\\gameConfig.xml");
		GameBatch gameBatch = new GameBatch(file);
		gameBatch.startGameBatch();
	}

}
