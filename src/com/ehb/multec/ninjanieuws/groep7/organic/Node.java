package com.ehb.multec.ninjanieuws.groep7.organic;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class Node extends MTEllipse {
	private AbstractScene scene;
	private Vector3D centerpoint;
	private int x;
	private int y;
	private int width;
	private int height;
	private PImage texture;

	public Node(MTApplication mtApplication, AbstractScene scene, int x, int y,int width, int height) {
		super(mtApplication, new Vector3D(x, y), width, height);
		// node.setFillColor(new MTColor(100, 100, 255, 150)););
		this.scene = scene;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		texture = mtApplication.loadImage(MT4jSettings.getInstance()
				.getDefaultImagesPath() + "test.png");
		setNoStroke(true);
		setTexture(texture);
		// node.setFillColor(new MTColor(100, 100, 255, 150));
	}
	
	@Override
	public void updateComponent(long timeDelta) {
		super.updateComponent(timeDelta);

		setPositionGlobal(getCenterPointGlobal());
		
		centerpoint = this.getCenterPointGlobal();
		x = (int) centerpoint.x;
		y = (int) centerpoint.y;
		//System.out.println(centerpoint.x);
	}


	public AbstractScene getScene() {
		return scene;
	}

	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
