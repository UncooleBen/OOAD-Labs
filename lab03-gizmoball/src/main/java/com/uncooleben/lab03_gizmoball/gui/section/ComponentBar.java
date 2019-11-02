package com.uncooleben.lab03_gizmoball.gui.section;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.AbsorbButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.BendedRailButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.CircleButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.GenerateButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.SelectButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.SquareButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.StraightRailButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.TriangleButton;

public class ComponentBar extends JPanel {

	private static final long serialVersionUID = 3528121005321716991L;

	private final int BAR_HEIGHT = 320;

	private final int BAR_WIDTH = 180;

	private final ButtonGroup _buttonGroup = new ButtonGroup();

	private final SelectButton _selectButton;

	private final GenerateButton _generateButton;

	private final AbsorbButton _absorbButton;

	private final SquareButton _squareButton;

	private final TriangleButton _triangleButton;

	private final CircleButton _circleButtion;

	private final StraightRailButton _straightRailButton;

	private final BendedRailButton _bendedRailButton;

	public ComponentBar(SelectButton _selectButton, GenerateButton _generateButton, AbsorbButton _absorbButton,
			SquareButton _squareButton, TriangleButton _triangleButton, CircleButton _circleButtion,
			StraightRailButton _straightRailButton, BendedRailButton _bendedRailButton) {
		super();
		// Initialize components
		this._selectButton = _selectButton;
		this._generateButton = _generateButton;
		this._absorbButton = _absorbButton;
		this._squareButton = _squareButton;
		this._triangleButton = _triangleButton;
		this._circleButtion = _circleButtion;
		this._straightRailButton = _straightRailButton;
		this._bendedRailButton = _bendedRailButton;
		_buttonGroup.add(_selectButton);
		_buttonGroup.add(_generateButton);
		_buttonGroup.add(_absorbButton);
		_buttonGroup.add(_squareButton);
		_buttonGroup.add(_triangleButton);
		_buttonGroup.add(_circleButtion);
		_buttonGroup.add(_straightRailButton);
		_buttonGroup.add(_bendedRailButton);
		_selectButton.getModel().setPressed(true);
		// Set attributes
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));
		setLayout(new GridBagLayout());
		// Set GridBagLayout
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(_selectButton, c);

		c.gridx = 1;
		c.gridy = 0;
		add(_generateButton, c);

		c.gridx = 0;
		c.gridy = 1;
		add(_absorbButton, c);

		c.gridx = 1;
		c.gridy = 1;
		add(_squareButton, c);

		c.gridx = 0;
		c.gridy = 2;
		add(_triangleButton, c);

		c.gridx = 1;
		c.gridy = 2;
		add(_circleButtion, c);

		c.gridx = 0;
		c.gridy = 3;
		add(_straightRailButton, c);

		c.gridx = 1;
		c.gridy = 3;
		add(_bendedRailButton, c);
	}

}
