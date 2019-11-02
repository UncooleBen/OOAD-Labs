package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Generate extends Component {

	public Generate(int x, int y) {
		super("GENERATE", x, y);
	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Line2D line1 = new Line2D.Double(x + SCALE * get_size() / 2, y, x + SCALE * get_size() / 2,
				y + SCALE * get_size());
		Line2D line2 = new Line2D.Double(x, y + SCALE * get_size() / 2, x + SCALE * get_size(),
				y + SCALE * get_size() / 2);
		shapes.add(line1);
		shapes.add(line2);
		return shapes;
	}

}
