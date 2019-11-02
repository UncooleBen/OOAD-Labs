package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Square;

public class SquareButton extends ComponentButton {

	private static final long serialVersionUID = 7068685094189440467L;

	public SquareButton() {
		super("Square", "square.PNG");
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
		return Square.class;
	}

}
