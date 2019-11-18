package com.uncooleben.lab03_gizmoball.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Import extends JMenuItem {

	private static final long serialVersionUID = 7223183419112597545L;

	private static final String NAME = "Import";

	public Import() {
		super(NAME, KeyEvent.VK_I);
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
	}

}
