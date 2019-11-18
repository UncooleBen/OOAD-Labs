package com.uncooleben.lab03_gizmoball.gui.component;

import java.awt.Shape;
import java.util.List;

public abstract class Component {

	private String _type;

	private int _x, _y;

	private int _size = 1;

	protected final int SCALE = 32;

	private int _direction = 0;

	public Component(String type, int x, int y) {
		super();
		this._type = type;
		this._x = x;
		this._y = y;
	}

	public String get_type() {
		return _type;
	}

	public int get_x() {
		return _x;
	}

	public void set_x(int _x) {
		this._x = _x;
	}

	public int get_y() {
		return _y;
	}

	public void set_y(int _y) {
		this._y = _y;
	}

	public void set_size(int size) {
		_size = size;
	}

	public int get_size() {
		return _size;
	}

	public void zoom_in() {
		_size++;
	}

	public void zoom_out() {
		_size--;
		if (_size <= 0) {
			_size = 1;
		}
	}

	public void set_direction(int direction) {
		_direction = direction;
	}

	public int get_direction() {
		return _direction;
	}

	public void rotate() {
		_direction = (_direction + 1) % 4;
	}

	public abstract List<Shape> get_shapes();

	public abstract List<int[]> get_occupied();

}
