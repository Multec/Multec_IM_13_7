package com.ehb.multec.ninjanieuws.groep7.background;

import org.mt4j.MTApplication;
import org.mt4j.util.MTColor;

import com.ehb.multec.ninjanieuws.groep7.userinterface.UserControlPanel;

public class UserControlPanelHUDElement extends HUDElement {

	private MTApplication mtApplication;
	private int centerV, centerW;
	private UserControlPanel UCP;

	public UserControlPanelHUDElement(MTColor elementColor, String name, MTApplication mtApplication ,int centreV, int centreW) {
		super(elementColor, name);
		this.mtApplication = mtApplication;
		this.centerV = centreV;
		this.centerW = centreW;
	}
	
	@Override
	public void translate(int v, int w) {
		centerV += v;
		centerW += w;
		for (int i = 0; i < coordinates.size(); i++) {
			int[] tempHUDElement = coordinates.get(i);
			tempHUDElement[0] += v;
			if (w % 2 == 0) {
				tempHUDElement[1] += w;
			} else {
				tempHUDElement[1] += (w - 1);
				centerW -= 1;
			}
		}
		
		// UCP's
		UCP = new UserControlPanel(mtApplication, 
				this, 0, 100
				/*-50, 50 + 44*/);
		
//		UserControlPanel UCP2 = new UserControlPanel(mtApplication, 
//				(UserControlPanelHUDElement)bgManager.selectHUDElement("ucp2"), 0, 0
//				/*0, 150*/);
//		UserControlPanel UCP3 = new UserControlPanel(mtApplication, 
//				(UserControlPanelHUDElement)bgManager.selectHUDElement("ucp3"), 0, 0
//				/*50, 50 + 44*/);
//		this.getCanvas().addChild(UCP1);
//		this.getCanvas().addChild(UCP2);
//		this.getCanvas().addChild(UCP3);
	}
		
	public int getCentreX() {
		int dx = BackgroundManager.getDx();
		return centerV * dx;
	}

	public int getCentreY() {
		return centerW * BackgroundManager.getDy() + BackgroundManager.getDy();
	}

	public int getCentreV() {
		return centerV;
	}

	public void setCentreV(int centreV) {
		this.centerV = centreV;
	}

	public int getCentreW() {
		return centerW;
	}

	public void setCentreW(int centreW) {
		this.centerW = centreW;
	}

	public UserControlPanel getUCP() {
		return UCP;
	}

}
