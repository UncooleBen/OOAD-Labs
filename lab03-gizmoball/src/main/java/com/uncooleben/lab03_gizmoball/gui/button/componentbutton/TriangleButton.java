package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Triangle;

public class TriangleButton extends ComponentButton {

	private static final long serialVersionUID = -5544962394378416971L;

	public TriangleButton() {
		super("Triangle", "triangle.PNG");
	}

	@Override
	public void push() {
		boolean pressed = getModel().isSelected();
		if (pressed) {
			System.out.println(_name + " selected");
		}
	}

	@Override
	public Class<? extends Component> get_cls() {
		return Triangle.class;
	}

}
