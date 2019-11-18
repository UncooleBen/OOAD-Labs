package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Circle extends Component {

	public Circle(int x, int y) {
		super("CIRCLE", x, y);
	}

	@Override
	public void rotate() {

	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Ellipse2D circle = new Ellipse2D.Double(x, y, SCALE * get_size(), SCALE * get_size());
		shapes.add(circle);
		return shapes;
	}

	@Override
	public List<int[]> get_occupied() {
		List<int[]> result = new ArrayList<int[]>();
		if (get_size() == 1) {
			result.add(new int[] { get_x(), get_y() });
			return result;
		}
		double center_x = get_x() + get_size() / 2.0;
		double center_y = get_y() + get_size() / 2.0;
		double r = get_size() / 2.0;
		for (int x = get_x(); x < get_x() + get_size(); x++) {
			for (int y = get_y(); y < get_y() + get_size(); y++) {
				if (euclid_distance(x, y, center_x, center_y) < r || euclid_distance(x + 1, y, center_x, center_y) < r
						|| euclid_distance(x, y + 1, center_x, center_y) < r
						|| euclid_distance(x + 1, y + 1, center_x, center_y) < r) {
					result.add(new int[] { x, y });
				}
			}
		}
		return result;
	}

	private double euclid_distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

}
