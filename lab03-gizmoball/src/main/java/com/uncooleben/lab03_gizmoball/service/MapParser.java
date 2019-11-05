package com.uncooleben.lab03_gizmoball.service;

import java.io.FileWriter;
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

import com.uncooleben.lab03_gizmoball.gui.component.Absorb;
import com.uncooleben.lab03_gizmoball.gui.component.BendedRail;
import com.uncooleben.lab03_gizmoball.gui.component.Circle;
import com.uncooleben.lab03_gizmoball.gui.component.Component;
import com.uncooleben.lab03_gizmoball.gui.component.Generate;
import com.uncooleben.lab03_gizmoball.gui.component.Square;
import com.uncooleben.lab03_gizmoball.gui.component.StraightRail;
import com.uncooleben.lab03_gizmoball.gui.component.Triangle;

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
					Component component = null;
					switch (type) {
					case "CIRCLE":
						component = new Circle(x, y);
						break;
					case "TRIANGLE":
						component = new Triangle(x, y);
						break;
					case "SQUARE":
						component = new Square(x, y);
						break;
					case "ABSORB":
						component = new Absorb(x, y);
						break;
					case "GENERATE":
						component = new Generate(x, y);
						break;
					case "BENDEDRAIL":
						component = new BendedRail(x, y);
						break;
					case "STRAIGHTRAIL":
						component = new StraightRail(x, y);
						break;
					}
					if (component != null) {
						component.set_size(size);
						component.set_direction(direction);
						result.add(component);
					}
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

	public static void save(List<Component> components, String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			StringBuffer sb = new StringBuffer("<gizmoball-map>\n");
			for (Component component : components) {
				sb.append(String.format("\t<component type=\"%s\" x=\"%s\" y=\"%s\" size=\"%s\" direction=\"%s\" />\n",
						component.get_type(), String.valueOf(component.get_x()), String.valueOf(component.get_y()),
						String.valueOf(component.get_size()), String.valueOf(component.get_direction())));
			}
			sb.append("</gizmoball-map>\n");
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		}
	}
}
