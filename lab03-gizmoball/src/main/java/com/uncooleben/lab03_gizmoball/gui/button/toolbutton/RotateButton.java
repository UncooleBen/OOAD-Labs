package com.uncooleben.lab03_gizmoball.gui.button.toolbutton;

import com.uncooleben.lab03_gizmoball.gui.section.Grid;

public class RotateButton extends ToolButton {

	private static final long serialVersionUID = 2137623905521808891L;

	public RotateButton() {
		super("Rotate", "rotate.PNG");
	}

	@Override
	public void push(Grid grid) {
		grid.rotateSelectedComponent();
	}

}
