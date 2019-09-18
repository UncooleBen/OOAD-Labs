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
import com.uncooleben.OOAD.lab01.character.factory.ClimbingGameFactory;
import com.uncooleben.OOAD.lab01.character.factory.PoleFactory;

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

	private static List<Ant> ants;
	private static Pole pole;
	private static ClimbingGame climbingGame;

	/**
	 * Parses the game configuration xml file
	 * 
	 * @param file An xml document on the local disk
	 * 
	 * @return A ClimbingGame object configured according to the xml file
	 */
	public static ClimbingGame parse(File file)
			throws ParseException, IOException, ParserConfigurationException, SAXException {
		ants = new ArrayList<Ant>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		Node gameNode = doc.getDocumentElement();
		Node poleNode = doc.getElementsByTagName("Pole").item(0);
		NodeList antList = doc.getElementsByTagName("Ant");
		constructAnts(antList);
		constructPole(poleNode);
		constructClimbingGame(gameNode);
		return climbingGame;
	}

	/**
	 * Constructs all ants according to the xml file.
	 * 
	 * @param antList An org.w3c.dom.NodeList object representing the xml tag/node
	 *                list of <Ant></Ant>
	 */
	private static void constructAnts(NodeList antList) {
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
	private static void constructPole(Node poleNode) {
		double size = Double.parseDouble(poleNode.getAttributes().getNamedItem("size").getNodeValue());
		pole = PoleFactory.createPole(size, ants);
	}

	/**
	 * Constructs one ClimbingGame object according to the xml file.
	 * 
	 * @param gameNode An org.w3c.dom.Node object representing the xml tag/node
	 *                 <ClimbingGame></ClimbingGame>
	 */
	private static void constructClimbingGame(Node gameNode) {
		int timeGap = Integer.parseInt(gameNode.getAttributes().getNamedItem("timeGap").getNodeValue());
		climbingGame = ClimbingGameFactory.createClimbingGame(pole, timeGap);
	}

}