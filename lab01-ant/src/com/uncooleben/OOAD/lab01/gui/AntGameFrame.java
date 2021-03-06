package com.uncooleben.OOAD.lab01.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.impl.PoleImpl;
import com.uncooleben.OOAD.lab01.main.GameBatch;
import com.uncooleben.OOAD.lab01.util.GameConfig;

/**
 * A class that creates the main frame of the GUI
 *
 * <p>
 *
 * <p>
 * This is a part of OOAD-Lab01 project.
 *
 * @author Shangzhen Li, Juntao Peng
 */
public class AntGameFrame extends JFrame {

	private static final long serialVersionUID = 4165050065969620385L;

	private GameBatch gameBatch;

	private JPanel buttonPanel;

	private JPanel infoPanel;

	private List<JTextField> antPosField;

	private List<JTextField> antSpeedField;

	private JTextField poleLengthField;

	private JTextField timeGapField;

	private JLabel longestField;

	private JLabel shortestField;

	private int DEFAULT_WIDTH;

	private int DEFAULT_HEIGHT;

	private DrawComponent drawComponent;
	private boolean done;

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public AntGameFrame() {
		// set main frame's attributes
		initializeFields();
		setTitle("Ant Game");
		fetchFrameSize();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);

		// set default value
		setAntPosField(new String[] { "30", "80", "110", "160", "250" });
		setAntSpeedField(new String[] { "5", "5", "5", "5", "5" });
		setAntAttr("300", "1");

		// form infoPanel
		GridBagLayout layout = new GridBagLayout();
		infoPanel.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 100;
		constraints.weighty = 100;
		// ants' start position
		constraints.gridy = 0;
		for (constraints.gridx = 0; constraints.gridx < 5; constraints.gridx++) {
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Ant" + constraints.gridx + ":", JLabel.RIGHT));
			tempPanel.add(antPosField.get(constraints.gridx));
			infoPanel.add(tempPanel, constraints);
		}
		// ants' speed
		constraints.gridy = 1;
		for (constraints.gridx = 0; constraints.gridx < 5; constraints.gridx++) {
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Speed" + constraints.gridx + ":", JLabel.RIGHT));
			tempPanel.add(antSpeedField.get(constraints.gridx));
			infoPanel.add(tempPanel, constraints);
		}
		// pole's length
		constraints.gridy = 2;
		constraints.gridx = 0;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("PoleLength(cm):", JLabel.RIGHT));
			tempPanel.add(poleLengthField);
			infoPanel.add(tempPanel, constraints);
		}
		// time information
		constraints.gridx = 1;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Longest time:", JLabel.RIGHT));
			tempPanel.add(longestField);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 2;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Shortest time:", JLabel.RIGHT));
			tempPanel.add(shortestField);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 3;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Time gap:", JLabel.RIGHT));
			tempPanel.add(timeGapField);
			infoPanel.add(tempPanel, constraints);
		}
		// add infoPanel to main panel
		add(infoPanel, BorderLayout.NORTH);

		// form drawPanel
		drawComponent = new DrawComponent(new PoleImpl(150, new ArrayList<Ant>()), this);
		add(drawComponent, BorderLayout.CENTER);

		// format buttonPanel
		AntGameFrame frame = this;
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+System.currentTimeMillis());
				// get user's input(may be the default value)
				double[] antLocations = new double[5];
				double[] antSpeeds = new double[5];
				int tempIndex = 0;
				for (JTextField antPosText : antPosField) {
					antLocations[tempIndex++] = Double.parseDouble(antPosText.getText());
				}
				tempIndex = 0;
				for (JTextField antSpeedText : antSpeedField) {
					antSpeeds[tempIndex++] = Double.parseDouble(antSpeedText.getText());
				}
				double poleLength = Double.parseDouble(poleLengthField.getText());
				int interval = Integer.parseInt(timeGapField.getText());
				// configure the game
				GameConfig gameConfig = new GameConfig(interval, poleLength, 5, antLocations, antSpeeds, frame);
				gameBatch = new GameBatch(gameConfig, frame);
				gameBatch.initializeGame();
				// Initialization done. Set all input fields uneditable.
				timeGapField.setText(String.valueOf(interval));
				for (JTextField antPosText : antPosField) {
					antPosText.setEditable(false);
				}
				for (JTextField antSpeedText : antSpeedField) {
					antSpeedText.setEditable(false);
				}
				poleLengthField.setEditable(false);
				timeGapField.setEditable(false);
				drawComponent.setGameBatch(gameBatch);
				startButton.setEnabled(false);
				// All ready. Start game.
				synchronized (frame) {
					frame.notifyAll();
				}
			}
		});
		buttonPanel.add(startButton);
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+System.currentTimeMillis());
				System.exit(0);
			}
		});
		buttonPanel.add(exitButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void initializeFields() {
		this.antPosField = new ArrayList<JTextField>();
		this.antSpeedField = new ArrayList<JTextField>();
		this.buttonPanel = new JPanel();
		this.infoPanel = new JPanel();
		this.poleLengthField = new JTextField(8);
		this.timeGapField = new JTextField(5);
		this.longestField = new JLabel();
		this.shortestField = new JLabel();
	}

	/** set frame size according to actual screen size */
	private void fetchFrameSize() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.DEFAULT_WIDTH = (int) (screenSize.width * 0.7);
		this.DEFAULT_HEIGHT = (int) (screenSize.height * 0.7);
	}

	private void setAntPosField(String[] antPositions) {
		for (int index = 0; index < antPositions.length; index++) {
			JTextField antTextField = new JTextField(8);
			antTextField.setText(antPositions[index]);
			this.antPosField.add(antTextField);
		}
	}

	private void setAntSpeedField(String[] antSpeeds) {
		for (int index = 0; index < antSpeeds.length; index++) {
			JTextField antTextField = new JTextField(8);
			antTextField.setText(antSpeeds[index]);
			this.antSpeedField.add(antTextField);
		}
	}

	private void setAntAttr(String poleLength, String timeGap) {
		poleLengthField.setText(poleLength);
		timeGapField.setText(timeGap);
	}

	public GameBatch getGameBatch() {
		return this.gameBatch;
	}

	public DrawComponent getDrawComponent() {
		return this.drawComponent;
	}

	public void setLongestField(String longestValue) {
		this.longestField.setText(longestValue);
	}

	public void setShortestField(String shortestValue) {
		this.shortestField.setText(shortestValue);
	}
}
