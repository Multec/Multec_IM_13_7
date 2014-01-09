package com.ehb.multec.ninjanieuws.groep7.movies;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;

public class MainPlayer extends MTComponent {
	private MTApplication mtApplication;

	public MainPlayer(MTApplication mtApplication) {
		super(mtApplication);
		this.mtApplication = mtApplication;
		drawBackground();
	}
	public void drawBackground(){
		// Default x and y positions
		int marginX = 100;
		int marginY = 21;
		int playerHeight = 102;
		MTRectangle bg = new MTRectangle(marginX, marginY, this.mtApplication.width-(marginX*2), playerHeight, this.mtApplication);
		bg.removeAllGestureEventListeners();
		bg.setNoStroke(true);
		this.addChild(bg);
		
		/*
		for (int i = 0; i < array.length; i++) {
			
		}
		*/
	}
}
