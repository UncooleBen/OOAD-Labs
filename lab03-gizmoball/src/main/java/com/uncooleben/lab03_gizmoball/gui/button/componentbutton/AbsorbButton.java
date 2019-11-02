package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Absorb;
import com.uncooleben.lab03_gizmoball.gui.component.Component;

public class AbsorbButton extends ComponentButton {

	private static final long serialVersionUID = -1784811257691971173L;

	public AbsorbButton() {
		super("Absorb", "absorb.PNG");
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
		return Absorb.class;
	}

}
