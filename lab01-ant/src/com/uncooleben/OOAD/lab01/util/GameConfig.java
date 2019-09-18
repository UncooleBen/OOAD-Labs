package com.uncooleben.OOAD.lab01.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.uncooleben.OOAD.lab01.character.Ant;
import com.uncooleben.OOAD.lab01.character.ClimbingGame;
import com.uncooleben.OOAD.lab01.character.Pole;
import com.uncooleben.OOAD.lab01.character.factory.AntFactory;
import com.uncooleben.OOAD.lab01.character.impl.ClimbingGameImpl;
import com.uncooleben.OOAD.lab01.character.impl.PoleImpl;
import com.uncooleben.OOAD.lab01.gui.AntGameFrame;

/**
 * The class is used to parse the game configuration from an xml file on the
 * local disk.
 * <p>
 * Example
 * <p>
 * See /documents/gameConfig.xml for detail
 * 
 * This is a part of OOAD-Lab01 project.
 * 
 * @author Juntao Peng
 */
public class GameConfig {

	private AntGameFrame frame;
	private List<Ant> ants;
	private Pole pole;
	private ClimbingGame climbingGame;
	private File gameConfigFile;
	private long timeGap;
	private double poleLength;
	private int antNumber;
	private double[] antLocations;
	private double[] antSpeeds;
	private boolean guiFlag;

	public GameConfig(File file, AntGameFrame frame) {
		this.guiFlag = false;
		this.gameConfigFile = file;
		this.frame = frame;
	}

	public GameConfig(long timeGap, double poleLength, int antNumber, double[] antLocations, double[] antSpeeds,
			AntGameFrame frame) {
		this.guiFlag = true;
		this.timeGap = timeGap;
		this.poleLength = poleLength;
		this.antNumber = antNumber;
		this.antLocations = antLocations;
		this.antSpeeds = antSpeeds;
		this.frame = frame;
	}

	/**
	 * Parses the game configuration xml file
	 * 
	 * @param file An xml document on the local disk
	 */
	private void parseXML(File file) throws ParseException, IOException, ParserConfigurationException, SAXException {
		this.ants = new ArrayList<Ant>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		Node gameNode = doc.getDocumentElement();
		Node poleNode = doc.getElementsByTagName("Pole").item(0);
		NodeList antList = doc.getElementsByTagName("Ant");
		constructXMLAnts(antList);
		constructXMLPole(poleNode);
		constructXMLClimbingGame(gameNode);
	}

	/**
	 * Constructs all ants according to the xml file.
	 * 
	 * @param antList An org.w3c.dom.NodeList object representing the xml tag/node
	 *                list of <Ant></Ant>
	 */
	private void constructXMLAnts(NodeList antList) {
		for (int antIndex = 0; antIndex < antList.getLength(); ++antIndex) {
			Node antNode = antList.item(antIndex);
			String antLocation = antNode.getAttributes().getNamedItem("location").getNodeValue();
			String antSpeed = antNode.getAttributes().getNamedItem("speed").getNodeValue();
			String antName = antNode.getAttributes().getNamedItem("name").getNodeValue();
			ants.add(AntFactory.createAnt(antName, Double.parseDouble(antSpeed), Direction.LEFT,
					Double.parseDouble(antLocation)));
		}
	}

	/**
	 * Constructs one Pole object according to the xml file.
	 * 
	 * @param poleNode An org.w3c.dom.Node object representing the xml tag/node
	 *                 <Pole></Pole>
	 */
	private void constructXMLPole(Node poleNode) {
		double size = Double.parseDouble(poleNode.getAttributes().getNamedItem("size").getNodeValue());
		pole = new PoleImpl(size, ants);
	}

	/**
	 * Constructs one ClimbingGame object according to the xml file.
	 * 
	 * @param gameNode An org.w3c.dom.Node object representing the xml tag/node
	 *                 <ClimbingGame></ClimbingGame>
	 */
	private void constructXMLClimbingGame(Node gameNode) {
		int timeGap = Integer.parseInt(gameNode.getAttributes().getNamedItem("timeGap").getNodeValue());
		climbingGame = new ClimbingGameImpl(pole, timeGap, frame);
	}

	/**
	 * Parses the game configuration from GUI.
	 */
	private void parseGUI() {
		this.ants = new ArrayList<Ant>();
		constructGUIAnts(antNumber, antLocations, antSpeeds);
		constructGUIPole(poleLength);
		constructGUIClimbingGame(timeGap);
	}

	/**
	 * Constructs all ants according to the GUI parameters.
	 * 
	 * @param antNumber    An int indicating ant number
	 * @param antLocations A double array indicating the ant location
	 * @param antSpeeds    A double array indicating the ant speed
	 * 
	 */
	private void constructGUIAnts(int antNumber, double[] antLocations, double[] antSpeeds) {
		for (int antIndex = 0; antIndex < antNumber; ++antIndex) {
			ants.add(AntFactory.createAnt(String.valueOf(antIndex), antSpeeds[antIndex], Direction.LEFT,
					antLocations[antIndex]));
		}
	}

	/**
	 * Constructs one Pole object according to the GUI parameters.
	 * 
	 * @param poleLength A double indicating the length of the pole
	 * 
	 */
	private void constructGUIPole(double poleLength) {
		pole = new PoleImpl(poleLength, ants);
	}

	/**
	 * Constructs one ClimbingGame object according to the GUI parameters.
	 * 
	 * @param timeGap A long integer indicating the time gap in milliseconds
	 */
	private void constructGUIClimbingGame(long timeGap) {
		climbingGame = new ClimbingGameImpl(pole, timeGap, frame);
	}

	/**
	 * Gets the climbingGame according to the game config
	 *
	 * @return A ClimbingGame oject configured under the given parameter
	 */
	public ClimbingGame getGame() {
		if (this.guiFlag) {
			this.parseGUI();
		} else {
			try {
				this.parseXML(gameConfigFile);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return this.climbingGame;
	}
}
