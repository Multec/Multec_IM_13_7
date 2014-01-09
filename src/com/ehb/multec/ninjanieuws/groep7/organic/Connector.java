package com.ehb.multec.ninjanieuws.groep7.organic;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTLine;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vertex;

import processing.core.PGraphics;

public class Connector extends MTLine {
	private AbstractScene scene;
	private int startPointX;
	private int startPointY;
	private int endPointX;
	private int endPointY;

	private Node node1;
	private Node node2;

	public Connector(MTApplication mtApplication, AbstractScene scene, Node node1, Node node2) {
		super(mtApplication, new Vertex(node1.getX(), node1.getY()), new Vertex(node2.getX(), node2.getY()));
		this.scene = scene;
		this.node1 = node1;
		this.node2 = node2;
		this.startPointX = node1.getX();
		this.startPointY = node1.getY();
		this.endPointX = node2.getX();
		this.endPointY = node2.getY();
		this.setStrokeColor(new MTColor(0, 226, 224, 60));
		this.setStrokeWeight(3);
		this.removeAllGestureEventListeners();

		// setUseDirectGL(false);
	}

	@Override
	public void updateComponent(long timeDelta) {
		super.updateComponent(timeDelta);

		setVertices(new Vertex[] { new Vertex(node1.getX(), node1.getY()), new Vertex(node2.getX(), node2.getY()) });

		startPointX = node1.getX();
		startPointY = node1.getY();
		endPointX = node2.getX();
		endPointY = node2.getY();
		//System.out.println(startPointX);
	}

	@Override
	public void drawComponent(PGraphics g) {
		// TODO Auto-generated method stub
		super.drawComponent(g);
	}

	public AbstractScene getScene() {
		return scene;
	}

	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}

	public int getStartPointX() {
		return startPointX;
	}

	public void setStartPointX(int startPointX) {
		this.startPointX = startPointX;
	}

	public int getStartPointY() {
		return startPointY;
	}

	public void setStartPointY(int startPointY) {
		this.startPointY = startPointY;
	}

	public int getEndPointX() {
		return endPointX;
	}

	public void setEndPointX(int endPointX) {
		this.endPointX = endPointX;
	}

	public int getEndPointY() {
		return endPointY;
	}

	public void setEndPointY(int endPointY) {
		this.endPointY = endPointY;
	}

	public Node getNode1() {
		return node1;
	}

	public Node getNode2() {
		return node2;
	}
}
