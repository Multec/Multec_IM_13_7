package com.ehb.multec.ninjanieuws.groep7.eventlisteners;

import org.mt4j.components.MTComponent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;

public class UCPDragEventListener implements IGestureEventListener {

	MTComponent ucp;
	Vector3D center;
	PApplet pApplet;
	
	public UCPDragEventListener(MTComponent ucp, int centreX, int centreY, PApplet pApplet) {
		this.ucp = ucp;
		this.center = new Vector3D(centreX, centreY);
		this.pApplet = pApplet;
	}

	@Override
	public boolean processGestureEvent(MTGestureEvent ge) {
		DragEvent de = (DragEvent) ge;
		ucp.rotateZ(center, angleBetweenWithAbsoluteZero(de.getFrom(), de.getTo(), center) * turnDirectionAroundCenter(de.getFrom(), de.getTo(), center));		
		return false;
	}
	
	/**
	 * @param B The first vector
	 * @param C The second vector
	 * @param O The point
	 * @return The size of the corner between B and C
	 */
	private float angleBetweenWithAbsoluteZero(Vector3D B, Vector3D C, Vector3D O) {
		float o = B.distance2D(C);
		float b = C.distance2D(O);
		float c = O.distance2D(B);
		
		if (b == 0 || c == 0) {
			return 0;
		}
		
		double cosAlpha = ((-Math.pow(o, 2) + Math.pow(b, 2) + Math.pow(c, 2)) / (2*b*c));
		if (cosAlpha > 1) {
			cosAlpha = 1;
		}
		double alpha = Math.acos(cosAlpha);
		
		return (float)(alpha * 180 / Math.PI);
	}
	
	/**
	 * @param v1 The first vector in a coordinate system
	 * @param v2 The second vector in a coordinate system
	 * @param center The center point of the circle
	 * @return The rotation direction
	 */
	public int turnDirectionAroundCenter(Vector3D v1, Vector3D v2, Vector3D center) {
		Vector3D axisX = new Vector3D(this.center.getAdded(new Vector3D(1, 0)));
		if (angleBetweenWithAbsoluteZero(axisX, v1, center) < angleBetweenWithAbsoluteZero(axisX, v2, center)) {
			return -1;
		} else if (angleBetweenWithAbsoluteZero(axisX, v1, center) > angleBetweenWithAbsoluteZero(axisX, v2, center)) {
			return 1;
		}
		return 0;
	}

}
