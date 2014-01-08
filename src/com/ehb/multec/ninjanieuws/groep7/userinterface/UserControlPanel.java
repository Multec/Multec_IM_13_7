package com.ehb.multec.ninjanieuws.groep7.userinterface;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.camera.Icamera;
import org.mt4j.util.math.Vector3D;

import com.ehb.multec.ninjanieuws.groep7.background.UserControlPanelHUDElement;
import com.ehb.multec.ninjanieuws.groep7.eventlisteners.UCPDragEventListener;

import processing.core.PApplet;
import processing.core.PImage;

public class UserControlPanel extends MTComponent {

	public UserControlPanel(PApplet pApplet, UserControlPanelHUDElement ucpHudElement, int relTranslateX, int relTranslateY) {
		super(pApplet);
		
		pApplet.imageMode(PApplet.CENTER);
		PImage image = pApplet.loadImage("data/images/User-Panel-With-Items.png");
		MTImage basicLayOut = new MTImage(image, pApplet);
		basicLayOut.getStyleInfo().isNoStroke();
		
		int newPositionX = ucpHudElement.getCentreX() + relTranslateX;
		int newPositionY = ucpHudElement.getCentreY() + relTranslateY;
		
		basicLayOut.setPositionRelativeToParent(new Vector3D(newPositionX, newPositionY));
		basicLayOut.setNoFill(true);
		basicLayOut.setNoStroke(true);
		basicLayOut.unregisterAllInputProcessors();
		basicLayOut.removeAllGestureEventListeners();
		basicLayOut.registerInputProcessor(new DragProcessor(pApplet));
		basicLayOut.addGestureListener(DragProcessor.class, new UCPDragEventListener(this, newPositionX, newPositionY, pApplet));
		
		this.addChild(basicLayOut);
	}

	public UserControlPanel(PApplet pApplet, String name) {
		super(pApplet, name);
		// TODO Auto-generated constructor stub
	}

	public UserControlPanel(PApplet pApplet, Icamera attachedCamera) {
		super(pApplet, attachedCamera);
		// TODO Auto-generated constructor stub
	}

	public UserControlPanel(PApplet pApplet, String name, Icamera attachedCamera) {
		super(pApplet, name, attachedCamera);
		// TODO Auto-generated constructor stub
	}

}
