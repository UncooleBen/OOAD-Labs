package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;

public class SelectButton extends ComponentButton {

	private static final long serialVersionUID = 6621229509994571721L;

	public SelectButton() {
		super("Select", "select.PNG");
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
		return null;
	}
}
