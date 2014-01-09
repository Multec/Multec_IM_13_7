package com.ehb.multec.ninjanieuws.groep7.xml;

import java.io.File;
import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.util.xml.XmlHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml_Movie_Reader {
	private ArrayList<String> ninjaMoviePaths = new ArrayList<String>();
	private ArrayList<String> ninjaMovieTitles = new ArrayList<String>();
	
	public Xml_Movie_Reader(MTApplication mtApplication) {
		File f = new File("data/xml/ninjamovies.xml");
		XmlHandler xmlHandler = XmlHandler.getInstance();
		Document xmlFile = xmlHandler.load(f);
		//System.out.println(xmlFile.getDocumentElement().getNodeName()+ " bevat:");
		//System.out.println("-------------------");
		NodeList ninjanieuws = xmlFile.getElementsByTagName("ninjamovie");
		for (int i = 0; i < ninjanieuws.getLength(); i++) {
			Node userNode = ninjanieuws.item(i);
			if (userNode.getNodeType() == Node.ELEMENT_NODE) {
				Element nieuws = (Element) userNode;
				//System.out.println(nieuws.getAttribute("link") + " - " + nieuws.getTextContent());
				ninjaMoviePaths.add(nieuws.getAttribute("link"));
				ninjaMovieTitles.add(nieuws.getTextContent());
			}
		}
	}

	public ArrayList<String> getNinjaMoviePaths() {
		return ninjaMoviePaths;
	}

	public ArrayList<String> getNinjaMovieTitles() {
		return ninjaMovieTitles;
	}
}
