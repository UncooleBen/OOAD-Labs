package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.BendedRail;
import com.uncooleben.lab03_gizmoball.gui.component.Component;

public class BendedRailButton extends ComponentButton {

	private static final long serialVersionUID = -6643214477184955387L;

	public BendedRailButton() {
		super("Bended", "bended.PNG");
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
		return BendedRail.class;
	}

}
