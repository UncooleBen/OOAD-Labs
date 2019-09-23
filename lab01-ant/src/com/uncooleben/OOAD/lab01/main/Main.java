package com.uncooleben.OOAD.lab01.main;

import javax.swing.JFrame;

import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

public class Main {

	private static AntGameFrame frame;

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
