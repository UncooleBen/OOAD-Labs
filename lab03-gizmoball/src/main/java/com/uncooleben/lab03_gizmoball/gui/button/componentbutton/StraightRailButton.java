package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.StraightRail;

public class StraightRailButton extends ComponentButton {

	private static final long serialVersionUID = -4117857970341334022L;

	public StraightRailButton() {
		super("Straight", "straight.PNG");
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
		return StraightRail.class;
	}
}
