package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Square extends Component {

	public Square(int x, int y) {
		super("SQUARE", x, y);
	}

	@Override
	public void rotate() {

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

	@Override
	public List<int[]> get_occupied() {
		List<int[]> result = new ArrayList<int[]>();
		for (int x = get_x(); x < get_x() + get_size(); x++) {
			for (int y = get_y(); y < get_y() + get_size(); y++) {
				result.add(new int[] { x, y });
			}
		}
		return result;
	}

}
