package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Absorb extends Component {

	public Absorb(int x, int y) {
		super("ABSORB", x, y);
	}

	@Override
	public void rotate() {

	}

	@Override
	public void zoom_in() {

	}

	@Override
	public void zoom_out() {

	}

	@Override
	public List<Shape> get_shapes() {
		List<Shape> shapes = new ArrayList<Shape>();
		int x = get_x() * SCALE;
		int y = get_y() * SCALE;
		Line2D line1 = new Line2D.Double(x, y, x + SCALE * get_size(), y + SCALE * get_size());
		Line2D line2 = new Line2D.Double(x, y + SCALE * get_size(), x + SCALE * get_size(), y);
		shapes.add(line1);
		shapes.add(line2);
		return shapes;
	}

	@Override
	public List<int[]> get_occupied() {
		List<int[]> result = new ArrayList<int[]>();
		result.add(new int[] { get_x(), get_y() });
		return result;
	}

}
