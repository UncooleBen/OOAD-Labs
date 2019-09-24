package com.uncooleben.OOAD.lab01.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

public class Main {

	private static AntGameFrame frame;

	public static void main(String[] args) {
		int a[] = new int[] { 0, 1, 2, 3, 4 };
		List<Integer> list = new ArrayList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		System.out.print(sum);
		long start = System.currentTimeMillis();
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
			long end = System.currentTimeMillis() - start;
		}

	}

}
