package com.uncooleben.lab03_gizmoball.gui.section;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.DeleteButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.RotateButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.ZoomInButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.ZoomOutButton;

public class ToolBar extends JPanel {

	private static final long serialVersionUID = 6641768511212590149L;

	private final int BAR_HEIGHT = 160;

	private final int BAR_WIDTH = 180;

	private final DeleteButton _deleteButton;

	private final RotateButton _rotateButton;

	private final ZoomInButton _zoomInButton;

	private final ZoomOutButton _zoomOutButton;

	public ToolBar(DeleteButton _deleteButton, RotateButton _rotateButton, ZoomInButton _zoomInButton,
			ZoomOutButton _zoomOutButton) {
		super();
		// Initialize components
		this._deleteButton = _deleteButton;
		this._rotateButton = _rotateButton;
		this._zoomInButton = _zoomInButton;
		this._zoomOutButton = _zoomOutButton;
		// Set attributes
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
		setLayout(new GridBagLayout());
		// Set GridBagLayout
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(_deleteButton, c);

		c.gridx = 1;
		c.gridy = 0;
		add(_rotateButton, c);

		c.gridx = 0;
		c.gridy = 1;
		add(_zoomInButton, c);

		c.gridx = 1;
		c.gridy = 1;
		add(_zoomOutButton, c);
	}

	public void disableButtons() {
		this._deleteButton.setEnabled(false);
		this._rotateButton.setEnabled(false);
		this._zoomInButton.setEnabled(false);
		this._zoomOutButton.setEnabled(false);
	}

	public void enableButtons() {
		this._deleteButton.setEnabled(true);
		this._rotateButton.setEnabled(true);
		this._zoomInButton.setEnabled(true);
		this._zoomOutButton.setEnabled(true);
	}

}
