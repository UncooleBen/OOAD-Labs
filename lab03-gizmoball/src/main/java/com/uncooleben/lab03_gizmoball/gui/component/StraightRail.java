package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class StraightRail extends Component {

	private final int GAP = 4;

	public StraightRail(int x, int y) {
		super("STRAIGHTRAIL", x, y);
	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Line2D line1 = new Line2D.Double(x + GAP, y, x + GAP, y + SCALE * get_size());
		Line2D line2 = new Line2D.Double(x + SCALE - GAP, y, x + SCALE - GAP, y + SCALE * get_size());
		if (get_direction() == 1 || get_direction() == 3) {
			line1 = new Line2D.Double(x, y + GAP, x + SCALE * get_size(), y + GAP);
			line2 = new Line2D.Double(x, y + SCALE * get_size() - GAP, x + SCALE * get_size(),
					y + SCALE * get_size() - GAP);
		}
		shapes.add(line1);
		shapes.add(line2);
		return shapes;
	}

}
