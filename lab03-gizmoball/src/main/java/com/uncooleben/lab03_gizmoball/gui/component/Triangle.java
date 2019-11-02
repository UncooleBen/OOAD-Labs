package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Polygon;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends Component {

	public Triangle(int x, int y) {
		super("TRIANGLE", x, y);
	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		int[] xpoints = new int[] { x, x, x + SCALE * get_size() };
		int[] ypoints = new int[] { y, y + SCALE * get_size(), y + SCALE * get_size() };
		switch (get_direction()) {
		case 1:
			xpoints = new int[] { x + SCALE * get_size(), x, x };
			ypoints = new int[] { y, y, y + SCALE * get_size() };
			break;
		case 2:
			xpoints = new int[] { x, x + SCALE * get_size(), x + SCALE * get_size() };
			ypoints = new int[] { y, y, y + SCALE * get_size() };
			break;
		case 3:
			xpoints = new int[] { x + SCALE * get_size(), x + SCALE * get_size(), x };
			ypoints = new int[] { y, y + SCALE * get_size(), y + SCALE * get_size() };
			break;
		}
		Polygon tri = new Polygon(xpoints, ypoints, 3);
		shapes.add(tri);
		return shapes;
	}

}
