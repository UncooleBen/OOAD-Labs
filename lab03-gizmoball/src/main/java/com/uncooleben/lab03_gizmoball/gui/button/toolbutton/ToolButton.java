package com.uncooleben.lab03_gizmoball.gui.button.toolbutton;

import java.awt.Dimension;

import javax.swing.JButton;

import com.uncooleben.lab03_gizmoball.gui.section.Grid;

public abstract class ToolButton extends JButton {

	private static final int BUTTON_WIDTH = 90;

	private static final int BUTTON_HEIGHT = 80;

	private String _name;

	private String _imagePath;

	public ToolButton(String name, String imagePath) {
		_name = name;
		_imagePath = imagePath;
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		setText(_name);
	}

	public abstract void push(Grid grid);
}
