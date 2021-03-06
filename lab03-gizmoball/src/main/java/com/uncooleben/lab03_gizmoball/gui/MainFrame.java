package com.uncooleben.lab03_gizmoball.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.AbsorbButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.BendedRailButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.CircleButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.ComponentButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.GenerateButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.SelectButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.SquareButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.StraightRailButton;
import com.uncooleben.lab03_gizmoball.gui.button.componentbutton.TriangleButton;
import com.uncooleben.lab03_gizmoball.gui.button.modebutton.LayoutButton;
import com.uncooleben.lab03_gizmoball.gui.button.modebutton.ModeButton;
import com.uncooleben.lab03_gizmoball.gui.button.modebutton.PlayButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.DeleteButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.RotateButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.ToolButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.ZoomInButton;
import com.uncooleben.lab03_gizmoball.gui.button.toolbutton.ZoomOutButton;
import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.menu.Export;
import com.uncooleben.lab03_gizmoball.gui.menu.Import;
import com.uncooleben.lab03_gizmoball.gui.section.ComponentBar;
import com.uncooleben.lab03_gizmoball.gui.section.Grid;
import com.uncooleben.lab03_gizmoball.gui.section.MenuBar;
import com.uncooleben.lab03_gizmoball.gui.section.ModeBar;
import com.uncooleben.lab03_gizmoball.gui.section.ToolBar;
import com.uncooleben.lab03_gizmoball.service.MapParser;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 9115443447216484330L;

	private final int DEFAULT_HEIGHT = 710;

	private final int DEFAULT_WIDTH = 840;

	private final int SCALE = 32;

	private boolean _layoutMode = true;

	private Grid _grid;

	private ComponentBar _componentBar;

	private ToolBar _toolBar;

	private ModeBar _modeBar;

	private MenuBar _menuBar;

	private final Import _import = new Import();

	private final Export _export = new Export();

	private final SelectButton _selectButton = new SelectButton();

	private final GenerateButton _generateButton = new GenerateButton();

	private final AbsorbButton _absorbButton = new AbsorbButton();

	private final SquareButton _squareButton = new SquareButton();

	private final TriangleButton _triangleButton = new TriangleButton();

	private final CircleButton _circleButtion = new CircleButton();

	private final StraightRailButton _straightRailButton = new StraightRailButton();

	private final BendedRailButton _bendedRailButton = new BendedRailButton();

	private final DeleteButton _deleteButton = new DeleteButton();

	private final RotateButton _rotateButton = new RotateButton();

	private final ZoomInButton _zoomInButton = new ZoomInButton();

	private final ZoomOutButton _zoomOutButton = new ZoomOutButton();

	private final LayoutButton _layoutButton = new LayoutButton();

	private final PlayButton _playButton = new PlayButton();

	private final ComponentButton[] _componentButtons = new ComponentButton[] { _selectButton, _generateButton,
			_absorbButton, _squareButton, _triangleButton, _circleButtion, _straightRailButton, _bendedRailButton };

	private final ToolButton[] _toolButtons = new ToolButton[] { _deleteButton, _rotateButton, _zoomInButton,
			_zoomOutButton };

	private final ModeButton[] _modeButtons = new ModeButton[] { _layoutButton, _playButton };

	private ComponentButton _currentlyPressed = _selectButton;

	public MainFrame() {
		// Initialize components
		_grid = new Grid();
		_componentBar = new ComponentBar(_selectButton, _generateButton, _absorbButton, _squareButton, _triangleButton,
				_circleButtion, _straightRailButton, _bendedRailButton);
		_toolBar = new ToolBar(_deleteButton, _rotateButton, _zoomInButton, _zoomOutButton);
		_modeBar = new ModeBar(_layoutButton, _playButton);
		_menuBar = new MenuBar(_import, _export);
		// Set JFrame attributes
		setTitle("Gizmo Ball");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);
		// Set JFrame layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		add(_menuBar, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.gridx = 0;
		c.gridy = 1;
		add(_grid, c);

		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 1;
		add(_componentBar, c);

		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 2;
		add(_toolBar, c);

		c.gridheight = 1;
		c.gridx = 1;
		c.gridy = 3;
		add(_modeBar, c);

		// Add Listener
		for (ComponentButton componentButton : _componentButtons) {
			componentButton.addActionListener(new ComponentButtonListener(componentButton));
		}
		for (ToolButton toolButton : _toolButtons) {
			toolButton.addActionListener(new ToolButtonListener(toolButton));
		}
		_grid.addMouseListener(new GridMouseListener());

		_import.addActionListener(new ImportMenuItemListener());

		_export.addActionListener(new ExportMenuItemListener());

		_layoutButton.addActionListener(new LayoutButtonListener());

		_playButton.addActionListener(new PlayButtonListener());

	}

	private class ComponentButtonListener implements ActionListener {

		private ComponentButton _componentButton;

		public ComponentButtonListener(ComponentButton componentButton) {
			_componentButton = componentButton;
		}

		public void actionPerformed(ActionEvent e) {
			_componentButton.push();
			_currentlyPressed = _componentButton;
		}

	}

	private class ToolButtonListener implements ActionListener {

		private ToolButton _toolButton;

		public ToolButtonListener(ToolButton toolButton) {
			_toolButton = toolButton;
		}

		public void actionPerformed(ActionEvent e) {
			_toolButton.push(_grid);
			_grid.repaint();
		}

	}

	private class ImportMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Gizmoball Map (.xml)", "xml");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(new File("C:\\Users\\pengj\\Desktop\\Object-Oriented Design\\Labs"));
			int return_value = chooser.showOpenDialog(null);
			if (return_value == JFileChooser.APPROVE_OPTION) {
				List<Component> map_components = MapParser.parse(chooser.getSelectedFile().getPath());
				_grid.reloadFromXML(map_components);
				_grid.repaint();
			}
		}

	}

	private class ExportMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Gizmoball Map (.xml)", "xml");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(new File("C:\\Users\\pengj\\Desktop\\Object-Oriented Design\\Labs"));
			int return_value = chooser.showSaveDialog(null);
			if (return_value == JFileChooser.APPROVE_OPTION) {
				MapParser.save(_grid.get_components(), chooser.getSelectedFile().getPath());
			}
		}

	}

	private class LayoutButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_layoutMode = true;
			_componentBar.enableButtons();
			_toolBar.enableButtons();

		}

	}

	private class PlayButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			_layoutMode = false;
			_componentBar.disableButtons();
			_toolBar.disableButtons();
			_playButton.setEnabled(false);
			// TODO: Game running code here
		}

	}

	private class GridMouseListener implements MouseListener {

		public GridMouseListener() {
			super();
		}

		public void mouseClicked(MouseEvent e) {
			System.out.printf("clicked at (%d, %d)\n", e.getX(), e.getY());
			System.out.println("Component button: " + _currentlyPressed.getText());
			if (_currentlyPressed != _selectButton) {
				_grid.removeSelect();
				int x = e.getX() / SCALE;
				int y = e.getY() / SCALE;
				Component component;
				try {
					component = _currentlyPressed.get_cls().getDeclaredConstructor(new Class[] { int.class, int.class })
							.newInstance(x, y);
					_grid.addComponent(component);
					System.out.printf("%s added at (%d, %d)\n", _currentlyPressed.getText(), x, y);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				int x = e.getX() / SCALE;
				int y = e.getY() / SCALE;
				boolean result = _grid.select(x, y);
				if (result == true) {
					System.out.printf("Select square added at (%d, %d)\n", x, y);
				} else {
					_grid.removeSelect();
				}
			}
			_grid.repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
