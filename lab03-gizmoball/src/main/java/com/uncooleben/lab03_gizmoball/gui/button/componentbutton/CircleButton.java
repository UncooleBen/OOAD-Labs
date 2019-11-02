package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Circle;
import com.uncooleben.lab03_gizmoball.gui.component.Component;

public class CircleButton extends ComponentButton {

	private static final long serialVersionUID = 5313931064430259986L;

	public CircleButton() {
		super("Circle", "circle.PNG");
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
		return Circle.class;
	}
}
