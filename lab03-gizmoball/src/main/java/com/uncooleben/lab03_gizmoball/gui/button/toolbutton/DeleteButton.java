package com.uncooleben.lab03_gizmoball.gui.button.toolbutton;

import com.uncooleben.lab03_gizmoball.gui.section.Grid;

public class DeleteButton extends ToolButton {

	private static final long serialVersionUID = -7737219486388156618L;

	public DeleteButton() {
		super("Delete", "delete.PNG");
	}

	@Override
	public void push(Grid grid) {
		System.out.println("Delete pushed");
		grid.removeSelectedComponent();
	}

}
