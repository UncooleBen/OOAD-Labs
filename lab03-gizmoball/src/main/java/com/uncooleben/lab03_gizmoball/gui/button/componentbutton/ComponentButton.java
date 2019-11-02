package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import java.awt.Dimension;

import javax.swing.JToggleButton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;

public abstract class ComponentButton extends JToggleButton {

	private static final int BUTTON_WIDTH = 90;

	private static final int BUTTON_HEIGHT = 80;

	protected String _name;

	private String _imagePath;

	public ComponentButton(String name, String imagePath) {
		_name = name;
		_imagePath = imagePath;
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		setText(_name);
	}

	public abstract void push();

	public abstract Class<? extends Component> get_cls();

}
