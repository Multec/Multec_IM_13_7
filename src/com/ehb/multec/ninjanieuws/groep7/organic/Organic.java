package com.ehb.multec.ninjanieuws.groep7.organic;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.sceneManagement.AbstractScene;

public class Organic extends MTComponent {
	private MTApplication mtApplication;
	private AbstractScene scene;
	private ArrayList<Connector> connectors = new ArrayList<Connector>();
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<Node> subNodes = new ArrayList<Node>();

	public Organic(MTApplication mtApplication, AbstractScene scene) {
		super(mtApplication);
		this.mtApplication = mtApplication;
		this.scene = scene;
		createNodes();
	}

	public void createNodes() {
		// Coordinates for Nodes
		int x;
		int y;
		int width = 60;
		int height = 60;
		int subNodeCounter = 0;

		for (int i = 0; i < 5; i++) {
			x = (mtApplication.width - mtApplication.width / 8) - (i * 125);
			y = (int) (mtApplication.height / 2 - (Math.random() * 300 + 1));

			if (i == 0) {
				Node node = new Node(mtApplication, scene, x, y, width, height);
				nodes.add(node);
			} else {
				x = (mtApplication.width - mtApplication.width / 8) - (i * 125);
				y = (int) (mtApplication.height / 2 - (Math.random() * 300 + 1) + (Math
						.random() * 300 + 1));
				Node node = new Node(mtApplication, scene, x, y, width, height);
				nodes.add(node);
				Node node_1 = nodes.get(i - 1);
				Node node_2 = nodes.get(i);
				Connector conn = new Connector(mtApplication, scene, node_1,
						node_2);
				connectors.add(conn);
				if (returnTrueOrFalse(50)) {
					if (subNodes.size() == 0) {
						x = (mtApplication.width - mtApplication.width / 8)
								- (i * 125);
						y = (int) ((mtApplication.height / 2) + (Math.random() * 300 + 1));
						Node node2 = new Node(mtApplication, scene, x, y,
								width, height);
						subNodes.add(node2);
						addChild(node2);
						node_1 = nodes.get(i);
						node_2 = subNodes.get(subNodeCounter);
						Connector conn2 = new Connector(mtApplication, scene,
								node_1, node_2);
						connectors.add(conn2);
						subNodeCounter += 1;
					} else {
						x = (mtApplication.width - mtApplication.width / 8)
								- (i * 125);
						y = (int) ((mtApplication.height / 2) + (Math.random() * 300 + 1));

						Node node2 = new Node(mtApplication, scene, x, y,
								width, height);
						subNodes.add(node2);
						node_1 = subNodes.get(subNodeCounter - 1);
						node_2 = subNodes.get(subNodeCounter);
						Connector conn2 = new Connector(mtApplication, scene,
								node_1, node_2);
						connectors.add(conn2);
						subNodeCounter += 1;

					}
				}
			}
		}
		/*
		 * for (int i = 0; i < 10; i++) { // Initialize Node connectors x =
		 * (mtApplication.width - mtApplication.width / 8) - (i * 125); y =
		 * (int) (mtApplication.height / 2 - (Math.random() * 300 + 1) + (Math
		 * .random() * 300 + 1)); width = 60; height = 60; Node node = new
		 * Node(mtApplication, scene, x, y, width, height); nodes1.add(node);
		 * /*if (returnTrueOrFalse(50)) { x = (mtApplication.width -
		 * mtApplication.width / 8) - (i * 125); y = (int) (mtApplication.height
		 * / 2 - (Math.random() * 300 + 1) + (Math .random() * 300 + 1)); Node
		 * node2 = new Node(mtApplication, scene, x, y, width, height);
		 * nodes.add(node2); } } for (int i = 0; i < 10; i++) { // Initialize
		 * Node connectors x = (mtApplication.width - mtApplication.width / 8) -
		 * (i * 125); y = (int) (mtApplication.height / 2 - (Math.random() * 300
		 * + 1) + (Math .random() * 300 + 1)); width = 60; height = 60; Node
		 * node = new Node(mtApplication, scene, x, y, width, height);
		 * nodes2.add(node); /*if (returnTrueOrFalse(50)) { x =
		 * (mtApplication.width - mtApplication.width / 8) - (i * 125); y =
		 * (int) (mtApplication.height / 2 - (Math.random() * 300 + 1) + (Math
		 * .random() * 300 + 1)); Node node2 = new Node(mtApplication, scene, x,
		 * y, width, height); nodes.add(node2); } }
		 * 
		 * 
		 * for (int i = 0; i < nodes1.size(); i++) { if (i != 0) { // Initialize
		 * connector coordinates Node node1 = nodes1.get(i - 1); Node node2 =
		 * nodes1.get(i); Connector conn = new Connector(mtApplication, scene,
		 * node1, node2); conectors1.add(conn); addChild(conn);
		 * 
		 * } }for (int i = 0; i < nodes2.size(); i++) { if (i != 0) { //
		 * Initialize connector coordinates Node node1 = nodes1.get(i - 1); Node
		 * node2 = nodes1.get(i); Connector conn = new Connector(mtApplication,
		 * scene, node1, node2); conectors2.add(conn); addChild(conn);
		 * 
		 * } } /* for (int i = 0; i < 10; i++) { if (returnTrueOrFalse(50)) { //
		 * Initialize Node connectors x = (mtApplication.width -
		 * mtApplication.width / 8) - (i * 125); y = (int) (mtApplication.height
		 * / 2 - (Math.random() * 300 + 1) + (Math .random() * 300 + 1)); width
		 * = 60; height = 60; Node node = new Node(mtApplication, scene, x, y,
		 * width, height); nodes.add(node); } } for (int i = 0; i <
		 * nodes.size(); i++) { if (i != 0) { // Initialize connector
		 * coordinates Node node1 = nodes.get(i - 1); Node node2 = nodes.get(i);
		 * Connector conn = new Connector(mtApplication, scene, node1, node2);
		 * conectors.add(conn); addChild(conn);
		 * 
		 * } }
		 */
		for (Connector connector : connectors) {
			addChild(connector);
		}
		for (Node node : nodes) {
			addChild(node);
		}
		for (Node node : subNodes) {
			addChild(node);
		}

	}

	public boolean returnTrueOrFalse(int chanseOfTrue) {
		int rand = (int) (Math.random() * 100 + 1);
		boolean trueOrFalse = false;
		// chanseOfTrue
		if (rand <= chanseOfTrue) {
			trueOrFalse = true;
		} else {
			trueOrFalse = false;
		}
		return trueOrFalse;
	}
	
	public int generatePosition(int currentPosition) {
		int newPosition = currentPosition - (int) (Math.random() * 100 + 1);
		return newPosition;
	}

}
