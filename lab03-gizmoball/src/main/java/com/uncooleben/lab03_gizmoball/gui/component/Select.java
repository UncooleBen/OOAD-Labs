package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Select extends Component {

	public Select(int x, int y, int size) {
		super("SELECT", x, y);
		set_size(size);
	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Rectangle2D rect = new Rectangle2D.Double(x, y, SCALE * get_size(), SCALE * get_size());
		shapes.add(rect);
		return shapes;
	}

}
