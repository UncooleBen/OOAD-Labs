package com.uncooleben.OOAD.lab01.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780756319003467280L;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			AntGameFrame frame = new AntGameFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		/*
		 * File file = new File( "document\\gameConfig.xml"); GameBatch gameBatch = new
		 * GameBatch(file); gameBatch.startGameBatch();
		 */
	}

}
