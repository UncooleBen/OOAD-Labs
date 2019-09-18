package com.uncooleben.OOAD.lab01.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class DrawComponent extends JComponent {

	private double _height;

	private double _width;

	public DrawComponent(double height, double width) {
		super();
		this._height = height;
		this._width = width;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		double leftX = 0;
		double topY = 0;
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, this._width, this._height);
		g2.draw(rect);
	}
}
