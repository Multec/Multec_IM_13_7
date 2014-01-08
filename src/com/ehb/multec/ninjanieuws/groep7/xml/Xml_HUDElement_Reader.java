package com.ehb.multec.ninjanieuws.groep7.xml;

import java.io.File;
import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.util.MTColor;
import org.mt4j.util.xml.XmlHandler;
import org.w3c.dom.*;

import com.ehb.multec.ninjanieuws.groep7.background.HUDElement;
import com.ehb.multec.ninjanieuws.groep7.background.UserControlPanelHUDElement;

// http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
public class Xml_HUDElement_Reader {
	private ArrayList<HUDElement> HUDElements = new ArrayList<HUDElement>();
	
	public Xml_HUDElement_Reader(MTApplication mtApplication) {
		File f = new File("data/xml/HUDcoordinates.xml");
		
		XmlHandler xmlHandler = XmlHandler.getInstance();
		Document xmlFile = xmlHandler.load(f);
		
		NodeList allElements = xmlFile.getElementsByTagName("HUDElement");
		for (int i = 0; i < allElements.getLength(); i++) {
			Node HUDElementNode = allElements.item(i);
			
			if (HUDElementNode.getNodeType() == Node.ELEMENT_NODE) {				
				Element currentElement = (Element) HUDElementNode;
				
				HUDElement tempHUDElement;
				if (currentElement.getAttribute("type").equals("ucp")) {
					tempHUDElement = new UserControlPanelHUDElement(new MTColor(Integer.parseInt(currentElement.getAttribute("r")), 
							Integer.parseInt(currentElement.getAttribute("g")), 
							Integer.parseInt(currentElement.getAttribute("b"))), currentElement.getAttribute("name"), 
							mtApplication,
							Integer.parseInt(currentElement.getAttribute("centreV")), 
							Integer.parseInt(currentElement.getAttribute("centreW")));
				} else {
					tempHUDElement = new HUDElement(new MTColor(Integer.parseInt(currentElement.getAttribute("r")), 
							Integer.parseInt(currentElement.getAttribute("g")), 
							Integer.parseInt(currentElement.getAttribute("b"))), currentElement.getAttribute("name"));
				}
				
				
				NodeList currentElementChildren = currentElement.getChildNodes();
				
				for (int j = 0; j < currentElementChildren.getLength(); j++) {
					Node HUDElementChildrenNode = currentElementChildren.item(j);
					if (HUDElementChildrenNode.getNodeType() == Node.ELEMENT_NODE) {
						Element currentChild = (Element) HUDElementChildrenNode;
						
						int[] tempCoordinate = new int[2];
						tempCoordinate[0] = Integer.parseInt(currentChild.getAttribute("x"));
						tempCoordinate[1] = Integer.parseInt(currentChild.getAttribute("y"));
						tempHUDElement.addCoordinate(tempCoordinate);
					}
				}
				this.HUDElements.add(tempHUDElement);
			}
		}
	}

	public ArrayList<HUDElement> getHUDElements() {
		return HUDElements;
	}
}
