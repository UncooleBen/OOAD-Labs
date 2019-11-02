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

import com.uncooleben.lab03_gizmoball.gui.component.Circle;
import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Select;
import com.uncooleben.lab03_gizmoball.gui.component.Square;
import com.uncooleben.lab03_gizmoball.gui.component.Triangle;

public class Grid extends JPanel {

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

	public boolean addComponent(Component component) {
		if (_occupied[component.get_x()][component.get_y()] == true) {
			return false;
		}
		_occupied[component.get_x()][component.get_y()] = true;
		_components.add(component);
		System.out.println(_components.size());
		return true;
	}

	public void removeSelect() {
		_select = null;
		_selectedComponent = null;
	}

	public void removeSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			System.out.println("early return");
			return;
		}
		System.out.println("removing " + _selectedComponent);
		_components.remove(_selectedComponent);
		removeSelect();
	}

	public void rotateSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		_selectedComponent.rotate();
	}

	public void zoomInSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		_selectedComponent.zoom_in();
		_select.set_size(_selectedComponent.get_size());
	}

	public void zoomOutSelectedComponent() {
		if (_select == null || _selectedComponent == null) {
			return;
		}
		_selectedComponent.zoom_out();
		_select.set_size(_selectedComponent.get_size());
	}

	public boolean select(int x, int y) {
		for (Component component : _components) {
			int c_x = component.get_x();
			int c_y = component.get_y();
			int c_size = component.get_size();
			if ((x >= c_x && x < c_x + c_size) && (y >= c_y && y < c_y + c_size)) {
				_select = new Select(c_x, c_y, c_size);
				_selectedComponent = component;
				return true;
			}
		}
		return false;
	}

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
