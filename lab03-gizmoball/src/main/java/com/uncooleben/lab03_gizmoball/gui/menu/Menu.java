package com.uncooleben.lab03_gizmoball.gui.menu;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;

public class Menu extends JMenu {

	private static final long serialVersionUID = 1733100987442363586L;

	private final static String NAME = "File";

	private final int MENU_WIDTH = 70;

	private final int MENU_HEIGHT = 30;

	public Menu() {
		super(NAME);
		setMnemonic(KeyEvent.VK_F);
		setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
	}

}
