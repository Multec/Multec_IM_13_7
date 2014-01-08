package com.ehb.multec.ninjanieuws.groep7.userinterface;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.util.camera.Icamera;

import processing.core.PApplet;

public class UserControlPanel extends MTComponent {

	public UserControlPanel(PApplet pApplet) {
		super(pApplet);
		//MTEllipse circle = new MTEllipse(pApplet, centerPoint, radiusX, radiusY);
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
