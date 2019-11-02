package com.uncooleben.lab03_gizmoball.gui.section;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.uncooleben.lab03_gizmoball.gui.menu.Export;
import com.uncooleben.lab03_gizmoball.gui.menu.Import;
import com.uncooleben.lab03_gizmoball.gui.menu.Menu;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -8635460505309736339L;

	private final int BAR_HEIGHT = 30;
	
	private final int BAR_WIDTH = 800;
	
	private Menu _menu;
	
	private Export _export;
	
	private Import _import;
	
	public MenuBar() {
		_menu = new Menu();
		_import = new Import();
		_export = new Export();
		_menu.add(_import);
		_menu.add(_export);
		add(_menu);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
	}
	
}
