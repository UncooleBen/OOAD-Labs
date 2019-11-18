package com.uncooleben.lab03_gizmoball.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Export extends JMenuItem {

	private static final long serialVersionUID = 8780505447983564182L;

	private static final String NAME = "Export";

	public Export() {
		super(NAME, KeyEvent.VK_E);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
	}

}
