package com.uncooleben.lab03_gizmoball.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.uncooleben.lab03_gizmoball.gui.component.Component;

public class MapParser {

	private static DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

	public static List<Component> parse(String filename) {
		List<Component> result = new ArrayList<Component>();
		try {
			DocumentBuilder builder = _factory.newDocumentBuilder();
			Document doc = builder.parse(filename);
			NodeList componentList = doc.getElementsByTagName("component");
			for (int index = 0; index < componentList.getLength(); index++) {
				Node node = componentList.item(index);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String type = element.getAttribute("type");
					int x = Integer.valueOf(element.getAttribute("x"));
					int y = Integer.valueOf(element.getAttribute("y"));
					int size = Integer.valueOf(element.getAttribute("size"));
					int direction = Integer.valueOf(element.getAttribute("direction"));

				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace(System.err);
		} catch (SAXException saxe) {
			saxe.printStackTrace(System.err);
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		}
		return result;
	}

}
