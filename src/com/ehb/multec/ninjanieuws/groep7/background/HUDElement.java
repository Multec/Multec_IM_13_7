package com.ehb.multec.ninjanieuws.groep7.background;

import java.util.ArrayList;
import org.mt4j.util.MTColor;

public class HUDElement {
	protected String name;
	protected ArrayList<int[]> coordinates = new ArrayList<int[]>();
	protected MTColor elementColor;
	protected boolean active = false;
	
	public HUDElement(MTColor elementColor, String name) {
		this.name = name;
		this.elementColor = elementColor;
	}
	
	public void translate(int v, int w) {
		for (int i = 0; i < coordinates.size(); i++) {
			int[] tempHUDElement = coordinates.get(i);
			tempHUDElement[0] += v;
			if (w % 2 == 0) {
				tempHUDElement[1] += w;
			} else {
				tempHUDElement[1] += (w - 1);
			}
		}
	}

	public String getName() {
		return name;
	}

	public MTColor getElementColor() {
		return elementColor;
	}

	public void setElementColor(MTColor elementColor) {
		this.elementColor = elementColor;
	}
	
	public ArrayList<int[]> getCoordinates() {
		return coordinates;
	}
	
	public void addCoordinate(int[] coordinate) {
		coordinates.add(coordinate);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
