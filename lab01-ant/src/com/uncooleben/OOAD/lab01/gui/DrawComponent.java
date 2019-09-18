package com.uncooleben.OOAD.lab01.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.Pole;

public class DrawComponent extends JComponent {
	private int width;
	private int height;
	private double centerX;
	private double centerY;
	private Pole pole;

	public DrawComponent(Pole pole) {
		super();
		this.pole = pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// draw boundary
		double leftX = 1;
		double topY = 1;
		Dimension size = this.getSize();
		width = size.width;
		height = size.height;
		Rectangle2D boundary = new Rectangle2D.Double(leftX, topY, width - 3, height - 2);
		g2.draw(boundary);
		// draw pole
		centerX = boundary.getCenterX();
		centerY = boundary.getCenterY();
		double ratio = width / this.pole.getSize();
		// System.out.println("ratio==" + ratio);
		Line2D poleLine = new Line2D.Double(centerX - width / 2, centerY, centerX + width / 2, centerY);
		int index = 0;
		Color[] colors = new Color[] { Color.RED, Color.BLUE, Color.GRAY, Color.ORANGE, Color.CYAN };
		for (Ant ant : this.pole.getAnts()) {
			System.out.println(ant.getLocation());
			Rectangle2D antRect = new Rectangle2D.Double(centerX - width / 2 + ratio * ant.getLocation(), centerY - 2.5,
					10, 10);
			setColor(g2, antRect, colors[index++]);
			g2.draw(antRect);
		}
		g2.setPaint(Color.BLACK);
		g2.draw(poleLine);
	}

	private void setColor(Graphics2D g2, Rectangle2D rect, Color color) {
		g2.setPaint(color);
		g2.fill(rect);
	}
}
