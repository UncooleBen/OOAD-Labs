package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Ball extends Component {

	public Ball(int x, int y) {
		super("BALL", x, y);
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
		result.add(new int[] { get_x(), get_y() });
		return result;
	}

}
