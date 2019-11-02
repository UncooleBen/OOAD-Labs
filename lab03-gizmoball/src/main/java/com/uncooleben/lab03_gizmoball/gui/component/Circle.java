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
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Ellipse2D circle = new Ellipse2D.Double(x, y, SCALE * get_size(), SCALE * get_size());
		shapes.add(circle);
		return shapes;
	}

}
