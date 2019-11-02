package com.uncooleben.lab03_gizmoball.gui.button.modebutton;

import java.awt.Dimension;

import javax.swing.JButton;

public abstract class ModeButton extends JButton {

	private static final int BUTTON_WIDTH = 140;

	private static final int BUTTON_HEIGHT = 40;

	private String _name;

	private String _imagePath;

	public ModeButton(String name, String imagePath) {
		_name = name;
		_imagePath = imagePath;
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		setText(_name);
	}

	public abstract void push();

}
