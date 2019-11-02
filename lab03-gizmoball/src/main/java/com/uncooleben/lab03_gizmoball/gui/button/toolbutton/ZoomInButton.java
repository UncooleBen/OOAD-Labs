package com.uncooleben.lab03_gizmoball.gui.button.toolbutton;

import com.uncooleben.lab03_gizmoball.gui.section.Grid;

public class ZoomInButton extends ToolButton {

	private static final long serialVersionUID = 3454245309828489513L;

	public ZoomInButton() {
		super("Zoom In", "zoomin.PNG");
	}

	@Override
	public void push(Grid grid) {
		grid.zoomInSelectedComponent();
	}

}
