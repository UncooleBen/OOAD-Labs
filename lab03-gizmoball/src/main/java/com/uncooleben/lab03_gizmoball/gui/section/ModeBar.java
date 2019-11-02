package com.uncooleben.lab03_gizmoball.gui.section;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import com.uncooleben.lab03_gizmoball.gui.button.modebutton.LayoutButton;
import com.uncooleben.lab03_gizmoball.gui.button.modebutton.PlayButton;

public class ModeBar extends JPanel {

	private static final long serialVersionUID = -3953950162213889939L;

	private final int BAR_HEIGHT = 160;

	private final int BAR_WIDTH = 180;

	private final LayoutButton _layoutButton;

	private final PlayButton _playButton;

	public ModeBar(LayoutButton _layoutButton, PlayButton _playButton) {
		super();
		// Initialize components
		this._layoutButton = _layoutButton;
		this._playButton = _playButton;
		// Set attributes
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
		// Set GridBagLayout
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(_layoutButton, c);

		c.gridx = 0;
		c.gridy = 1;
		add(_playButton, c);
	}
}
