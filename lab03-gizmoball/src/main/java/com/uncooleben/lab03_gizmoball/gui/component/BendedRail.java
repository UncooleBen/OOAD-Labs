package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

public class BendedRail extends Component {

	private final int GAP = 4;

	public BendedRail(int x, int y) {
		super("BENDEDRAIL", x, y);
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
		Arc2D arc1 = new Arc2D.Double(x + GAP, y - SCALE + GAP, (SCALE - GAP) * 2, (SCALE - GAP) * 2, 180, 90,
				Arc2D.OPEN);
		Arc2D arc2 = new Arc2D.Double(x + SCALE - GAP, y - GAP, GAP * 2, GAP * 2, 180, 90, Arc2D.OPEN);
		switch (get_direction()) {
		case 1:
			arc1 = new Arc2D.Double(x + GAP, y + GAP, (SCALE - GAP) * 2, (SCALE - GAP) * 2, 90, 90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x + SCALE - GAP, y + SCALE - GAP, GAP * 2, GAP * 2, 90, 90, Arc2D.OPEN);
			break;
		case 2:
			arc1 = new Arc2D.Double(x - SCALE + GAP, y + GAP, (SCALE - GAP) * 2, (SCALE - GAP) * 2, 0, 90, Arc2D.OPEN);
			arc2 = new Arc2D.Double(x - GAP, y + SCALE - GAP, GAP * 2, GAP * 2, 0, 90, Arc2D.OPEN);
			break;
		case 3:
			arc1 = new Arc2D.Double(x - SCALE + GAP, y - SCALE + GAP, (SCALE - GAP) * 2, (SCALE - GAP) * 2, -90, 90,
					Arc2D.OPEN);
			arc2 = new Arc2D.Double(x - GAP, y - GAP, GAP * 2, GAP * 2, -90, 90, Arc2D.OPEN);
			break;
		}
		shapes.add(arc1);
		shapes.add(arc2);
		return shapes;
	}

	@Override
	public List<int[]> get_occupied() {
		List<int[]> result = new ArrayList<int[]>();
		result.add(new int[] { get_x(), get_y() });
		return result;
	}

}
