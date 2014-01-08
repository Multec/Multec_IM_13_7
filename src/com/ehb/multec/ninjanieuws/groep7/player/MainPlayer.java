package com.ehb.multec.ninjanieuws.groep7.player;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.sceneManagement.AbstractScene;

public class MainPlayer {
	private MTApplication mtApplication;
	private AbstractScene scene;

	public MainPlayer(MTApplication mtApplication, AbstractScene scene) {
		this.mtApplication = mtApplication;
		this.scene = scene;
	}
	public void drawBackground(){
		// Default x and y positions
		int marginX = 100;
		int marginY = 21;
		int playerHeight = 102;
		MTRectangle bg = new MTRectangle(marginX, marginY, this.mtApplication.width-(marginX*2), playerHeight, this.mtApplication);
		scene.getCanvas().addChild(bg);
	}
	public void setScene(AbstractScene scene) {
		this.scene = scene;
	}
}
