package com.uncooleben.OOAD.lab01.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.impl.PoleImpl;
import com.uncooleben.OOAD.lab01.main.GameBatch;
import com.uncooleben.OOAD.lab01.util.GameConfig;

public class AntGameFrame extends JFrame implements Runnable {
	private ArrayList<JTextField> antPos = new ArrayList<>();
	private JLabel time = new JLabel();
	private JTextField timeGap = new JTextField(5);
	private JTextField speed= new JTextField(5);
	private JLabel longestField=new JLabel();
	private JLabel shortestField=new JLabel();
	private GameBatch gameBatch;
	private DrawComponent drawComponent;

	public void setGameBatch(GameBatch gameBatch) {
		this.gameBatch = gameBatch;
	}

	public AntGameFrame() {
		JPanel buttonPanel = new JPanel();
		JPanel drawPanel = new JPanel();
		JPanel infoPanel = new JPanel();
		setTitle("Ant Game");
		// set frame size according to actual screen size
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		final int DEFAULT_WIDTH = (int) (screenSize.width * 0.7);
		final int DEFAULT_HEIGHT = (int) (screenSize.height * 0.7);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);
		// format info panel
		JTextField ant0 = new JTextField(8);
		ant0.setText("15");
		antPos.add(ant0);
		JTextField ant1 = new JTextField(8);
		ant1.setText("40");
		antPos.add(ant1);
		JTextField ant2 = new JTextField(8);
		ant2.setText("55");
		antPos.add(ant2);
		JTextField ant3 = new JTextField(8);
		ant3.setText("80");
		antPos.add(ant3);
		JTextField ant4 = new JTextField(8);
		ant4.setText("125");
		antPos.add(ant4);
		JTextField poleLen = new JTextField(10);
		poleLen.setText("150");
		speed.setText("50");
		timeGap.setText("1");
		// set layout
		GridBagLayout layout = new GridBagLayout();
		infoPanel.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 100;
		constraints.weighty = 100;
		constraints.gridy = 0;
		for (constraints.gridx = 0; constraints.gridx < 5; constraints.gridx++) {
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Ant" + constraints.gridx + ":", JLabel.RIGHT));
			tempPanel.add(antPos.get(constraints.gridx));
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridy = 1;
		constraints.gridx = 0;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("PoleLength(cm):", JLabel.RIGHT));
			tempPanel.add(poleLen);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 1;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Longest time(ms):", JLabel.RIGHT));
			tempPanel.add(longestField);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 2;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Shortest time(ms):", JLabel.RIGHT));
			tempPanel.add(shortestField);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 3;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Time gap(ms):", JLabel.RIGHT));
			tempPanel.add(timeGap);
			infoPanel.add(tempPanel, constraints);
		}
		constraints.gridx = 4;
		{
			JPanel tempPanel = new JPanel();
			tempPanel.add(new JLabel("Speed(cm/s):", JLabel.RIGHT));
			tempPanel.add(speed);
			infoPanel.add(tempPanel, constraints);
		}
		// add subpanel to main panel
		add(infoPanel, BorderLayout.NORTH);
		drawComponent = new DrawComponent(new PoleImpl(150, new ArrayList<Ant>()),this);
		AntGameFrame frame = this;
		// format button panel
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField[] antTexts = new JTextField[] { ant0, ant1, ant2, ant3, ant4 };
				double[] antLocations = new double[5];
				int locationIndex = 0;
				for (JTextField antText : antTexts) {
					antLocations[locationIndex++] = Double.parseDouble(antText.getText());
				}
				double poleLength = Double.parseDouble(poleLen.getText());
				int moveSpeed=Integer.parseInt(speed.getText());
				int interval=Integer.parseInt(timeGap.getText());
				GameConfig gameConfig = new GameConfig(interval, poleLength, 5, antLocations,
						new double[] { moveSpeed, moveSpeed, moveSpeed, moveSpeed, moveSpeed }, frame);
				gameBatch = new GameBatch(gameConfig, frame);
				gameBatch.initializeGame();
				timeGap.setText(String.valueOf(interval));
				for(JTextField antText: antTexts)
				{
					antText.setEditable(false);
				}
				poleLen.setEditable(false);
				speed.setEditable(false);
				timeGap.setEditable(false);
				drawComponent.setGameBatch(gameBatch);
				synchronized (frame) {
					frame.notifyAll();
				}
			}
		});
		buttonPanel.add(startButton);
		/*JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonPanel.add(resetButton);*/
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(exitButton);
		add(drawComponent, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public GameBatch getGameBatch() {
		return this.gameBatch;
	}

	public DrawComponent getDrawComponent() {
		return this.drawComponent;
	}

	public void setDrawComponent(DrawComponent drawComponent) {
		this.drawComponent = drawComponent;
	}

	public void setLongestField(String longestValue) {
		this.longestField.setText(longestValue);
	}

	public void setShortestField(String shortestValue) {
		this.shortestField.setText(shortestValue);
	}
}
