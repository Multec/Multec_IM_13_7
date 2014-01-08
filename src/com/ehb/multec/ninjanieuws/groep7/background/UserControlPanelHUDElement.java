package com.ehb.multec.ninjanieuws.groep7.background;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

public class UserControlPanelHUDElement extends HUDElement {

	private MTApplication mtApplication;
	private int centreV, centreW;
	private MTEllipse touchArea;

	public UserControlPanelHUDElement(MTColor elementColor, String name, MTApplication mtApplication, int centreV, int centreW) {
		super(elementColor, name);
		this.mtApplication = mtApplication;
		this.centreV = centreV;
		this.centreW = centreW;
	}
	
	private void drawTouchArea() {
		int x = getCentreX();
		int y = getCentreY();
		touchArea = new MTEllipse(mtApplication, new Vector3D(x, y), 20, 20);
		touchArea.setFillColor(new MTColor((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		touchArea.setStrokeColor(new MTColor((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		touchArea.unregisterAllInputProcessors();
		touchArea.removeAllGestureEventListeners();
		touchArea.registerInputProcessor(new TapProcessor(mtApplication));
		touchArea.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent)ge;
				if (!te.isTapDown()) {
					
				}
				return false;
			}
		});
		
	}
	
	@Override
	public void translate(int v, int w) {
		centreV += v;
		centreW += w;
		for (int i = 0; i < coordinates.size(); i++) {
			int[] tempHUDElement = coordinates.get(i);
			tempHUDElement[0] += v;
			if (w % 2 == 0) {
				tempHUDElement[1] += w;
			} else {
				tempHUDElement[1] += (w - 1);
				centreW -= 1;
			}
		}
		drawTouchArea();
	}
		
	public int getCentreX() {
		int dx = BackgroundManager.getDx();
		return centreV * dx;
	}

	public int getCentreY() {
		return centreW * BackgroundManager.getDy() + BackgroundManager.getDy();
	}

	public int getCentreV() {
		return centreV;
	}

	public void setCentreV(int centreV) {
		this.centreV = centreV;
	}

	public int getCentreW() {
		return centreW;
	}

	public void setCentreW(int centreW) {
		this.centreW = centreW;
	}

	public MTEllipse getTouchArea() {
		return touchArea;
	}

	public void setTouchArea(MTEllipse touchArea) {
		this.touchArea = touchArea;
	}

}
