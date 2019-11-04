package com.uncooleben.lab03_gizmoball.gui.section;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.uncooleben.lab03_gizmoball.gui.component.Absorb;
import com.uncooleben.lab03_gizmoball.gui.component.Circle;
import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Generate;
import com.uncooleben.lab03_gizmoball.gui.component.Select;
import com.uncooleben.lab03_gizmoball.gui.component.Square;
import com.uncooleben.lab03_gizmoball.gui.component.Triangle;

public class Grid extends JPanel {

	private static final long serialVersionUID = -7998861704675419778L;

	private final int GRID_WIDTH = 640;

	private final int GRID_HEIGHT = 640;

	private final int GRID_CENTER_X = 640 / 2;

	private final int GRID_CENTER_Y = 640 / 2;

	private final int CELL_HEIGHT = 32;

	private final int CELL_WIDTH = 32;

	private final int LINE_NUMBER = GRID_HEIGHT / CELL_HEIGHT - 1;

	private final int LINE_LENGTH = 640;

	private final int NUMBER = 20;

	private List<Component> _components = new ArrayList<Component>();

	private boolean[][] _occupied = new boolean[NUMBER][];

	private Select _select = null;

	private Generate _generate = null;

	private Absorb _absorb = null;

	private Component _selectedComponent = null;

	public Grid() {
		for (int index = 0; index < NUMBER; index++) {
			_occupied[index] = new boolean[NUMBER];
			for (int subIndex = 0; subIndex < NUMBER; subIndex++) {
				_occupied[index][subIndex] = false;
			}
		}
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(GRID_WIDTH, GRID_HEIGHT));
	}

	private void enterOccupy(Component component) {
		for (int[] arr : component.get_occupied()) {
			_occupied[arr[0]][arr[1]] = true;
		}
	}

	private void giveoutOccupy(Component component) {
		for (int[] arr : component.get_occupied()) {
			_occupied[arr[0]][arr[1]] = false;
		}
	}

	private boolean isConflicted(Component component) {
		for (int[] arr : component.get_occupied()) {
			if (_occupied[arr[0]][arr[1]] == true) {
				return true;
			}
		}
		return false;
	}

	private boolean isBoundarySafe(Component component) {
		System.out.println(component.get_x() + component.get_size());
		if (component.get_x() + component.get_size() > NUMBER) {
			return false;
		}
		if (component.get_y() + component.get_size() > NUMBER) {
			return false;
		}
		return true;
	}

	public void addComponent(Component component) {
		if (_occupied[component.get_x()][component.get_y()] == true) {
			return;
		}
		if (component instanceof Generate) {
			if (_generate != null) {
				return;
			} else {
				_generate = (Generate) component;
			}
		}
		if (component instanceof Absorb) {
			if (_absorb != null) {
				return;
			} else {
				_absorb = (Absorb) component;
			}
		}
		enterOccupy(component);
		_components.add(component);
	}

	public void removeSelect() {
		_select = null;
		_selectedComponent = null;
	}

	public void removeSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			System.out.println("no selected component, delete failed");
			return;
		}
		System.out.println("deleting " + _selectedComponent);
		_components.remove(_selectedComponent);
		if (_selectedComponent instanceof Absorb) {
			_absorb = null;
		}
		if (_selectedComponent instanceof Generate) {
			_generate = null;
		}
		giveoutOccupy(_selectedComponent);
		removeSelect();
	}

	public void rotateSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		giveoutOccupy(_selectedComponent);
		_selectedComponent.rotate();
		if (!isBoundarySafe(_selectedComponent) || isConflicted(_selectedComponent)) {
			System.out.println("rotation failed due to conflict");
			_selectedComponent.rotate();
			_selectedComponent.rotate();
			_selectedComponent.rotate();
		}
		enterOccupy(_selectedComponent);
	}

	public void zoomInSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		int origin_size = _selectedComponent.get_size();
		giveoutOccupy(_selectedComponent);
		_selectedComponent.zoom_in();
		if (!isBoundarySafe(_selectedComponent) || isConflicted(_selectedComponent)) {
			System.out.println("zoom in failed due to conflict");
			_selectedComponent.set_size(origin_size);
		} else {
			_select.set_size(_selectedComponent.get_size());
		}
		enterOccupy(_selectedComponent);
	}

	public void zoomOutSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		giveoutOccupy(_selectedComponent);
		_selectedComponent.zoom_out();
		_select.set_size(_selectedComponent.get_size());
		enterOccupy(_selectedComponent);
	}

	public boolean select(int x, int y) {
		for (Component component : _components) {
			for (int[] arr : component.get_occupied()) {
				int occupied_x = arr[0];
				int occupied_y = arr[1];
				int c_size = component.get_size();
				int c_x = component.get_x();
				int c_y = component.get_y();
				if (x == occupied_x && y == occupied_y) {
					_select = new Select(c_x, c_y, c_size);
					_selectedComponent = component;
					return true;
				}
			}
		}
		removeSelect();
		return false;
	}

	// public void importFromXML()

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(Color.WHITE);
		// Draw the web
		for (int horizonalIndex = 0; horizonalIndex < LINE_NUMBER; horizonalIndex++) {
			Line2D line = new Line2D.Double(GRID_CENTER_X - LINE_LENGTH / 2, CELL_HEIGHT + horizonalIndex * CELL_HEIGHT,
					GRID_CENTER_X + LINE_LENGTH / 2, CELL_HEIGHT + horizonalIndex * CELL_HEIGHT);
			graphics2d.draw(line);
		}
		for (int verticalIndex = 0; verticalIndex < LINE_NUMBER; verticalIndex++) {
			Line2D line = new Line2D.Double(CELL_WIDTH + verticalIndex * CELL_HEIGHT, GRID_CENTER_Y - LINE_LENGTH / 2,
					CELL_WIDTH + verticalIndex * CELL_HEIGHT, GRID_CENTER_Y + LINE_LENGTH / 2);
			graphics2d.draw(line);
		}
		// Draw components
		for (Component component : _components) {
			for (Shape s : component.get_shapes()) {
				graphics2d.draw(s);
				if (component instanceof Triangle || component instanceof Square || component instanceof Circle) {
					graphics2d.fill(s);
				}
			}
		}
		// Draw selection square
		if (_select != null) {
			graphics2d.setStroke(new BasicStroke(2));
			graphics2d.setColor(Color.RED);
			for (Shape s : _select.get_shapes()) {
				graphics2d.draw(s);
			}
		}

	}
}
