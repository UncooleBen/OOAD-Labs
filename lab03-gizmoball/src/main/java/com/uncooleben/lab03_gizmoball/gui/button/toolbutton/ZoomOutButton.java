package com.uncooleben.lab03_gizmoball.gui.button.toolbutton;

import com.uncooleben.lab03_gizmoball.gui.section.Grid;

public class ZoomOutButton extends ToolButton {

	private static final long serialVersionUID = -6030322944025601011L;

	public ZoomOutButton() {
		super("Zoom Out", "zoomout.PNG");
	}

	@Override
	public void push(Grid grid) {
		grid.zoomOutSelectedComponent();
	}

}
