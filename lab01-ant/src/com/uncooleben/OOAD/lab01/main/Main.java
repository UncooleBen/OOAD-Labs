package com.uncooleben.OOAD.lab01.main;

import javax.swing.JFrame;

import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780756319003467280L;

	private static AntGameFrame frame;
	private static GameBatch gameBatch;

	public static void main(String[] args) {
		frame = new AntGameFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		synchronized (frame) {
			try {
				frame.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.getGameBatch().startGameBatch();
		}

	}

}
