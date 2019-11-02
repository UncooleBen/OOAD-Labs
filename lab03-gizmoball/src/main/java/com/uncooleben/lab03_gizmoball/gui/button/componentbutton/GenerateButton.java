package com.uncooleben.lab03_gizmoball.gui.button.componentbutton;

import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Generate;

public class GenerateButton extends ComponentButton {

	private static final long serialVersionUID = 1757392920013472259L;

	public GenerateButton() {
		super("Generate", "generate.PNG");
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
		return Generate.class;
	}

}
