package com.ehb.multec.ninajnieuws.groep7.background;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;


public class BackgroundManager {

	private MTApplication mtApplication;
	private AbstractScene scene;
	private int dx, dy;
	private MTColor bgColor, ellipseColor;
	private ArrayList<HUDElement> HUDElements = new ArrayList<HUDElement>();
	
	public BackgroundManager(MTApplication mtApplication, AbstractScene scene, MTColor bgColor, MTColor ellipseColor, int dx, int dy) {
		this.mtApplication = mtApplication;
		this.scene = scene;
		this.dx = dx;
		this.dy = dy;
		this.bgColor = bgColor;
		this.ellipseColor = ellipseColor;
	}
	
	public void drawBackGround() {
		scene.setClearColor(bgColor);
		MTEllipse bgCirkel;
		
		for (int i = 0; i <= mtApplication.width / dx; i++) {
			for (int j = 0; j <= mtApplication.height / dy; j++) {
				double jX = j;
				int v = i * dx;
				int w = j * dy;
				
				if ((jX % 2) == 0) {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v, w), 4, 4);
				} else {
					bgCirkel = new MTEllipse(mtApplication, new Vector3D(v + dy, w), 4, 4);
				}
				bgCirkel.setFillColor(ellipseColor);
				
				for (HUDElement element : HUDElements) {
					int[][] coordinates = element.getCoordinates();
					
					for (int k = 0; k < coordinates.length; k++) {
						if (coordinates[k][0] == i && coordinates[k][1] == j) {
							bgCirkel.setFillColor(element.getElementColor());
							break;
						}
					}
				}
				bgCirkel.setNoStroke(true);
				bgCirkel.removeAllGestureEventListeners();
				scene.getCanvas().addChild(bgCirkel);
			}
		}
	}
	
	public void addHUDElement(HUDElement hudElement) {
		HUDElements.add(hudElement);
	}
	
	public void removeHUDElement(int index) {
		HUDElements.remove(index);
	}
}
