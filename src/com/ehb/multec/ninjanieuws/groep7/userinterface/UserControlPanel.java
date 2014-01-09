package com.ehb.multec.ninjanieuws.groep7.userinterface;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.util.camera.Icamera;
import org.mt4j.util.math.Vector3D;

import com.ehb.multec.ninjanieuws.groep7.background.UserControlPanelHUDElement;
import com.ehb.multec.ninjanieuws.groep7.eventlisteners.UCPDragEventListener;

import processing.core.PApplet;
import processing.core.PImage;

public class UserControlPanel extends MTComponent {
	private int newPositionX;
	private int newPositionY;
	private MTImage basicLayOut;
	private MTEllipse touchArea;
	private UserControlPanelHUDElement ucpHudElement;
	private PApplet pApplet;
	private boolean isActive = false;
	
	public UserControlPanel(PApplet pApplet, UserControlPanelHUDElement ucpHudElement, int relTranslateX, int relTranslateY) {
		super(pApplet);
		this.ucpHudElement = ucpHudElement;
		this.pApplet = pApplet;
		
		pApplet.imageMode(PApplet.CENTER);
		PImage image = pApplet.loadImage("data/images/User-Panel-With-Items.png");
		this.basicLayOut = new MTImage(image, pApplet);
		
		newPositionX = ucpHudElement.getCentreX() + relTranslateX;
		newPositionY = ucpHudElement.getCentreY() + relTranslateY;
		
		basicLayOut.setPositionRelativeToParent(new Vector3D(newPositionX, newPositionY + 9000, 0));
		basicLayOut.setNoFill(true);
		basicLayOut.setNoStroke(true);
		basicLayOut.unregisterAllInputProcessors();
		basicLayOut.removeAllGestureEventListeners();
		basicLayOut.registerInputProcessor(new DragProcessor(pApplet));
		basicLayOut.addGestureListener(DragProcessor.class, new UCPDragEventListener(this, newPositionX, newPositionY, pApplet));
		
		this.addChild(basicLayOut);
		drawTouchArea();
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
	
	public void drawTouchArea() {
		int x = ucpHudElement.getCentreX();
		int y = ucpHudElement.getCentreY();
		
		touchArea = new MTEllipse(pApplet, new Vector3D(x, y), 20, 20);
		touchArea.setNoFill(true);
		touchArea.setNoStroke(true);
		touchArea.unregisterAllInputProcessors();
		touchArea.removeAllGestureEventListeners();
		touchArea.registerInputProcessor(new TapProcessor(pApplet));
		touchArea.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent)ge;
				if (!te.isTapDown()) {
					moveUcp();
				}
				return false;
			}
		});
	}
	
	public void moveUcp() {
		if (!isActive) {
			basicLayOut.setPositionRelativeToParent(new Vector3D(newPositionX, newPositionY));
			isActive = true;
		} else {
			basicLayOut.setPositionRelativeToParent(new Vector3D(newPositionX, newPositionY + 9000));
			isActive = false;
		}
	}
	
	public void setTouchArea(MTEllipse touchArea) {
		this.touchArea = touchArea;
	}

	public MTEllipse getTouchArea() {
		return touchArea;
	}

	public MTImage getBasicLayOut() {
		return basicLayOut;
	}
}
